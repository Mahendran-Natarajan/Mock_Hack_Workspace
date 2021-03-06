package com.scrotifybanking.payeemanagement.repository;

import com.scrotifybanking.payeemanagement.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Customer Repository has one method.
 *
 * @author anishaR
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Customer Repository has one method and it is finding by the mobile No.
     *
     * @param customerMobileNo the customer mobile no
     * @return optional optional
     */
    Customer findByCustomerMobileNo(Long customerMobileNo);

    /**
     * Find by customer id optional.
     * <p>
     * Find by customer id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Customer> findByCustomerId(Long id);
}