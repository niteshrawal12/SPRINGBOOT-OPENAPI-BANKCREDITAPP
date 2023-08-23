package com.openapi.example.repository;


import com.openapi.example.entity.BankCredit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankCreditRepository extends JpaRepository<BankCredit, Long> {
}