package com.scrotifybanking.payeemanagement.repository;

import com.scrotifybanking.payeemanagement.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Bank repository.
 */
@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {


    /**
     * Find by bank ifsc code contains optional.
     *
     * @param bankIfscCode the bank ifsc code
     * @return the optional
     */
    Optional<List<Bank>> findByBankIfscCodeContains(String bankIfscCode);


    /**
     * Find by bank name optional.
     *
     * @param bankName the bank name
     * @return the optional
     */
    Optional<Bank> findByBankName(String bankName);


    /**
     * Find by bank ifsc code optional.
     *
     * @param bankIfscCode the bank ifsc code
     * @return the optional
     */
    Optional<Bank> findByBankIfscCode(String bankIfscCode);

}
