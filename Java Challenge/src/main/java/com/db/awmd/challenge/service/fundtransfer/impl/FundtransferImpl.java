package com.db.awmd.challenge.service.fundtransfer.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.exception.InsufficientBalanceException;
import com.db.awmd.challenge.service.fundtransfer.Fundtransfer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FundtransferImpl implements Fundtransfer {

	@Override
	public boolean transferFunds(Account accountFrom, Account accountTo, BigDecimal amount) throws InterruptedException {
		
		  Object outerLock = accountFrom;
		  Object innerLock = accountTo;
		  if (accountFrom.getAccountId().compareTo(accountTo.getAccountId()) < 0) {
			  outerLock = accountTo;
			  innerLock = accountFrom;
		  }
		  synchronized (outerLock) {
			  
				  synchronized (innerLock) {
				
							if (accountFrom.getBalance().compareTo(amount) < 0) {
								log.error("Fund transfer failed, insufficent balance in source account "+accountFrom.getAccountId());
								throw new InsufficientBalanceException("Fund transfere failed, insufficent balance in source account "+accountFrom.getAccountId());
							}
				
							accountFrom.debit(amount);
							accountTo.credit(amount);
							return true;
					  } 
				  }
			  
	  }
	
}

