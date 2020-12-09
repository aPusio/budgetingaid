package com.pusio.example.budgetingaid.register;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.pusio.example.budgetingaid.registerbalance.RegisterBalance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "USER_REGISTER")
public class Register {
	@Id
	@NotEmpty
	private String name;

	@OneToOne(optional = false, cascade = CascadeType.ALL)
	private RegisterBalance balance;

}
