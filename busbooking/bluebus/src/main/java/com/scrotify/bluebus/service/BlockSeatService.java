package com.scrotify.bluebus.service;

import com.scrotify.bluebus.dto.ApiResponse;
import com.scrotify.bluebus.entity.BlockSeat;
import com.scrotify.bluebus.repository.BlockSeatRepository;
import com.scrotify.bluebus.util.BlueBusConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlockSeatService {

    private static final Log logger = LogFactory.getLog(BlockSeatService.class);

    @Autowired
    private BlockSeatRepository blockSeatRepository;

    @Transactional
    public ApiResponse blockSeat( BlockSeat blockSeat) {
        ApiResponse response = new ApiResponse();
        logger.info("Entering into block seat service");
        synchronized (this) {
           if (!checkSeatAvailable(blockSeat)) {
               logger.info("Seat is available");
               blockSeat.getSeatNumbers().stream().map(seat -> {
                   blockSeat.setSeatNumber(seat);
                   blockSeatRepository.save(blockSeat);
                   response.setStatusCode(200);
                   logger.info("Saved");
                   response.setMessage(BlueBusConstants.SEAT_BLOCKED_SUCCESS);
                   return response;
               });

           } else {
               logger.info("Seat is already blocked");
               response.setMessage(BlueBusConstants.SEAT_BLOCKED);
               response.setStatusCode(BlueBusConstants.SEAT_BLOCKED_STATUS_CODE);
           }
        }
        logger.info("Ending block seat service ");
        return response;
    }


    private Boolean checkSeatAvailable(BlockSeat blockSeat) {
        boolean checkSeatAvailable = false;

        Optional<BlockSeat> blockSeatOptional =
                blockSeatRepository.findByBusIdAndDepartureDateAndSeatNumberIn(
                        blockSeat.getBusId(), blockSeat.getDepartureDate(), blockSeat.getSeatNumbers());
                return blockSeatOptional.isPresent();

        /*List<Optional<BlockSeat>> blockedSeats =   blockSeat.getSeatNumbers().stream().map(seatNumber ->
                        blockSeatRepository.findByBusIdAndSeatNumberAndDepartureDate(blockSeat.getBusId(), seatNumber,
                                blockSeat.getDepartureDate())).collect(Collectors.toList());*/
      /*  List<BlockSeat> blockSeats = blockSeat.getSeatNumbers().stream().map(seat ->
             blockSeatRepository.findByBusIdAndSeatNumberAndDepartureDate(blockSeat.getBusId(), seat,
                    blockSeat.getDepartureDate())).collect(Collectors.toList());*/

/*
        blockSeats.forEach(i ->  {
            if(!Optional.ofNullable(i).isPresent()) {
                return;
             }
        });*/
        // return checkSeatAvailable;
    }

}
