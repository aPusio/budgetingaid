package com.pusio.example.budgetingaid.money;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PostMapping("transfer")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void recharge(@Valid Transaction transaction) {
		transactionService.transfer(transaction);
	}

	@PostMapping("recharge")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void recharge(@Valid Recharge recharge) {
		transactionService.recharge(recharge);
	}

	@GetMapping("balance")
	public List<Balance> balance() {
		return transactionService.balance();
	}
}
