package com.pusio.example.budgetingaid.api;


import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Transaction {
	@NotEmpty
	private String sourceRegisterName;
	@NotEmpty
	private String targetRegisterName;
	@NotNull
	private Long amount;
}
