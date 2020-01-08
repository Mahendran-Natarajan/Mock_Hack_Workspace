package com.scrotifybanking.payeemanagement.Service;

import com.scrotifybanking.payeemanagement.repository.BankRepository;
import com.scrotifybanking.payeemanagement.repository.BeneficiaryRepository;
import com.scrotifybanking.payeemanagement.service.BeneficiaryServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;

/**
 * The type Delete beneficiary service test.
 */
@RunWith(MockitoJUnitRunner.class)
public class DeleteBeneficiaryServiceTest {

    /**
     * The Beneficiary repository.
     */
    @Mock
    BeneficiaryRepository beneficiaryRepository;

    /**
     * The Bank repository.
     */
    @Mock
    BankRepository bankRepository;

    @InjectMocks
    private BeneficiaryServiceImpl beneficiaryService;

    /**
     * Test delete beneficiary.
     */
    @Test
    public void testDeleteBeneficiary() {
        Optional<Boolean> deleteOptional = Optional.ofNullable(true);
        Mockito.when(beneficiaryRepository.deleteByBeneficiaryIdAndCustomerCustomerId(anyLong(), anyLong()))
                .thenReturn(deleteOptional);
        Optional<Boolean> res = beneficiaryService.deleteBeneficiaryById(10L, 100L);
        Assert.assertTrue(res.isPresent());
    }

    /**
     * Test delete beneficiary false.
     */
    @Test
    public void testDeleteBeneficiaryFalse() {
        Optional<Boolean> deleteOptional = Optional.ofNullable(false);
        Mockito.when(beneficiaryRepository.deleteByBeneficiaryIdAndCustomerCustomerId(anyLong(), anyLong()))
                .thenReturn(deleteOptional);
        Optional<Boolean> res = beneficiaryService.deleteBeneficiaryById(10L, 100L);
        Assert.assertFalse(res.isPresent());
    }
}
