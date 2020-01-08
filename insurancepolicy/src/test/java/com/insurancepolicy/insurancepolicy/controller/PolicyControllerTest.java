package com.insurancepolicy.insurancepolicy.controller;

import com.insurancepolicy.insurancepolicy.dto.ApiResponse;
import com.insurancepolicy.insurancepolicy.dto.PolicyHolderDto;
import com.insurancepolicy.insurancepolicy.service.PolicyHolderServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class PolicyControllerTest {

    @InjectMocks
    PolicyController policyController;

    @Mock
    private PolicyHolderServiceImpl policyHolderService;

    @Test
    public void testAddPolicyHolder() {
        PolicyHolderDto policyHolderDto = new PolicyHolderDto();
        policyHolderDto.setPolicyHolderId(1L);
        policyHolderDto.setAge(30);
        policyHolderDto.setGender("Male");
        policyHolderDto.setMobileNumber(9999990933L);
        policyHolderDto.setPolicyHolderName("ZCVB");
        Optional<PolicyHolderDto> policyHolderDtoOptional = Optional.ofNullable(policyHolderDto);
        Mockito.when(policyHolderService.addPolicyHolder(1L, policyHolderDto))
                .thenReturn(policyHolderDtoOptional);
        ResponseEntity<ApiResponse> responseEntityResponse = policyController.addPolicy(10L, policyHolderDto);
        Assert.assertNotNull(responseEntityResponse);
        Assert.assertEquals(500, responseEntityResponse.getBody().getStatusCode());
        Assert.assertEquals("Buying is failed", responseEntityResponse.getBody().getMessage());
    }

    @Test
    public void testAddPolicyHolderFailCase() {
        PolicyHolderDto policyHolderDto = new PolicyHolderDto();
        policyHolderDto.setPolicyHolderId(1L);
        policyHolderDto.setAge(30);
        policyHolderDto.setGender("Male");
        policyHolderDto.setMobileNumber(9999990933L);
        policyHolderDto.setPolicyHolderName("ZCVB");

        ApiResponse response = new ApiResponse();
        Optional<PolicyHolderDto> policyHolderDtoOptional = Optional.empty();
        ResponseEntity<ApiResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        Mockito.when(policyHolderService.addPolicyHolder(1L, policyHolderDto))
                .thenReturn(policyHolderDtoOptional);

        ResponseEntity<ApiResponse> responseEntityResponse = policyController.addPolicy(10L, policyHolderDto);
        Assert.assertNotNull(responseEntityResponse);
        Assert.assertEquals(500, responseEntityResponse.getBody().getStatusCode());
        Assert.assertEquals("Buying is failed", responseEntityResponse.getBody().getMessage());
    }
}
