package com.sachith.server.dto;

public class UserDTO {

    String name;
    String mobile;
    Character isLoyalty; // ("N","Y")
    String role; //(ADMIN,CUSTOMER)
    String password;

    public UserDTO(String name, String mobile, Character isLoyalty, String role, String password) {
        this.name = name;
        this.mobile = mobile;
        this.isLoyalty = isLoyalty;
        this.role = role;
        this.password = password;
    }

    public UserDTO() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", isLoyalty=" + isLoyalty +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
