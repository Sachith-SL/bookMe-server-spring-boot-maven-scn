package com.sachith.server.service;

import com.sachith.server.model.Slot;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface SlotService {

    public Slot create(Slot slot);
    public List<Slot> readAll() ;
    public Slot findById(Long id);
    public List<Slot> availableSlotsByDate(String date);

}
