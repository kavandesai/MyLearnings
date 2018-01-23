package com.db.awmd.challenge.service.fundtransfer;

import java.math.BigDecimal;

import com.db.awmd.challenge.domain.Account;

public interface Fundtransfer {
	public boolean transferFunds(Account accountFrom,Account accountTo,BigDecimal amount) throws InterruptedException;
}
