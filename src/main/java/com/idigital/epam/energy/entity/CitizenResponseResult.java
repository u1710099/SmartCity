package com.idigital.epam.energy.entity;

public class CitizenResponseResult {

    private Integer cardNumber;
    private String firstName;
    private String lastName;
    private boolean active;

    public CitizenResponseResult() {
    }

    public CitizenResponseResult(Integer cardNumber, String firstName, String lastName, boolean active) {
        this.cardNumber = cardNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}
