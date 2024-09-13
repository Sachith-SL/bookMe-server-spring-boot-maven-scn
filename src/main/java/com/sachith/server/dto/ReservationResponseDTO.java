package com.sachith.server.dto;

import com.sachith.server.model.Slot;
import com.sachith.server.model.Transaction;

import java.time.LocalDate;
import java.util.List;

public class ReservationResponseDTO {

    private Transaction transaction;
    private  Long userId;
    private List<Slot> slots;
    private LocalDate date;
    private Integer amount;
    private String status;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
