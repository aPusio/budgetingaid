package com.pusio.example.budgetingaid.registerbalance;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterBalanceRepository extends JpaRepository<RegisterBalance, UUID> {
}
