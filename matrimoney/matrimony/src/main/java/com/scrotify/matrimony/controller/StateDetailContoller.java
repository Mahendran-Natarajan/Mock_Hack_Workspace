package com.scrotify.matrimony.controller;

import com.scrotify.matrimony.entity.StateDetail;
import com.scrotify.matrimony.service.StateDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type State detail contoller.
 */
@RestController
@RequestMapping("/")
@CrossOrigin()
@Slf4j
public class StateDetailContoller {

    /**
     * The State detail service.
     */
    @Autowired
    StateDetailService stateDetailService;

    /**
     * Gets states.
     *
     * @return the states
     */
    @GetMapping("/states")
    public ResponseEntity<List<StateDetail>> getStates() {
        log.info(":: Enter into StateController--------::getStates()");
        List<StateDetail> stateDetail = stateDetailService.getAllStates();
        return new ResponseEntity<>(stateDetail, HttpStatus.OK);

    }

}
