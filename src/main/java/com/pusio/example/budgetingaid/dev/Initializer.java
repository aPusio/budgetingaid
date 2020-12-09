package com.pusio.example.budgetingaid.dev;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.pusio.example.budgetingaid.api.Recharge;
import com.pusio.example.budgetingaid.api.TransactionService;
import com.pusio.example.budgetingaid.register.Register;
import com.pusio.example.budgetingaid.register.RegisterRepository;
import com.pusio.example.budgetingaid.registerbalance.RegisterBalance;

import lombok.RequiredArgsConstructor;

@Component
@Profile("dev")
@RequiredArgsConstructor
public class Initializer implements CommandLineRunner {
	private final RegisterRepository registerRepository;

	private final TransactionService transactionService;

	@Override
	public void run(String... args) throws Exception {
		final Register wallet = createRegister("Wallet", 1000L);
		final Register savings = createRegister("Savings", 5000L);
		createRegister("Insurance policy", 0L);
		createRegister("Food expenses", 0L);

//		transactionService.exchange(wallet, savings, 10L);
		final Recharge recharge = new Recharge();
		recharge.setRegisterName(wallet.getName());
		recharge.setAmount(20L);
		transactionService.recharge(recharge);
	}

	private Register createRegister(final String name, final Long amount) {
		RegisterBalance amountBalance = new RegisterBalance();
		amountBalance.setAmount(amount);
		Register register = new Register(name, amountBalance);
		return registerRepository.save(register);
	}
}
