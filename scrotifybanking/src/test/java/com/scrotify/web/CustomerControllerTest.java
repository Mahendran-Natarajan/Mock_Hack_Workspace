package com.scrotify.web;

import com.scrotify.dto.FundRequestDto;
import com.scrotify.dto.response.AccountNosDto;
import com.scrotify.dto.response.ApiResponse;
import com.scrotify.entity.Account;
import com.scrotify.exception.CustomException;
import com.scrotify.exception.MaintainBalanceException;
import com.scrotify.exception.MinimumBalanceNotFoundException;
import com.scrotify.repository.AccountRepository;
import com.scrotify.service.TransactionService;
import com.scrotify.util.ScrotifyConstant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;


/**
 * The type Customer controller test.
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionService transactionService;

    @Mock
    private ModelMapper modelMapper;


    /**
     * Test get all accounts.
     *
     * @throws CustomException the custom exception
     */
    @Test
    public void testGetAllAccounts() throws CustomException {
        String custId = "123456";
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setAccountNo(10L);
        accounts.add(account);

        Account account2 = new Account();
        account2.setAccountNo(20L);
        accounts.add(account2);

        //Mockito.when(accountRepository.findAllByAccountNotCustomer(any(), any(), any())).thenReturn(accounts);

        ResponseEntity<AccountNosDto> accountNosDtos = customerController.getAllAccountNos(custId);
        Assert.assertNotNull(accountNosDtos);
        Assert.assertEquals(200, accountNosDtos.getStatusCode().value());
        Assert.assertEquals(10L, accountNosDtos.getBody().getAccountNos().get(0).longValue());
    }

    /**
     * Test get in valid cust.
     *
     * @throws CustomException the custom exception
     */
    @Test(expected = CustomException.class)
    public void testGetInValidCust() throws CustomException {
        String custId = "12345689";
        List<Account> accounts = new ArrayList<>();
        //Mockito.when(accountRepository.findAllByAccountNotCustomer(any(), any(), any())).thenThrow(CustomException.class);
        customerController.getAllAccountNos(custId);
    }


    /**
     * Test fund transfer.
     *
     * @throws CustomException the custom exception
     */
    @Test(expected = MaintainBalanceException.class)
    public void testFundTransferCheckMinimumFalse() throws CustomException {
        String custId = "123456";
        String toAccountNo = "2";
        FundRequestDto fundRequestDto = new FundRequestDto();
        fundRequestDto.setAmount("1000");
        // Mockito.when(transactionService.checkMinimumBalance(any(), any(), any(), any())).thenReturn(new Boolean(true));
        // Mockito.when(transactionService.checkManintenanceBalance(any(), any(), any(), any(), any())).thenReturn(true);
        ResponseEntity<ApiResponse> response = customerController.fundTransfer(custId, toAccountNo, fundRequestDto);
        Assert.assertNotNull(response);
    }

    @Test(expected = MinimumBalanceNotFoundException.class)
    public void testFundTransferCheckMaintainBalance() throws CustomException {
        String custId = "123456";
        String toAccountNo = "2";
        FundRequestDto fundRequestDto = new FundRequestDto();
        fundRequestDto.setAmount("1000");
        Mockito.when(transactionService.checkMinimumBalance(Long.parseLong(custId), ScrotifyConstant.ACCOUNT_ACTIVE_STATUS, ScrotifyConstant.ACCOUNT_TYPE, Double.parseDouble(fundRequestDto.getAmount()))).thenReturn(true);
        // Mockito.when(transactionService.checkManintenanceBalance(any(), any(), any(), any(), any())).thenReturn(true);
        ResponseEntity<ApiResponse> response = customerController.fundTransfer(custId, toAccountNo, fundRequestDto);
        Assert.assertNotNull(response);
    }

    @Test
    public void testFundTransferCheck() throws CustomException {
        String custId = "123456";
        String toAccountNo = "2";
        FundRequestDto fundRequestDto = new FundRequestDto();
        fundRequestDto.setAmount("1000");
        Mockito.when(transactionService.checkMinimumBalance(Long.parseLong(custId), ScrotifyConstant.ACCOUNT_ACTIVE_STATUS, ScrotifyConstant.ACCOUNT_TYPE, Double.parseDouble(fundRequestDto.getAmount()))).thenReturn(true);
        Mockito.when(transactionService.checkManintenanceBalance(Long.parseLong(custId), ScrotifyConstant.ACCOUNT_ACTIVE_STATUS, ScrotifyConstant.ACCOUNT_TYPE, Double.parseDouble(fundRequestDto.getAmount()), ScrotifyConstant.MINIMUM_BALANCE_MAINTAIN)).thenReturn(true);
        ApiResponse response = new ApiResponse();
        response.setMessage("success");
        response.setStatusCode(200);
        Mockito.when(transactionService.transferFund(anyLong(), anyString(), anyDouble(), any(), any())).thenReturn(response);
        ResponseEntity<ApiResponse> responseRes = customerController.fundTransfer(custId, toAccountNo, fundRequestDto);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getMessage());
        Assert.assertNotNull(response.getStatusCode());

    }

}
