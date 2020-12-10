package com.pusio.example.budgetingaid.api.domain;


import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Transaction {
	@NotEmpty
	private final String sourceRegisterName;
	@NotEmpty
	private final String targetRegisterName;
	@NotNull
	private final Long amount;
}
