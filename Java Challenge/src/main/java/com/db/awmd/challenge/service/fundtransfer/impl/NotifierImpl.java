package com.db.awmd.challenge.service.fundtransfer.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.service.NotificationService;
import com.db.awmd.challenge.service.fundtransfer.Notifier;

import lombok.Getter;

@Component
public class NotifierImpl implements Notifier {
	
	@Autowired
	@Getter
	private NotificationService notificationService;
	
	@Override
	public void notify(Account accountFrom, Account accountTo, BigDecimal amountTransferd) {
		notificationService.notifyAboutTransfer(accountFrom, "Amount "
				+amountTransferd.toString()+" transfered to "+accountTo.getAccountId());
		notificationService.notifyAboutTransfer(accountTo, "Amount "
				+amountTransferd.toString()+" received from "+accountFrom.getAccountId());

	}

}
