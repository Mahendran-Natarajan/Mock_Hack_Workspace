package com.insurancepolicy.insurancepolicy.service;

import com.insurancepolicy.insurancepolicy.dto.PolicyHolderDto;
import com.insurancepolicy.insurancepolicy.dto.TrendResponseDto;

import java.util.List;
import java.util.Optional;

public interface PolicyHolderService {
    public List<TrendResponseDto> trendAnalysis();
    public Optional<PolicyHolderDto> addPolicyHolder(Long policyId, PolicyHolderDto policyHolderDto);
}
