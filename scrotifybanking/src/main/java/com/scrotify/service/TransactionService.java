package com.scrotify.service;

import com.scrotify.dto.TransactionStatementDto;
import com.scrotify.dto.TransactionStatementResponseDto;
import com.scrotify.dto.response.ApiResponse;

import java.util.List;

/**
 * The interface Transaction service.
 */
public interface TransactionService {

    /**
     * Check maintenance balance before withdraw
     *
     * @param custId        the cust id
     * @param accountStatus the account status
     * @param accountType   the account type
     * @param amount        the amount
     * @return boolean boolean
     */
    public boolean checkMinimumBalance(Long custId, String accountStatus, String accountType, double amount);

    /**
     * Check maintenance balance after withdraw
     *
     * @param custId          the cust id
     * @param accountStatus   the account status
     * @param accountType     the account type
     * @param amount          the amount
     * @param maintainBalance the maintain balance
     * @return boolean boolean
     */
    public boolean checkManintenanceBalance(Long custId, String accountStatus, String accountType, double amount, double maintainBalance);

    /**
     * Transfer fund api response.
     *
     * @param custId        the cust id
     * @param toAccountNo   the to account no
     * @param amount        the amount
     * @param accountStatus the account status
     * @param accountType   the account type
     * @return the api response
     */
    public ApiResponse transferFund(Long custId, String toAccountNo, double amount, String accountStatus, String accountType);

    /**
     * Gets transaction statement.
     *
     * @param transactionStatementDto the transaction statement dto
     * @param accountStatus           the account status
     * @param accountType             the account type
     * @return the transaction statement
     * @throws Exception the exception
     */
    public List<TransactionStatementResponseDto> getTransactionStatement(TransactionStatementDto transactionStatementDto, String accountStatus, String accountType) throws Exception;
}
