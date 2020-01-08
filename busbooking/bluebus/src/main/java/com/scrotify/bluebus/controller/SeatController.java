package com.scrotify.bluebus.controller;

import com.scrotify.bluebus.dto.ApiResponse;
import com.scrotify.bluebus.dto.SeatsDto;
import com.scrotify.bluebus.entity.BlockSeat;
import com.scrotify.bluebus.service.BlockSeatService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mahendran
 */
@RestController
@RequestMapping("/seats")
@CrossOrigin
public class SeatController {

    private static Log logger = LogFactory.getLog(SeatController.class);

    @Autowired
    private BlockSeatService blockSeatService;

    /**
     * Block the seats temporary for a min
     * @param seatsDto
     * @return
     */
    @PostMapping
    public ResponseEntity blockSeats(@RequestBody SeatsDto seatsDto) {
        BlockSeat blockSeat = new BlockSeat();
        BeanUtils.copyProperties(seatsDto, blockSeat);
        ApiResponse response = blockSeatService.blockSeat(blockSeat);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

}
