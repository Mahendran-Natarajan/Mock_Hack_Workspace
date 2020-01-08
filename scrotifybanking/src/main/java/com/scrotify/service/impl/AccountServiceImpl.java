package com.scrotify.service.impl;

import com.scrotify.entity.Account;
import com.scrotify.exception.CustomerNotFoundException;
import com.scrotify.repository.AccountRepository;
import com.scrotify.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Account service.
 */
@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountRepository accountRepository;

    /**
     * findAllByAccount except current cust
     *
     * @param custId        the cust id
     * @param accountStatus the account status
     * @param accountType   the account type
     * @return
     */
    /*@Override
    public List<Account> findAllByAccountNotCustomer(String custId, String accountStatus, String accountType) {
        return accountRepository.findAllByAccountNotCustomer(Long.parseLong(custId), accountStatus, accountType);
    }*/

    /**
     * Find all by account not customer list.
     *
     * @param custId the cust id
     * @return the list
     */
    @Override
    public List<Account> findAllByCustomer(String custId) throws CustomerNotFoundException {
        List<Account> accounts = new ArrayList<>();
        Optional<List<Account>> accountOptional = accountRepository.findAllByCustomerCustomerId(Long.parseLong(custId));
        List<Account> accountList = accountRepository.findAll().stream().filter(account -> account.getCustomer().getCustomerId() != Long.parseLong(custId)).collect(Collectors.toList());
        if (accountList.isEmpty()) throw new CustomerNotFoundException("No accounts found");
        return accountList;
    }

}
