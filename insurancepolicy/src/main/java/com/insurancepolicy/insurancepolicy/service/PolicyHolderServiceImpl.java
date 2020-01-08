package com.insurancepolicy.insurancepolicy.service;

import com.insurancepolicy.insurancepolicy.dto.PolicyHolderDto;
import com.insurancepolicy.insurancepolicy.dto.TrendResponseDto;
import com.insurancepolicy.insurancepolicy.entity.Policy;
import com.insurancepolicy.insurancepolicy.entity.PolicyHolder;
import com.insurancepolicy.insurancepolicy.exception.CustomException;
import com.insurancepolicy.insurancepolicy.repository.PolicyHolderRepository;
import com.insurancepolicy.insurancepolicy.repository.PolicyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.insurancepolicy.insurancepolicy.utils.InsuranceConst.POLICY_ACTIVE;

/**
 * The type Policy holder service.
 */
@Service
public class PolicyHolderServiceImpl implements PolicyHolderService {

    private static final Logger logger = LoggerFactory.getLogger(PolicyHolderServiceImpl.class);
    @Autowired
    private PolicyHolderRepository policyHolderRepository;

    @Autowired
    private PolicyRepository policyRepository;

    @Override
    public List<TrendResponseDto> trendAnalysis() {
        List<PolicyHolder> allHolders = policyHolderRepository.findAll();
        List<TrendResponseDto> trendResponseDtos = new ArrayList<>();
        Integer totalPolcyCount = allHolders.size();
        Map<Policy, Integer> trendAnalysis = allHolders.stream().collect(Collectors.groupingBy(PolicyHolder::getPolicy,
                Collectors.collectingAndThen(
                Collectors.mapping(PolicyHolder::getPolicy, Collectors.toList()), List::size)));
        trendAnalysis.forEach((policy, policyCount) -> {
            TrendResponseDto trendResponseDto = new TrendResponseDto();
            trendResponseDto.setPolicyName(policy.getPolicyName());
            trendResponseDto.setPolicyId(policy.getPolicyId());
            trendResponseDto.setCount(policyCount);
            Integer percentage = (policyCount * 100) / totalPolcyCount;
            trendResponseDto.setPercentage(percentage);
            trendResponseDtos.add(trendResponseDto);
        });
        return trendResponseDtos;
    }

    /**
     * add policy holder
     * @param policyId policy id
     * @param policyHolderDto holder
     * @return
     */
    @Override
    public Optional<PolicyHolderDto> addPolicyHolder(Long policyId, PolicyHolderDto policyHolderDto) {
        logger.info("adding policy holder service {}", policyId);
        Optional<Policy> policy = policyRepository.findById(policyId);
        if (policy.isPresent()) {
            PolicyHolder policyHolder = new PolicyHolder();
            policyHolder.setPurchageDate(LocalDate.now());
            policyHolder.setPolicy(policy.get());
            BeanUtils.copyProperties(policyHolderDto, policyHolder);
            policyHolder.setStatus(POLICY_ACTIVE);
            policyHolder.setMobileNumber(policyHolderDto.getMobileNumber());
            policyHolder = policyHolderRepository.save(policyHolder);
            policyHolderDto.setPolicyHolderId(policyHolder.getPolicyHolderId());
            logger.info("added policy holder with ID :{}", policyHolder.getPolicyHolderId());
        } else {
            throw new CustomException("Policy not found");
        }
        return Optional.ofNullable(policyHolderDto);
    }
}
