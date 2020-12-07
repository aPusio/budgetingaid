package com.pusio.example.budgetingaid.money;


import java.util.UUID;

import com.pusio.example.budgetingaid.register.Register;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Transaction {
	private UUID transactionId;
	private Register source;
	private Register target;
	private AmountOfMoney amount;
}
