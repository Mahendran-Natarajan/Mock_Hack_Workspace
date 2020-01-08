package com.scrotify.bluebus.repository;

import com.scrotify.bluebus.entity.BlockSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BlockSeatRepository extends JpaRepository<BlockSeat, Long> {

    Optional<BlockSeat> findByBusIdAndDepartureDateAndSeatNumberIn(Long busId, LocalDate departureDate, List<String> seatNumber);

}


