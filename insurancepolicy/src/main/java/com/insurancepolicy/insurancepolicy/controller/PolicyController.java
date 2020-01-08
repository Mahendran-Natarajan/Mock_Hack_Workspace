package com.insurancepolicy.insurancepolicy.controller;

import com.insurancepolicy.insurancepolicy.dto.ApiResponse;
import com.insurancepolicy.insurancepolicy.dto.PolicyHolderDto;
import com.insurancepolicy.insurancepolicy.dto.TrendResponseDto;
import com.insurancepolicy.insurancepolicy.service.PolicyHolderServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * The Policy controller.
 * This Controller includes purchasing policy for the user
 *
 * @author Mahendran
 * @since 20/12/2019
 */
@RestController
@RequestMapping("/policies")
@CrossOrigin
public class PolicyController {

    private static final Logger logger = LoggerFactory.getLogger(PolicyController.class);
    @Autowired
    private PolicyHolderServiceImpl policyHolderService;

    /**
     * {@Code Post: add Policy}
     *
     * @param policyId        policy id
     * @param policyHolderDto policy holder details
     * @return {@link ResponseEntity} retunrs the response entity of {@link ApiResponse}
     */
    @PostMapping("/{policyId}/buy")
    public ResponseEntity<ApiResponse> addPolicy(@PathVariable("policyId") Long policyId, @RequestBody @Valid PolicyHolderDto policyHolderDto) {
        logger.info("Entering into addPolicy in Policy controller");
        Optional<PolicyHolderDto> policyHolderDtoOptional = policyHolderService.addPolicyHolder(policyId, policyHolderDto);
        ApiResponse response = new ApiResponse();
        if (policyHolderDtoOptional.isPresent()) {
            response.setMessage("{policyHolderId:" + policyHolderDtoOptional.get().getPolicyHolderId() + "}");
            response.setStatusCode(200);
        } else {
            logger.error("Buying policy is failed");
            response.setMessage("Buying is failed");
            response.setStatusCode(500);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/trends")
    public ResponseEntity<TrendResponseDto> getTrends() {
        List<TrendResponseDto> trendResponseDtos = policyHolderService.trendAnalysis();
        if (!trendResponseDtos.isEmpty()) {
            logger.info("trend app");
        } else {
            logger.error("error in trends");
        }
        return new ResponseEntity(trendResponseDtos, HttpStatus.OK);
    }

}
