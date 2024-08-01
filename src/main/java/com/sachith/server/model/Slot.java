package com.sachith.server.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "t_slot")
@Data
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    LocalDate date;
    LocalTime startTime;
    LocalTime endTime;
    Integer unitPrice;
    Boolean isAvailable;

}
