package com.scrotify.repository;

import com.scrotify.entity.Account;
import com.scrotify.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Transaction repository.
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    /**
     * Find by account no list.
     *
     * @param accountNo the account no
     * @return the list
     */
    List<Transaction> findByAccountNo(Long accountNo);

    /**
     * Find top 5 by account order by transaction id desc list.
     *
     * @param accountDetails the account details
     * @return the list
     */
    List<Transaction> findTop5ByAccountNoOrderByTransactionIdDesc(Optional<Account> accountDetails);
}