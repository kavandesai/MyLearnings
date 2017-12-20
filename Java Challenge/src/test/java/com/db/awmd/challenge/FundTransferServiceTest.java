package com.db.awmd.challenge;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.service.AccountsService;
import com.db.awmd.challenge.service.FundTransferService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FundTransferServiceTest {
	@Autowired
	private AccountsService accountsService;
	
	@Autowired
	private FundTransferService fundTransferService;
	
	@Test
	public void fundTransfer() throws Exception {
		Account fromAccount = new Account("Id-789",new BigDecimal(2000));
	    this.accountsService.createAccount(fromAccount);

	    assertThat(this.accountsService.getAccount("Id-789")).isEqualTo(fromAccount);
	    
		Account toAccount = new Account("Id-456",new BigDecimal(2000));
	    this.accountsService.createAccount(toAccount);

	    assertThat(this.accountsService.getAccount("Id-456")).isEqualTo(toAccount);
	    
	    fundTransferService.initiateTransfer(fromAccount, toAccount, new BigDecimal(500));
	    assertThat(this.accountsService.getAccount("Id-789").getBalance()).isEqualByComparingTo("1500");
	    assertThat(this.accountsService.getAccount("Id-456").getBalance()).isEqualByComparingTo("2500");

	    
	    
	}
	
	
}
