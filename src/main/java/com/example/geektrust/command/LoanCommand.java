package com.example.geektrust.command;

import com.example.geektrust.processor.LedgerLoanProcessor;
import com.example.geektrust.model.Borrower;

public class LoanCommand implements Command {
    private String bankName;
    private Long amount;
    private Integer years;
    private Double interestRate;
    private Borrower borrower;

    public String getBankName() {
        return bankName;
    }

    public Long getAmount() {
        return amount;
    }

    public Integer getYears() {
        return years;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public LoanCommand(String bankName, String borrowerName, Long amount, Integer years, Double interestRate) {
        this.bankName = bankName;
        this.borrower = new Borrower(borrowerName, bankName);
        this.amount = amount;
        this.years = years;
        this.interestRate = interestRate;
    }

    @Override
    public void execute(LedgerLoanProcessor ledgerLoanProcessor) {
        ledgerLoanProcessor.saveLoanDetails(this);
    }
}
