package com.pusio.example.budgetingaid.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Balance {
	private Long amount;
	private String registerName;
}
