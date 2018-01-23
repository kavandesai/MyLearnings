package com.db.awmd.challenge.web;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.exception.InsufficientBalanceException;
import com.db.awmd.challenge.service.AccountsService;
import com.db.awmd.challenge.service.FundTransferService;
import com.db.awmd.challenge.validate.Validators;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/fundTransfer")
@Slf4j
public class FundTransferController {
	
	private final AccountsService accountsService;
	
	private final FundTransferService fundTransferService;
	
	@Autowired
	public FundTransferController(AccountsService accountsService, FundTransferService fundTransferService) {
		this.accountsService = accountsService;
		this.fundTransferService = fundTransferService;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> fundTransfer(@RequestParam @NotNull @NotBlank String fromAccountId,@NotNull @NotBlank @RequestParam String toAccountId,@NotNull @Valid @RequestParam BigDecimal fundtoTransfer) {
		
		String message = Validators.validateAccountIds(fromAccountId, toAccountId,accountsService);
		if (!message.equals("")) {
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		
		message = Validators.validateTransferAmount( fundtoTransfer);
		
		if (!message.equals("")) {
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		
		Account fromAccount = accountsService.getAccount(fromAccountId);
		Account toAccount = accountsService.getAccount(toAccountId);
		
		log.info("Initiating fund transfer..");
		try {
			fundTransferService.initiateTransfer(fromAccount, toAccount, fundtoTransfer);
		} catch (InsufficientBalanceException ie) {
			log.error(ie.getMessage());
			return new ResponseEntity<>(ie.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		
	}
	
	
}
