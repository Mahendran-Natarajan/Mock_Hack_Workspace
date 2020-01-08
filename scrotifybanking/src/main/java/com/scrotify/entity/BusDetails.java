package com.scrotify.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "bus_details")
public class BusDetails implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", insertable = false, nullable = false)
  private Long id;

  @Column(name = "bus_name", nullable = false)
  private String busName;

  @Column(name = "starting_place", nullable = false)
  private String startingPlace;

  @Column(name = "destination_place", nullable = false)
  private String destinationPlace;

  @Column(name = "bus_fare")
  private Double busFare;

  @Column(name = "is_ac")
  private Boolean ac;

  @Column(name = "is_sleeper")
  private Boolean sleeper;

  @Column(name = "departure_time")
  private Date departureTime;

  @Column(name = "departure_date")
  private Date departureDate;

  @Column(name = "available_seats")
  private Integer availableSeats;

  @Column(name = "bus_no")
  private String busNo;

  @Column(name = "duration")
  private Integer duration;

  @Column(name = "arrival_time")
  private Date arrivalTime;

  
}