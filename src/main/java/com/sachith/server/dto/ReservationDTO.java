package com.sachith.server.dto;

import com.sachith.server.model.Slot;
import com.sachith.server.model.User;

import java.time.LocalDate;
import java.util.List;

public class ReservationDTO {

    Long id;
    User user;
    LocalDate date;
    List<Slot> slotList;
    Integer amount;
    String status;
}
