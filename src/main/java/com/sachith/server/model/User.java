package com.sachith.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sachith.server.constraint.Constant.UserRole;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String name;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade =   CascadeType.ALL)
    @JsonIgnore
    private List<Reservation> reservationList;

    @Column(unique = true)
    String mobile;

    Character isLoyalty; // ("N","Y")

    @Enumerated(EnumType.STRING)
    UserRole role; //(ADMIN,CUSTOMER)

    String password;

    public User(Long id, String name, String mobile, Character isLoyalty, UserRole role, String password) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.isLoyalty = isLoyalty;
        this.role = role;
        this.password = password;
    }

    public User() {
    }

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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public Character getIsLoyalty() {
        return isLoyalty;
    }

    public void setIsLoyalty(Character isLoyalty) {
        this.isLoyalty = isLoyalty;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "role=" + role +
                ", isLoyalty=" + isLoyalty +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
