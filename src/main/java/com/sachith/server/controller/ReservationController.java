package com.sachith.server.controller;


import com.sachith.server.dto.ReservationDTO;
import com.sachith.server.dto.ResponseDTO;
import com.sachith.server.model.Reservation;

import com.sachith.server.model.Transaction;
import com.sachith.server.model.User;
import com.sachith.server.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    Logger logger = LoggerFactory.getLogger(ReservationController.class);

    @Autowired
    private ReservationService reservationService;

    @PostMapping()
    public ResponseDTO create(@RequestBody ReservationDTO reservationDto) {
        ResponseDTO responseDTO = new ResponseDTO();

        Object data  = reservationService.create(reservationDto);
        responseDTO.setData(data);
        if(data!=null){
            responseDTO.setStatus("SUCCESS");
            responseDTO.setDescription("Successful");
        } else{
            responseDTO.setStatus("ERROR");
            responseDTO.setDescription("Error");
        }
        return responseDTO;

    }

    @GetMapping()
    public ResponseEntity<List<Reservation>> readAll() {
        try{
            List<Reservation> list = reservationService.readAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex){
            logger.error("",ex);
            return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @PatchMapping("/{id}/transaction")
    public Reservation updateReservationTransactionById(@PathVariable Long id, @RequestBody Transaction transaction) {
        return reservationService.updateReservationTransactionById(id, transaction);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Reservation>> reservationByUserId(@PathVariable Long id) {
        //todo
        try{
            List<Reservation> list = reservationService.readAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex){
            logger.error("",ex);
            return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Reservation>> reservationByStatus(@PathVariable String status) {
        //todo
        try{
            List<Reservation> list = reservationService.readAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex){
            logger.error("",ex);
            return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @PatchMapping("/status/{status}")
    public ResponseEntity<List<Reservation>> updateReservationByStatus(@PathVariable String status) {
        //todo
        try{
            List<Reservation> list = reservationService.readAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex){
            logger.error("",ex);
            return new ResponseEntity<>(null, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
