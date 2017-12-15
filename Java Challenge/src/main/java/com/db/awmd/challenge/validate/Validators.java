package com.db.awmd.challenge.validate;

import java.math.BigDecimal;

import com.db.awmd.challenge.service.AccountsService;

public class Validators {
	
	public static String validateAccountIds(String fromAccountId,String toAccountId,AccountsService accountsService) {
		String message = "";
		
		if (accountsService.getAccount(fromAccountId) == null) {
			return "Invalid accountId "+ fromAccountId;
		}
		
		if (accountsService.getAccount(fromAccountId) == null) {
			return "Invalid accountId "+ toAccountId;
		}
		
		if (fromAccountId.equals(toAccountId)) {
			return "Fund can not be transfered in to same account, source and target account ids are same "+ toAccountId;
		}
		
		return message;
	}
	
	public static String validateTransferAmount (BigDecimal amountToTransfer) {
		String message = "";
		
		if (amountToTransfer == null || amountToTransfer.compareTo(new BigDecimal(0)) <= 0) {
			message = "Fund amount to transfer must be positive value, > 0";
		}
		
		return message;
		
	}

}
