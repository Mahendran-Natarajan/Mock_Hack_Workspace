package com.scrotifybanking.payeemanagement.repository;


import com.scrotifybanking.payeemanagement.entity.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Beneficiary repository.
 */
@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {

    /**
     * Find by customer id optional.
     *
     * @param customerId the customer id
     * @return the optional
     */
    Optional<Beneficiary> findByCustomerId(Long customerId);


    /**
     * Find by beneficiary account number beneficiary.
     *
     * @param beneficiaryAccountNo the beneficiary account no
     * @return the beneficiary
     */
    Beneficiary findByBeneficiaryAccountNumber(Long beneficiaryAccountNo);

    /**
     * Find by customer customer id list.
     *
     * @param customerId the customer id
     * @return the list
     */
    List<Beneficiary> findByCustomerCustomerId(Long customerId);

    /**
     * Delete by beneficiary id and customer customer id optional.
     *
     * @param beneficiaryId the beneficiary id
     * @param customerId    the customer id
     * @return the optional
     */
    Optional<Boolean> deleteByBeneficiaryIdAndCustomerCustomerId(Long beneficiaryId, Long customerId);
}
