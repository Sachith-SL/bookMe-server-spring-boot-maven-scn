package com.sachith.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String mobile;
    Character isLoyalty; //(Y,N)

//    todo: add these datatype and extend this
//    LocalDate dob
//    boolean isOk
//        double salary


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Character getIsLoyalty() {
        return isLoyalty;
    }

    public void setIsLoyalty(Character isLoyalty) {
        this.isLoyalty = isLoyalty;
    }
}
