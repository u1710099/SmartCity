package com.idigital.epam.energy.entity;

public class CitizenResponse {

    private String message;
    private CitizenResponseResult result;

    public CitizenResponse() {
    }

    public CitizenResponse(String message, CitizenResponseResult result) {
        this.message = message;
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CitizenResponseResult getResult() {
        return result;
    }

    public void setResult(CitizenResponseResult result) {
        this.result = result;
    }

}
