package com.sachith.server.repository;

import com.sachith.server.model.Reservation;
import com.sachith.server.model.ReservationSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationSlotRepository extends JpaRepository<ReservationSlot, Long> {

    List<ReservationSlot> findReservationSlotByReservation(Reservation reservation);
}
