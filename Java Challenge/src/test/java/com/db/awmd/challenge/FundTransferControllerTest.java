package com.db.awmd.challenge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.service.AccountsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FundTransferControllerTest {
	private MockMvc mockMvc;

	  @Autowired
	  private AccountsService accountsService;

	  @Autowired
	  private WebApplicationContext webApplicationContext;
	  
	  
	  @Before
	  public void prepareMockMvc() {
	    this.mockMvc = webAppContextSetup(this.webApplicationContext).build();

	    // Reset the existing accounts before each test.
	    accountsService.getAccountsRepository().clearAccounts();
	    
	  }
	  
	  @Test
	  public void transferFund() throws Exception {
		  this.mockMvc.perform(post("/v1/accounts").contentType(MediaType.APPLICATION_JSON)
	    	      .content("{\"accountId\":\"Id-123\",\"balance\":1000}")).andExpect(status().isCreated());

	    	    Account account = accountsService.getAccount("Id-123");
	    	    assertThat(account.getAccountId()).isEqualTo("Id-123");
	    	    assertThat(account.getBalance()).isEqualByComparingTo("1000");
	    	    
	    this.mockMvc.perform(post("/v1/accounts").contentType(MediaType.APPLICATION_JSON)
	  	    	      .content("{\"accountId\":\"Id-456\",\"balance\":2000}")).andExpect(status().isCreated());

	  	    	    account = accountsService.getAccount("Id-456");
	  	    	    assertThat(account.getAccountId()).isEqualTo("Id-456");
	  	    	    assertThat(account.getBalance()).isEqualByComparingTo("2000");
		  
		  
	    this.mockMvc.perform(post("/v1/fundTransfer").param("fromAccountId", "Id-123").contentType(MediaType.APPLICATION_JSON).param("toAccountId", "Id-456").param("fundtoTransfer", "500")).andExpect(status().isAccepted());
	    Account fromAccount = accountsService.getAccount("Id-123");
	    assertThat(fromAccount.getBalance()).isEqualByComparingTo("500");
	    Account toAccount = accountsService.getAccount("Id-456");
	    assertThat(toAccount.getBalance()).isEqualByComparingTo("2500");
	    
	  }
	  
	  @Test
	  public void sourceAndTargetSame() throws Exception {
		  this.mockMvc.perform(post("/v1/fundTransfer").contentType(MediaType.APPLICATION_JSON).param("fromAccountId", "Id-123").param("toAccountId", "Id-123").param("fundtoTransfer", "500")).andExpect(status().isBadRequest());
		  
	  }
	  
	  @Test
	  public void notEnoughBalance() throws Exception {
		  this.mockMvc.perform(post("/v1/fundTransfer").contentType(MediaType.APPLICATION_JSON).param("fromAccountId", "Id-123").param("toAccountId", "Id-456").param("fundtoTransfer", "50000")).andExpect(status().isBadRequest());
		  
	  }
	  
	  @Test
	  public void blankAccountId() throws Exception {
		  this.mockMvc.perform(post("/v1/fundTransfer").contentType(MediaType.APPLICATION_JSON).param("fromAccountId", "").param("toAccountId", "").param("fundtoTransfer", "50000")).andExpect(status().isBadRequest());
	  }
	  
	  @Test
		public void blankAmount() throws Exception {
		    
		  this.mockMvc.perform(post("/v1/fundTransfer").param("fromAccountId", "Id-123").contentType(MediaType.APPLICATION_JSON).param("toAccountId", "Id-456").param("fundtoTransfer", "")).andExpect(status().isBadRequest());		    
		}
	  
}
