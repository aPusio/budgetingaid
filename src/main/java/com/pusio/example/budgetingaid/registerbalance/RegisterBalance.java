package com.pusio.example.budgetingaid.registerbalance;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.pusio.example.budgetingaid.register.Register;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RegisterBalance {
	@Id
	@GeneratedValue
	private UUID id;

	private Long amount;

	@OneToOne(mappedBy = "balance", optional = false)
	private Register register;
}
