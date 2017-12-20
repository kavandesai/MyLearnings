package com.db.awmd.challenge.domain;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;



public final class Account {

  @NotNull
  @NotEmpty
  @Getter
  private final String accountId;

  @NotNull
  @Min(value = 0, message = "Initial balance must be positive.")
  @Getter
  private BigDecimal balance;
  
  public Account(String accountId) {
    this.accountId = accountId;
    this.balance = BigDecimal.ZERO;
  }
  

  @JsonCreator
  public Account(@JsonProperty("accountId") String accountId,
    @JsonProperty("balance") BigDecimal balance) {
    this.accountId = accountId;
    this.balance = balance;
  }
  
  public void debit (BigDecimal amount) {
	  this.balance = balance.subtract(amount);
  }
  
  public void credit (BigDecimal amount) {
	  this.balance = balance.add(amount);
  }
  
  
}
