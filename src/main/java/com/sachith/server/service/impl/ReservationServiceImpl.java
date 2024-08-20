package com.sachith.server.service.impl;

import com.sachith.server.dto.ReservationDTO;
import com.sachith.server.model.*;
import com.sachith.server.repository.ReservationRepository;
import com.sachith.server.repository.ReservationSlotRepository;
import com.sachith.server.repository.SlotRepository;
import com.sachith.server.service.ReservationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private ReservationSlotRepository reservationSlotRepository;

    @Override
    @Transactional
    public Reservation create(ReservationDTO reservationDto) {
        try {
            Boolean bookingSlotsAvalability =false;
            User user = reservationDto.getUser();
            List<Slot> slots = reservationDto.getSlots();
            List<Slot> bookingSlots = new ArrayList<>();
            Integer totalAmount = 0;

            for(Slot slot: slots){
                if(slot.getId() != null){
                    Slot existingSlot = slotRepository.findById(slot.getId()).get();
                    if(existingSlot.getAvailable() == true && existingSlot.getDate().equals(reservationDto.getDate())){
                        bookingSlots.add(existingSlot);
                        bookingSlotsAvalability=true;
                        totalAmount +=existingSlot.getUnitPrice();
                    }
                }
            }
            if(!bookingSlotsAvalability) throw new Exception();


            Reservation reservation = new Reservation();

            if(reservationDto.getTransaction() ==null){
                reservation.setTransaction(new Transaction());
            }
            reservation.setUser(user);
            reservation.setDate(reservationDto.getDate());
            reservation.setAmount(totalAmount);
            reservation.setStatus(reservationDto.getStatus());
            Reservation createdReservation = reservationRepository.save(reservation);

            for(Slot slot:bookingSlots){
                ReservationSlot reservationSlot = new ReservationSlot();
                slot.setAvailable(false);
                slotRepository.save(slot);
                reservationSlot.setReservation(createdReservation);
                reservationSlot.setSlot(slot);
                reservationSlotRepository.save(reservationSlot);
            }
            return createdReservation;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Reservation> readAll() {

        try{
            List<Reservation> list = reservationRepository.findAll();
            return list;
        } catch (Exception e){
            return null;
        }

    }

    @Override
    public Reservation updateReservationTransactionById(Long id, Transaction transaction) {

        Optional<Reservation> optionalReservation = reservationRepository.findById(id);

        if(optionalReservation.isPresent()){
            Reservation oldReservation =optionalReservation.get();
            Transaction oldTransaction =oldReservation.getTransaction();
            oldTransaction.setDate(transaction.getDate());
            oldTransaction.setPaymentMethod(transaction.getPaymentMethod());
            oldTransaction.setAmount(transaction.getAmount());
            oldTransaction.setStatus(transaction.getStatus());

            return reservationRepository.save(oldReservation);
        }
        return null;

    }


}
