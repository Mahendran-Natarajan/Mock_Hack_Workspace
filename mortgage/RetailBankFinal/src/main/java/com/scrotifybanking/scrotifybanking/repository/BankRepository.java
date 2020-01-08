package com.scrotifybanking.scrotifybanking.repository;

import com.scrotifybanking.scrotifybanking.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Long> {
    Optional<List<Bank>> findByBankIfscCodeContains(String bankIfscCode);
}
