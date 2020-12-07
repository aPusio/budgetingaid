package com.pusio.example.budgetingaid.dev;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.pusio.example.budgetingaid.money.AmountOfMoney;
import com.pusio.example.budgetingaid.register.Register;
import com.pusio.example.budgetingaid.register.RegisterRepository;
import com.pusio.example.budgetingaid.registerbalance.RegisterBalance;

import lombok.RequiredArgsConstructor;

@Component
@Profile("dev")
@RequiredArgsConstructor
public class Initializer implements CommandLineRunner {
	private final RegisterRepository registerRepository;

	@Override
	public void run(String... args) throws Exception {
		createRegister("Wallet", 1000L);
		createRegister("Savings", 5000L);
		createRegister("Insurance policy", 0L);
		createRegister("Food expenses", 0L);
	}

	private void createRegister(final String name, final Long amount) {
		RegisterBalance amountBalance = new RegisterBalance();
		amountBalance.setAmount(new AmountOfMoney(amount));
		Register register = new Register(null, name, amountBalance);
		registerRepository.save(register);
	}
}
