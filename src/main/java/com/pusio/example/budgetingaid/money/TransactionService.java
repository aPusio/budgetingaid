package com.pusio.example.budgetingaid.money;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

	public void transfer(@Valid Transaction transaction) {
		log.info("trying to transfer {} from {} to {}", transaction.getSourceRegisterName(), transaction.getTargetRegisterName(), transaction.getAmount());
		final Register sourceRegister = registerService.extractIfExists(transaction.getSourceRegisterName());
		final Register targetRegister = registerService.extractIfExists(transaction.getTargetRegisterName());

		final Long amount = transaction.getAmount();
		exchange(sourceRegister, targetRegister, amount);
		log.info("transferred {} from {} to {}", amount, sourceRegister.getName(), targetRegister.getName());
	}

	@Transactional
	public void exchange(Register sourceRegister, Register targetRegister, Long amount) {
		loadRegister(sourceRegister, amount);
		loadRegister(targetRegister, -amount);
	}

	private void loadRegister(Register register, Long amount) {
		final RegisterBalance registerBalance = register.getBalance();
		final Long accountMoney = registerBalance.getAmount();
		//negative balance is allowed
		registerBalance.setAmount(accountMoney + amount);
		registerBalanceService.save(registerBalance);
	}

	public void recharge(@Valid Recharge recharge) {
		log.info("trying to recharge {} to {}", recharge.getRegisterName(), recharge.getAmount());
		final Register register = registerService.extractIfExists(recharge.getRegisterName());
		loadRegister(register, recharge.getAmount());
		log.info("recharged {} to {}", recharge.getRegisterName(), recharge.getAmount());
	}

	public List<Balance> balance() {
		log.info("checking balance");
		return registerService.findAll().stream()
				   .map(register ->
							new Balance(register.getBalance().getAmount(), register.getName()))
				   .collect(Collectors.toList());
	}
}
