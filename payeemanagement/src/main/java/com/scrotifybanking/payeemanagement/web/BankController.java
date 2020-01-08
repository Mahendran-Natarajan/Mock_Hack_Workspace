package com.scrotifybanking.payeemanagement.web;

import com.scrotifybanking.payeemanagement.dto.BankDto;
import com.scrotifybanking.payeemanagement.service.BankServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller for managing {@Link com.scrotifybanking.payeemanagement.entity.Bank}
 */
@RestController
@RequestMapping("/bank")
@CrossOrigin
public class BankController {


    private static final Logger logger = LogManager.getLogger(BankController.class);

    @Autowired
    private BankServiceImpl bankService;

    /**
     * Gets bank details by ifsc code.
     * {@Code GET /search } : get bank details by IFSC codes
     * @param ifscCode the ifsc code
     * @return {@link ResponseEntity} with status {@code 200}  and with the body of bank details
     * @throws  Exception if any exception occurs
     */
    @GetMapping("/search")
    public ResponseEntity<BankDto> getBankDetailsByIfscCode(@RequestParam String ifscCode) {
        logger.info("Get bank details by IFSC code");
        BankDto bankDto = bankService.getBankByIfscCode(ifscCode);
        return new ResponseEntity<>(bankDto, HttpStatus.OK);
    }

}
