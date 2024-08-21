package com.sachith.server.service;

import com.sachith.server.dto.ReservationDTO;
import com.sachith.server.model.Reservation;
import com.sachith.server.model.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;


public interface ReservationService {

    public Reservation create(ReservationDTO reservation);
    public List<Reservation> readAll();

    Reservation updateReservationTransactionById(Long id, Transaction transaction);

    public List<Reservation> reservationByUserId(Long id);

    public List<Reservation> reservationByStatus(String status);

    public Reservation updateReservationByStatus(Long id,String status);
}
