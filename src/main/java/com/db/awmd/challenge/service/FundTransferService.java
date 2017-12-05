package com.db.awmd.challenge.service;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.exception.InsufficientBalanceException;
import com.db.awmd.challenge.repository.AccountsRepository;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FundTransferService {
	  @Getter
	  private final AccountsRepository accountsRepository;
	  
	  @Getter
	  private final NotificationService notificationService;

	  @Autowired
	  public FundTransferService(AccountsRepository accountsRepository,NotificationService notificationService) {
	      this.accountsRepository = accountsRepository;
	      this.notificationService = notificationService;
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
		  int retryCount = 0; 
		  int maxRetryCount = 3;
		  final Random number = new Random(123L);
		  while (retryCount < maxRetryCount) {
		  if (accountFrom.lock().tryLock()) {
			  try {
				  if (accountTo.lock().tryLock()) {
				
					  try {
							if (accountFrom.getBalance().compareTo(amount) < 0) {
								log.error("Fund transfere failed, insufficent balance in source account "+accountFrom.getAccountId());
								throw new InsufficientBalanceException("Fund transfere failed, insufficent balance in source account "+accountFrom.getAccountId());
							}
				
							accountFrom.debit(amount);
							accountTo.credit(amount);
							notificationService.notifyAboutTransfer(accountFrom, "Amount "
									+amount.toString()+" transfered to "+accountTo.getAccountId());
							notificationService.notifyAboutTransfer(accountTo, "Amount "
									+amount.toString()+" received from "+accountFrom.getAccountId());
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
		  
	  }
}
