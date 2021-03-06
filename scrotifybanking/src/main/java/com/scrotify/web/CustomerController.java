package com.scrotify.web;

import com.scrotify.dto.*;
import com.scrotify.dto.response.AccountNosDto;
import com.scrotify.dto.response.ApiResponse;
import com.scrotify.entity.Account;
import com.scrotify.entity.Customer;
import com.scrotify.exception.CustomException;
import com.scrotify.exception.CustomerNotFoundException;
import com.scrotify.exception.MaintainBalanceException;
import com.scrotify.exception.MinimumBalanceNotFoundException;
import com.scrotify.repository.AccountRepository;
import com.scrotify.repository.CustomerRepository;
import com.scrotify.service.AccountService;
import com.scrotify.service.CustomerService;
import com.scrotify.service.TransactionService;
import com.scrotify.service.impl.AccountServiceImpl;
import com.scrotify.util.ScrotifyConstant;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type Customer controller.
 */
@RestController
@RequestMapping("/customers")
@CrossOrigin(allowedHeaders = "*")
public class CustomerController {

    /**
     * The Customer service.
     */
    @Autowired
    CustomerService customerService;

    @Autowired
    AccountServiceImpl accountService;

    /**
     * The Customer repository.
     */
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Fund transfer response entity.
     *
     * @param custId         the cust id
     * @param toAccountNo    the to account no
     * @param fundRequestDto the fund request dto
     * @return the response entity
     * @throws MinimumBalanceNotFoundException the minimum balance not found exception
     * @throws MaintainBalanceException        the maintain balance exception
     */
    @PostMapping("/{custId}/accounts/{toAccountNo}")
    @CrossOrigin
    public ResponseEntity<ApiResponse> fundTransfer(@PathVariable String custId, @PathVariable String toAccountNo,
                                                    @RequestBody @Valid FundRequestDto fundRequestDto) {

        boolean checkMinimumBalance = transactionService.checkMinimumBalance(Long.parseLong(custId), ScrotifyConstant.ACCOUNT_ACTIVE_STATUS, ScrotifyConstant.ACCOUNT_TYPE, Double.parseDouble(fundRequestDto.getAmount()));
        ApiResponse response = new ApiResponse();
        response.setStatusCode(ScrotifyConstant.TRANSACTION_FAILED);
        response.setMessage(ScrotifyConstant.FUND_TRANSFER_FAILED);
        if (checkMinimumBalance) {
            if (transactionService.checkManintenanceBalance(Long.parseLong(custId), ScrotifyConstant.ACCOUNT_ACTIVE_STATUS, ScrotifyConstant.ACCOUNT_TYPE, Double.parseDouble(fundRequestDto.getAmount()), ScrotifyConstant.MINIMUM_BALANCE_MAINTAIN)) {
                response = transactionService.transferFund(Long.parseLong(custId), toAccountNo, Double.parseDouble(fundRequestDto.getAmount()), ScrotifyConstant.ACCOUNT_ACTIVE_STATUS, ScrotifyConstant.ACCOUNT_TYPE);
                response.setMessage(ScrotifyConstant.FUND_TRANSFER_SUCCESS);
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                throw new MinimumBalanceNotFoundException(ScrotifyConstant.MINIMUM_BALANCE_FAILED);
            }
        } else {
            throw new MaintainBalanceException(ScrotifyConstant.MAINTAIN_BALANCE_FAILED);
        }
    }

    /**
     * get list of accounts except current customer
     *
     * @param custId the cust id
     * @return all account nos
     * @throws CustomException the custom exception
     */
    @GetMapping("/{custId}/accounts/")
    @CrossOrigin
    public ResponseEntity<AccountNosDto> getAllAccountNos(@PathVariable String custId) throws CustomerNotFoundException {

        AccountNosDto accountNosDtos = new AccountNosDto();
//        List<Account> accounts = accountRepository.findAllByAccountNotCustomer(Long.parseLong(custId), ScrotifyConstant.ACCOUNT_ACTIVE_STATUS, ScrotifyConstant.ACCOUNT_TYPE);
        List<Account> accounts = accountService.findAllByCustomer(custId);
        if (!accounts.isEmpty()) {
            List<Long> accountNos = accounts.stream().map(Account::getAccountNo).collect(Collectors.toList());
            accountNosDtos.setAccountNos(accountNos);
        } else {
            throw new CustomException(ScrotifyConstant.CUSTOMER_ID_NOT_FOUND);
        }
        return new ResponseEntity<>(accountNosDtos, HttpStatus.OK);
    }

    /**
     * Gets transaction statement.
     *
     * @param transactionStatementDto the transaction statement dto
     * @return transaction statement
     * @throws Exception the exception
     */
    @CrossOrigin
    @GetMapping("/{custId}/transactions/{month}")
    public List<TransactionStatementResponseDto> getTransactionStatement(TransactionStatementDto transactionStatementDto) throws Exception {
        return transactionService.getTransactionStatement(transactionStatementDto, ScrotifyConstant.ACCOUNT_ACTIVE_STATUS, ScrotifyConstant.ACCOUNT_TYPE);
    }

    /**
     * Register customer customer response dto.
     *
     * @param customerRequestDto the customer request dto
     * @return the customer response dto
     */
    @CrossOrigin
    @PostMapping
    public CustomerResponseDto registerCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        return customerService.registerCustomer(customerRequestDto);
    }


    /**
     * Login customer response entity.
     *
     * @param loginDto the login dto
     * @return the response entity
     */
    @CrossOrigin
    @PostMapping("/{customerId}/{password}")
    public ResponseEntity<LoginResponseDto> loginCustomer(@RequestBody LoginDto loginDto) {
        Optional<Customer> customer = customerRepository.findByCustomerId(loginDto.getCustId());
        if (!customer.isPresent()) {
            LoginResponseDto loginResponseDto = new LoginResponseDto();
            loginResponseDto.setStatusCode(ScrotifyConstant.NOT_FOUND_CODE);
            loginResponseDto.setStatusMessage(ScrotifyConstant.NOT_FOUND_MESSAGE);
            return new ResponseEntity<>(loginResponseDto, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(customerService.loginCustomer(loginDto), HttpStatus.OK);
        }
    }


    /**
     * Last transaction response entity.
     *
     * @param customerId the customer id
     * @return the response entity
     */
    @CrossOrigin
    @GetMapping("/{customerId}")
    public ResponseEntity<AccountSummaryResponseDto> lastTransaction(@PathVariable Long customerId) {
        return new ResponseEntity<>(customerService.accountSummary(customerId), HttpStatus.OK);
    }

}
