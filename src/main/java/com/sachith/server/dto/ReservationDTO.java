package com.sachith.server.dto;

import com.sachith.server.model.ReservationSlot;
import com.sachith.server.model.Slot;
import com.sachith.server.model.Transaction;
import com.sachith.server.model.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public class ReservationDTO {

    private Transaction transaction;
    private  User user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
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
}
