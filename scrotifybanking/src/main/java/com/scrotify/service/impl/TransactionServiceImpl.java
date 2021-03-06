package com.scrotify.service.impl;

import com.scrotify.dto.TransactionStatementDto;
import com.scrotify.dto.TransactionStatementResponseDto;
import com.scrotify.dto.response.ApiResponse;
import com.scrotify.entity.Account;
import com.scrotify.entity.Transaction;
import com.scrotify.exception.MinimumBalanceNotFoundException;
import com.scrotify.repository.AccountRepository;
import com.scrotify.repository.TransactionRepository;
import com.scrotify.service.TransactionService;
import com.scrotify.util.ScrotifyConstant;
import com.scrotify.util.StatementDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Transaction service.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;


    /**
     * check balance before withdraw
     *
     * @param custId
     * @param amount
     * @param accountStatus
     * @param accountType
     * @return
     */
    @Override
    public boolean checkMinimumBalance(Long custId, String accountStatus, String accountType, double amount) {
        double existingAmount = accountRepository.findByAccountBalance(custId, accountStatus, accountType);
        return (existingAmount > amount);
    }

    /**
     * Check maintenance balance after withdraw
     *
     * @param custId
     * @param amount
     * @param accountStatus
     * @param accountType
     * @return
     */
    @Override
    public boolean checkManintenanceBalance(Long custId, String accountStatus, String accountType, double amount, double maintainBalance) {
        double existingAmount = accountRepository.findByAccountBalance(custId, accountStatus, accountType);
        if (existingAmount > (maintainBalance + amount)) {
            return true;
        }
        return false;
    }


    @Override
    @Transactional
    public ApiResponse transferFund(Long custId, String toAccountNo, double amount, String accountStatus, String accountType) {
        ApiResponse response = new ApiResponse();
        Account payeeAccount = null;
        Optional<Account> accountOptional = accountRepository.findById(Long.parseLong(toAccountNo));
        Account customerAccount = accountRepository.findByCustomerByAccount(custId, accountStatus, accountType);

        if (accountOptional.isPresent()) {
            payeeAccount = accountOptional.get();
            double balanceAmount = customerAccount.getAvailableBalance() - amount;
            customerAccount.setAvailableBalance(balanceAmount);


            double payeeAccountBalance = payeeAccount.getAvailableBalance();
            payeeAccountBalance = payeeAccountBalance + amount;
            payeeAccount.setAvailableBalance(payeeAccountBalance);

            Transaction customertransaction = new Transaction();
            customertransaction.setAccountNo(customerAccount);
            customertransaction.setAmount(amount);
            customertransaction.setTransactionDate(LocalDate.now());
            customertransaction.setTransactionType(ScrotifyConstant.DEBIT_TRANSACTION);
            customertransaction.setPayeeNo(Long.parseLong(toAccountNo));

            Transaction payeeTransaction = new Transaction();
            payeeTransaction.setAccountNo(payeeAccount);
            payeeTransaction.setAmount(amount);
            payeeTransaction.setTransactionDate(LocalDate.now());
            payeeTransaction.setTransactionType(ScrotifyConstant.CREDIT_TRANSACTION);
            payeeTransaction.setPayeeNo(customertransaction.getAccountNo().getAccountNo());
            try {
                transactionRepository.save(customertransaction);
                transactionRepository.save(payeeTransaction);
                throw new MinimumBalanceNotFoundException("No Balance");
            } catch (Exception e) {
                e.printStackTrace();
            }
            accountRepository.save(payeeAccount);
            accountRepository.save(customerAccount);
            response.setStatusCode(ScrotifyConstant.SUCCESS_CODE);
        }
        return response;
    }


    /**
     * Description:
     *
     * @param transactionStatementDto
     * @return
     * @throws Exception
     */
    @Override
    public List<TransactionStatementResponseDto> getTransactionStatement(
            TransactionStatementDto transactionStatementDto, String accountStatus, String accountType) throws Exception {
        TransactionStatementResponseDto transactionStatementResponseDto = null;
        String month = transactionStatementDto.getMonth();
        Account customerId = accountRepository.findByCustomerByAccount(transactionStatementDto.getCustomerId(), accountStatus, accountType);
        List<TransactionStatementResponseDto> monthlyTransaction = new ArrayList<>();
        if (null != customerId) {
            List<Transaction> transaction = transactionRepository.findByAccountNo(customerId.getAccountNo());
            for (Transaction transact : transaction) {
                Integer transactionMonth = transact.getTransactionDate().getMonthValue();

                Integer actualMonthNumber = StatementDate.monthConverter(month);

                if (actualMonthNumber == transactionMonth) {
                    transactionStatementResponseDto = new TransactionStatementResponseDto();
                    transactionStatementResponseDto.setTransactionId(transact.getTransactionId());
                    transactionStatementResponseDto.setAmount(transact.getAmount());
                    transactionStatementResponseDto.setTransactionType(transact.getTransactionType());
                    monthlyTransaction.add(transactionStatementResponseDto);
                    transactionStatementResponseDto.setMessage("transactions");
                    transactionStatementResponseDto.setStatusCode(201);
                } else {
                    throw new Exception("there are no transactions available");
                }
            }
        } else {
            throw new Exception("User not found");
        }
        return monthlyTransaction;
    }

}
