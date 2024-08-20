package com.sachith.server.dto;

public class ResponseDTO {
    private String status;
    private Object data;
    private String description;

    public String getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
