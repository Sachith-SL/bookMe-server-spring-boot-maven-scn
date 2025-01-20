package com.sachith.server.service.impl;

import com.sachith.server.dto.DateDto;
import com.sachith.server.model.Slot;
import com.sachith.server.repository.SlotRepository;
import com.sachith.server.service.SlotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SlotServiceImpl implements SlotService {

    Logger logger = LoggerFactory.getLogger(SlotServiceImpl.class);

    @Autowired
    private SlotRepository slotRepository;

    @Override
    public Slot create(Slot slot) {
        return slotRepository.save(slot);
    }

    @Override
    public String createAllSlotsForGivenDate(DateDto dateDto) {
        String response ="Slot set creation fail";
        try{
            LocalDate date = dateDto.getDate();
            List<Slot> slotList = new ArrayList<>();
            for(int i =6; i<24;i++){
                Slot slot = new Slot();
                slot.setDate(date);
                slot.setStartTime(LocalTime.of(i,0));
                if(i==23){
                    slot.setEndTime(LocalTime.of(0,0));
                } else{
                    slot.setEndTime(LocalTime.of(i+1,0));
                }
                slot.setSlotIndex(i);
                if(i>=17){
                    slot.setUnitPrice(3000);
                } else {
                    slot.setUnitPrice(2000);
                }

                slot.setAvailable(true);
                slotList.add(slot);
            }
            for(Slot slot:slotList){
                slotRepository.save(slot);
            }
            response = "Slot set creation successful";
        } catch(Exception ex) {
            logger.error("", ex);
        }
        return response;
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
        return slotRepository. findByIsAvailableAndDate(true,formatDate(dateString));
    }

    private LocalDate formatDate(String dateStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");//2024-08-12
        return LocalDate.parse(dateStr, formatter);
    }
}
