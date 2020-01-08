package com.scrotify.repository;

import com.scrotify.entity.Account;
import com.scrotify.entity.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("select acc.availableBalance from Account acc where acc.customer.customerId = :custId and acc.accountStatus = :accountStatus and acc.accountType = :accountType")
    double findByAccountBalance(@Param("custId") Long custId, @Param("accountStatus") String accountStatus, @Param("accountType") String accountType);

    @Query("select acc from Account acc where acc.customer.customerId = :custId and acc.accountStatus = :accountStatus and acc.accountType = :accountType")
    public Account findByCustomerByAccount(@Param("custId") Long custId, @Param("accountStatus") String accountStatus, @Param("accountType") String accountType);

    //@Query("select acc from Account acc where acc.customer.customerId != :custId and acc.accountStatus = :accountStatus and acc.accountType = :accountType")
    //List<Account> findAllByAccountNotCustomer(@Param("custId") Long custId, @Param("accountStatus") String accountStatus, @Param("accountType") String accountType);
    Optional<List<Account>> findAllByCustomerCustomerId(Long customerId); //get only customer

     //Optional<List<Account>> findAllCustomer();

    //List<Account> findAllCustomer();

    Account findByAccountType(String accountType);

    @Query("select acc from Account acc where acc.customer.customerId = :customerId")
    Account findAccountByCustomer(@Param("customerId") Long customerId);

    Optional<Account> findByCustomer(Optional<Customer> customer);
}