package com.example.geektrust.model;

public class Payment {
    private final Long amount;
    private final Integer emiNumber;

    public Payment(Long amount, Integer emiNumber) {
        this.amount = amount;
        this.emiNumber = emiNumber;
    }

    public Long getAmount() {
        return amount;
    }

    public Integer getEmiNumber() {
        return emiNumber;
    }
}
