package com.sachith.server.controller;

import com.sachith.server.model.Slot;
import com.sachith.server.model.User;
import com.sachith.server.repository.SlotRepository;
import com.sachith.server.repository.UserRepository;
import com.sachith.server.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slots")
public class SlotController {
    @Autowired
    private SlotService slotService;

    @PostMapping()
    public Slot create(@RequestBody Slot slot) {
        return slotService.create(slot);
    }

    @GetMapping()
    public List<Slot> readAll() {
        return slotService.readAll();
    }

    @GetMapping("/available")
    public List<Slot> availableSlotsByDate(@RequestParam(value = "date", required = false) String date) {
//        todo
        return slotService.readAll();
    }
}
