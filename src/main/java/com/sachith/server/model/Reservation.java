package com.sachith.server.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Table(name = "t_reservation")
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_id")
    User user;
    LocalDate date;
    Integer amount;
    String status; // (PENDING, CONFIRMED, IN_PROGRESS, COMPLETED)

}
