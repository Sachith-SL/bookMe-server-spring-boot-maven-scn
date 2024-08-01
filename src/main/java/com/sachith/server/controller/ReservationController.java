package com.sachith.server.controller;


import com.sachith.server.model.Reservation;
import com.sachith.server.model.Slot;
import com.sachith.server.model.User;
import com.sachith.server.repository.ReservationRepository;
import com.sachith.server.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @PostMapping()
    public Reservation create(@RequestBody Reservation reservation) {
        try {
            return reservationRepository.save(reservation);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping()
    public List<Reservation> readAll() {

        return reservationRepository.findAll();
    }
}
