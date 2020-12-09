package com.pusio.example.budgetingaid.registerbalance;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterBalanceService {
	private final RegisterBalanceRepository repository;

	public RegisterBalance save(RegisterBalance registerBalance) {
		return repository.save(registerBalance);
	}
}
