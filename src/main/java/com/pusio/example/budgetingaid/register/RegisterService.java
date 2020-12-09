package com.pusio.example.budgetingaid.register;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterService {
	private final RegisterRepository registerRepository;

	public Register extractIfExists(String name) {
		return registerRepository.findById(name)
				   .orElseThrow(() -> new RegisterNotFoundException("Register not exists"));
	}

	public List<Register> findAll() {
		return registerRepository.findAll();
	}
}
