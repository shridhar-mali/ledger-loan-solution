package com.example.geektrust.model;

public class Loan {
    private final String bankName;
    private final Long amount;
    private final Double interestRate;
    private final Integer years;
    private final Integer emi;

    public Loan(String bankName, Long amount, Double interestRate, Integer years) {
        this.bankName = bankName;
        this.amount = amount;
        this.interestRate = interestRate;
        this.years = years;
        this.emi = (int) Math.ceil((amount + (amount * years * interestRate)/100)/(years * 12));
    }

    public String getBankName() {
        return bankName;
    }

    public Long getAmount() {
        return amount;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public Integer getYears() {
        return years;
    }

    public Integer getEmi() {
        return emi;
    }
}
