package com.pusio.example.budgetingaid.api.domain;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Balance {
	@NotNull
	private final Long amount;
	@NotEmpty
	private final String registerName;
}
