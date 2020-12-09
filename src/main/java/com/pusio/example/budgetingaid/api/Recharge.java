package com.pusio.example.budgetingaid.api;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recharge {

	@NotEmpty
	private String registerName;

	@Size(min = 1)
	@NotNull
	private Long amount;
}
