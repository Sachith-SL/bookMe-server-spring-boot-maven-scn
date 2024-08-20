package com.sachith.server.service;

import com.sachith.server.dto.ReservationDTO;
import com.sachith.server.model.Reservation;
import com.sachith.server.model.Transaction;

import java.util.List;


public interface ReservationService {

    public Reservation create(ReservationDTO reservation);
    public List<Reservation> readAll();

    Reservation updateReservationTransactionById(Long id, Transaction transaction);
}
