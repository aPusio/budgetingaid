package com.pusio.example.budgetingaid.register;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RegisterServiceTest {
	@Mock
	private RegisterRepository registerRepository;

	@InjectMocks
	private RegisterService registerService;

	@Test
	public void correctNameShouldReturnExistingObject() {
		//given
		String name = "name";
		Register register = new Register();

		//when
		when(registerRepository.findById("name")).thenReturn(Optional.of(register));
		final Register returnedRegister = registerService.extractIfExists("name");

		//then
		assertEquals(register, returnedRegister);
	}

	@Test
	public void incorrectNameShouldReturnException() {//given
		//when
		when(registerRepository.findById("name")).thenReturn(Optional.empty());

		//then
		assertThrows(RegisterNotFoundException.class, () -> registerService.extractIfExists("name"));
	}

}