package com.pusio.example.budgetingaid.api.domain;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Recharge {

	@NotEmpty
	private final String registerName;

	@Size(min = 1)
	@NotNull
	private final Long amount;
}
