package com.pusio.example.budgetingaid.money;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class TransactionController {

	private final TransactionService transactionService;

	@PostMapping("recharge")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void transferMoney(@Valid Transaction transaction) {
		transactionService.transfer(transaction);
	}
}
