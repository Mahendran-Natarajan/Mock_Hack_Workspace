package com.scrotify.matrimony.service;

/**
 * The Class HospitalServiceImpl.
 *
 * @author anisha
 */

import com.scrotify.matrimony.Repository.StateDetailRepository;
import com.scrotify.matrimony.entity.StateDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type State detail service.
 */
@Service
@Slf4j
public class StateDetailServiceImpl implements StateDetailService {

    /**
     * The State detail repository.
     */
    @Autowired
    StateDetailRepository stateDetailRepository;

    /**
     * Gets the all States.
     *
     * @return
     */

    @Override
    public List<StateDetail> getAllStates() {
        log.info("Enter StateServiceImpl:getAllStates()");
        List<StateDetail> stateDetails = stateDetailRepository.findAll();
        return stateDetails;
    }

}
