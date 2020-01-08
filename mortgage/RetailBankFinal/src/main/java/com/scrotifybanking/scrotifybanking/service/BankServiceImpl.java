package com.scrotifybanking.scrotifybanking.service;

import com.scrotifybanking.scrotifybanking.dto.BankDto;
import com.scrotifybanking.scrotifybanking.entity.Bank;
import com.scrotifybanking.scrotifybanking.exception.CustomException;
import com.scrotifybanking.scrotifybanking.repository.BankRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl {

    private BankRepository bankRepository;

    public BankDto getBankByIfscCode(String ifscCode) {
        BankDto bankDto = new BankDto();
        List<BankDto> bankDtos = null;
        Optional<List<Bank>> bankIfscCodeOptional = bankRepository.findByBankIfscCodeContains(ifscCode);

        if (bankIfscCodeOptional.isPresent()) {
            bankDtos = bankIfscCodeOptional.get().stream().map(bank -> {
                BeanUtils.copyProperties(bank, bankDto);
                return bankDto;
            }).collect(Collectors.toList());
        }
        bankIfscCodeOptional.orElseThrow(CustomException::new);
        return bankDto;
    }
}
