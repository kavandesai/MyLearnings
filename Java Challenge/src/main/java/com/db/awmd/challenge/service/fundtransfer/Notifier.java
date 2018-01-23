package com.db.awmd.challenge.service.fundtransfer;

import java.math.BigDecimal;

import com.db.awmd.challenge.domain.Account;

public interface Notifier {
	public void notify(Account accountFrom,Account accountTo,BigDecimal amountTransferd);
}
