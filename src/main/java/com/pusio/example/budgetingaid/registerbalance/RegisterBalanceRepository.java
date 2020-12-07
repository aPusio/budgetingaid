package com.pusio.example.budgetingaid.registerbalance;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterBalanceRepository extends CrudRepository<RegisterBalance, UUID> {
}
