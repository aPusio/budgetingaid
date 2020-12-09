package com.pusio.example.budgetingaid.money;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pusio.example.budgetingaid.register.Register;
import com.pusio.example.budgetingaid.register.RegisterService;
import com.pusio.example.budgetingaid.registerbalance.RegisterBalance;
import com.pusio.example.budgetingaid.registerbalance.RegisterBalanceService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {

	private final RegisterService registerService;

	private final RegisterBalanceService registerBalanceService;

	public void transfer(Transaction transaction) {
		log.info("trying to transfer {} from {} to {}", transaction.getSourceRegisterName(), transaction.getTargetRegisterName(), transaction.getAmount());
		final Register sourceRegister = registerService.extractIfExists(transaction.getSourceRegisterName());
		final Register targetRegister = registerService.extractIfExists(transaction.getTargetRegisterName());

		final Long amount = transaction.getAmount();
		transferMoney(sourceRegister, targetRegister, amount);
		log.info("transferred {} from {} to {}", amount, sourceRegister.getName(), targetRegister.getName());
	}

	@Transactional
	public void transferMoney(Register sourceRegister, Register targetRegister, Long amount) {
		changeAmount(sourceRegister, amount);
		changeAmount(targetRegister, -amount);
	}

	private void changeAmount(Register register, Long amount) {
		final RegisterBalance registerBalance = register.getBalance();
		final Long accountMoney = registerBalance.getAmount();
		//negative balance is allowed
		registerBalance.setAmount(accountMoney + amount);
		registerBalanceService.save(registerBalance);
	}
}
