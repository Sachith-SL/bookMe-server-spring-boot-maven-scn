package com.sachith.server.service.impl;

import com.sachith.server.model.Slot;
import com.sachith.server.repository.SlotRepository;
import com.sachith.server.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class SlotServiceImpl implements SlotService {

    @Autowired
    private SlotRepository slotRepository;

    @Override
    public Slot create(Slot slot) {
        return slotRepository.save(slot);
    }

    @Override
    public List<Slot> readAll() {
        return slotRepository.findAll();
    }

    @Override
    public Slot findById(Long id) {
        Optional<Slot> optionalSlot =slotRepository.findById(id);
         return optionalSlot.isPresent()?optionalSlot.get():null;
    }

    @Override
    public List<Slot> availableSlotsByDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");//2024-08-12
        LocalDate date = LocalDate.parse(dateString, formatter);
        return slotRepository.findByIsAvailableAndDate(true,date);
    }
}
