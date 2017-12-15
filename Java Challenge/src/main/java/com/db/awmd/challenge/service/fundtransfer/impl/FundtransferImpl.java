package com.db.awmd.challenge.service.fundtransfer.impl;

import java.math.BigDecimal;
import java.util.Random;

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
		
		int retryCount = 0; 
		  int maxRetryCount = 3;
		  final Random number = new Random(123L);
		  boolean transferSuccessful = false;
		  while (retryCount < maxRetryCount) {
		  if (accountFrom.lock().tryLock()) {
			  try {
				  if (accountTo.lock().tryLock()) {
				
					  try {
							if (accountFrom.getBalance().compareTo(amount) < 0) {
								log.error("Fund transfer failed, insufficent balance in source account "+accountFrom.getAccountId());
								throw new InsufficientBalanceException("Fund transfere failed, insufficent balance in source account "+accountFrom.getAccountId());
							}
				
							accountFrom.setBalance(accountFrom.getBalance().subtract(amount));
							accountTo.setBalance(accountTo.getBalance().add(amount));
							transferSuccessful = true;
							
							break;
					  } finally {
						  accountTo.lock().unlock();
					  }
				  }
			  } finally {
				  accountFrom.lock().unlock();
			  }
		  }
		  int n = number.nextInt(1000);
	      int delay = 1000 + n; 
	      Thread.sleep(delay);
	      retryCount ++;
		  }
		  return transferSuccessful; 
	  }
		
		  	  

}

