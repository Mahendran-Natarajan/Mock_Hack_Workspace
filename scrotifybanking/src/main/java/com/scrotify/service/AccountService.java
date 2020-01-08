package com.scrotify.service;

import com.scrotify.entity.Account;
import com.scrotify.exception.CustomerNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * The interface Account service.
 */
public interface AccountService {

    /**
     * Find all by account not customer list.
     *
     * @param custId        the cust id
     * @param accountStatus the account status
     * @param accountType   the account type
     * @return the list
     */
    //List<Account> findAllByAccountNotCustomer(String custId, String accountStatus, String accountType);
    List<Account> findAllByCustomer(String custId) throws CustomerNotFoundException;

}
