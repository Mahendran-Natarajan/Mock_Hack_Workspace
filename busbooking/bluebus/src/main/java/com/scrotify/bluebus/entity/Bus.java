package com.scrotify.bluebus.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String busNo;
    private String busName;
    private String startingPlace;
    private String destinationPlace;
    private Integer availableSeats;
    private Double busFare;
    private LocalTime depatureTime;
    private LocalTime arrivalTime;
    private Integer duration;
}