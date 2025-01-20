package com.sachith.server.service;

import com.sachith.server.dto.ReservationRequestDTO;
import com.sachith.server.dto.ReservationResponseDTO;
import com.sachith.server.dto.ResponseDTO;
import com.sachith.server.model.Reservation;
import com.sachith.server.model.Transaction;


import java.util.List;


public interface ReservationService {

    public ResponseDTO create(ReservationRequestDTO reservation);
    public List<ReservationResponseDTO> readAll();

    Reservation updateReservationTransactionById(Long id, Transaction transaction);

    public List<ReservationResponseDTO> reservationByUserId(Long id);

    public List<Reservation> reservationByStatus(String status);

    public Reservation updateReservationByStatus(Long id,String status);
}
