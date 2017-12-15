package com.db.awmd.challenge.service;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.repository.AccountsRepository;
import com.db.awmd.challenge.service.fundtransfer.Fundtransfer;
import com.db.awmd.challenge.service.fundtransfer.Notifier;

import lombok.Getter;

@Service
public class FundTransferService {
	  @Getter
	  private final AccountsRepository accountsRepository;
	  
	  @Getter
	  private final Fundtransfer fundTransfer;
	  
	  @Getter
	  private final Notifier notifier;

	  @Autowired
	  public FundTransferService(AccountsRepository accountsRepository,Fundtransfer fundtransfer,Notifier notifier) {
	      this.accountsRepository = accountsRepository;
	      this.fundTransfer = fundtransfer;
	      this.notifier = notifier;
	  }
	  
	  /**
	   * Transfer funds from source Account to Target account
	   * We will make three attempt to transfer the funds.
	 * @param accountFrom
	 * @param accountTo
	 * @param amount
	 * @throws InterruptedException
	 */
	public void initiateTransfer(Account accountFrom,Account accountTo,BigDecimal amount) throws InterruptedException {
		  
		  boolean transferSuccessful = fundTransfer.transferFunds(accountFrom, accountTo, amount);
		  if (transferSuccessful) {
			  notifier.notify(accountFrom, accountTo, amount);
		  }
	}
		  
}
