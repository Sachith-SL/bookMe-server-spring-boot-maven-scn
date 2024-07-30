package com.sachith.server.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Slot {
    Long id;
    LocalDate date;
    LocalTime startTime;
    LocalTime endTime;
    Integer unitPrice;
    Boolean isAvailable;

}
