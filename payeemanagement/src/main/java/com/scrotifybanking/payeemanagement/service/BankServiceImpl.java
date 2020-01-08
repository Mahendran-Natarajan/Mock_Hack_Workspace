package com.scrotifybanking.payeemanagement.service;

import com.scrotifybanking.payeemanagement.dto.BankDto;
import com.scrotifybanking.payeemanagement.entity.Bank;
import com.scrotifybanking.payeemanagement.exception.CustomException;
import com.scrotifybanking.payeemanagement.repository.BankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * The type Bank service.
 */
@Service
public class BankServiceImpl {

    /**
     * The constant logger.
     */
    public static final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);

    @Autowired
    private BankRepository bankRepository;

    /**
     * Gets bank by ifsc code.
     *
     * @param ifscCode the ifsc code
     * @return the bank by ifsc code
     */
    public BankDto getBankByIfscCode(String ifscCode) {
        logger.info("BankServiceImpl get Bank details by IFSC Code");
        BankDto bankDto = new BankDto();
        List<BankDto> bankDtos = null;
        Optional<Bank> bankIfscCodeOptional = bankRepository.findByBankIfscCode(ifscCode);
        BankDto finalBankDto = bankDto;
        if (bankIfscCodeOptional.isPresent()) {
            bankDto = Optional.ofNullable(bankIfscCodeOptional.get()).map(
                    bank -> {
                        BeanUtils.copyProperties(bank, finalBankDto);
                        return finalBankDto;
                    }).orElseThrow(() -> new CustomException(("IFSC code not found")));
            logger.info("End of BankServiceImpl get Bank details by IFSC Code");
        }
        return bankDto;
    }
}
