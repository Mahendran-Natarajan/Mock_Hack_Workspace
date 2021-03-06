package com.scrotify.repository;

import com.scrotify.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Customer Repository has one method.
 *
 * @author anishaR
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    /**
     * Customer Repository has one method and it is finding by the mobile No.
     *
     * @param mobileNo the mobile no
     * @return optional optional
     */
    Optional<Customer> findByCustomerMobileNo(Long customerMobileNo);

    /**
     * Find by account type customer.
     *
     * @param accountType the account type
     * @return the customer
     */
    Customer findByAccountType(String accountType);


    /**
     * Find by customer id optional.
     *
     * @param customerId the customer id
     * @return the optional
     */
    Optional<Customer> findByCustomerId(Long customerId);

}