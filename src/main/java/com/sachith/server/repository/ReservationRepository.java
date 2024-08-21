package com.sachith.server.repository;

import com.sachith.server.model.Reservation;
import com.sachith.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public List<Reservation> findByUser(User user);
    public List<Reservation> findByStatus(String status);
}
