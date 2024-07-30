package com.sachith.server.model;

import java.time.LocalDate;

public class Reservation {
    Long id;
    User user;
    LocalDate date;
    Integer amount;
    String status; // (PENDING, CONFIRMED, IN_PROGRESS, COMPLETED)

    public Reservation(Long id, User user, LocalDate date, Integer amount, String status) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
