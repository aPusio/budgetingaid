package com.pusio.example.budgetingaid.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pusio.example.budgetingaid.api.domain.Recharge;
import com.pusio.example.budgetingaid.api.domain.Transaction;
import com.pusio.example.budgetingaid.register.Register;
import com.pusio.example.budgetingaid.register.RegisterService;
import com.pusio.example.budgetingaid.registerbalance.RegisterBalance;
import com.pusio.example.budgetingaid.registerbalance.RegisterBalanceService;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

	@Mock
	private RegisterService registerService;

	@Mock
	private RegisterBalanceService registerBalanceService;

	@InjectMocks
	private TransactionService transactionService;

	@Test
	public void correctTransactionShouldTransferMoneyAndStoreData() {
		//given
		Transaction transaction = new Transaction("register1", "register2", 10L);
		final Register register = mockRegister(1000L, "register1");
		mockRegister(5000L, "register2");

//		when(registerService.extractIfExists("register1")).thenReturn(register);
		//when
		transactionService.transfer(transaction);
		final Register updatedRegister1 = registerService.extractIfExists("register1");
		Register updatedRegister2 = registerService.extractIfExists("register2");

		//then
		verify(registerBalanceService, times(1)).save(updatedRegister1.getBalance());
		verify(registerBalanceService, times(1)).save(updatedRegister2.getBalance());
		assertEquals(updatedRegister1.getBalance().getAmount(), 1010L);
		assertEquals(updatedRegister2.getBalance().getAmount(), 4990L);
	}

	@Test
	public void correctRechargeShouldTransferMoneyAndStoreData() {
		//given
		Recharge recharge = new Recharge("register1", 30L);
		mockRegister(1000L, "register1");

		//when
		transactionService.recharge(recharge);
		final Register register1 = registerService.extractIfExists("register1");

		//then
		verify(registerBalanceService, times(1)).save(register1.getBalance());
		assertEquals(register1.getBalance().getAmount(), 1030L);
	}

	private Register mockRegister(final Long amount, final String registerName) {
		RegisterBalance registerBalance = new RegisterBalance();
		registerBalance.setAmount(amount);
		final Register register = new Register(registerName, registerBalance);
		when(registerService.extractIfExists(registerName)).thenReturn(register);
		return register;
	}

}