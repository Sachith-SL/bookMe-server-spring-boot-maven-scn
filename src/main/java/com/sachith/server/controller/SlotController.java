package com.sachith.server.controller;

import com.sachith.server.model.Slot;
import com.sachith.server.model.User;
import com.sachith.server.repository.SlotRepository;
import com.sachith.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slot")
public class SlotController {
    @Autowired
    private SlotRepository slotRepository;

    @PostMapping()
    public Slot create(@RequestBody Slot slot) {
        return slotRepository.save(slot);
    }

    @GetMapping()
    public List<Slot> readAll() {
        return slotRepository.findAll();
    }
}
