package com.bridgelabz.employeepayrollapplication.DTO;

import lombok.Data;

public @Data class ResponseDTO {
    //private String message;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /*public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }*/

    public ResponseDTO(Object data) {
        this.data = data;
    }
}
