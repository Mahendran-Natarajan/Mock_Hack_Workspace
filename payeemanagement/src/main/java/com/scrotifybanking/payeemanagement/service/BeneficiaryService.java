package com.scrotifybanking.payeemanagement.service;

import com.scrotifybanking.payeemanagement.dto.*;
import com.scrotifybanking.payeemanagement.exception.CustomerNotFoundException;
import com.scrotifybanking.payeemanagement.exception.InvalidBankException;

import java.util.List;
import java.util.Optional;

/**
 * The interface Beneficiary service.
 */
public interface BeneficiaryService {

    /**
     * Add beneficiary beneficiary add response dto.
     *
     * @param customerId               the customer id
     * @param beneficiaryAddRequestDto the beneficiary add request dto
     * @return the beneficiary add response dto
     * @throws InvalidBankException      the invalid bank exception
     * @throws CustomerNotFoundException the customer not found exception
     */
    BeneficiaryAddResponseDto addBeneficiary(Long customerId, BeneficiaryAddRequestDto beneficiaryAddRequestDto) throws InvalidBankException, CustomerNotFoundException;

    /**
     * View beneficiaries list.
     *
     * @param customerId the customer id
     * @return the list
     */
    List<ListBeneficiaryDto> viewBeneficiaries(Long customerId);

    /**
     * Update beneficiary beneficiary update response dto.
     *
     * @param beneficiaryUpdateRequestDto the beneficiary update request dto
     * @return the beneficiary update response dto
     * @throws Exception the exception
     */
    public BeneficiaryUpdateResponseDto updateBeneficiary(BeneficiaryUpdateRequestDto beneficiaryUpdateRequestDto)
            throws Exception;

    /**
     * Delete beneficiary by id optional.
     *
     * @param beneficiaryId the beneficiary id
     * @param customerId    the customer id
     * @return the optional
     */
    public Optional<Boolean> deleteBeneficiaryById(Long beneficiaryId, Long customerId);
}


