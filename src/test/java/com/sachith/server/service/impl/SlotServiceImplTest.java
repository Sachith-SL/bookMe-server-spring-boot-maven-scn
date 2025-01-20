package com.sachith.server.service.impl;

import com.sachith.server.model.Slot;
import com.sachith.server.repository.SlotRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class SlotServiceImplTest {


    @InjectMocks
    SlotServiceImpl slotService;

    @Mock
    SlotRepository slotRepository;

    @Test
    public void availableSlotsByDateTest() {
        //Arrange
        String strDate = "2024-09-11";
        LocalDate expectedDate = LocalDate.of(2024, 9, 11);
        List<Slot> expectedList = createSlotList();

        Mockito.when(slotRepository.findByIsAvailableAndDate(true, expectedDate))
                .thenReturn(expectedList);

        //Act
        List<Slot> actualList = slotService.availableSlotsByDate(strDate);

        //Assert
        Assertions.assertEquals(expectedList, actualList);
    }

    private List<Slot> createSlotList() {
        List<Slot> slots = new ArrayList<>();
        Slot slot = new Slot(21L,
                LocalDate.of(2024, 9, 11),
                7,
                LocalTime.of(07, 00, 00),
                LocalTime.of(07, 00, 00),
                2000,
                true);
        slots.add(slot);
        return slots;

    }

}