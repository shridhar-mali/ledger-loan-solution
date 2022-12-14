package com.example.geektrust.command;

import com.example.geektrust.processor.LedgerLoanProcessor;
import com.example.geektrust.model.Borrower;

public class PaymentCommand implements Command {
    private String bankName;
    private Long amount;
    private Integer emiNumber;
    private Borrower borrower;

    public String getBankName() {
        return bankName;
    }

    public Long getAmount() {
        return amount;
    }

    public Integer getEmiNumber() {
        return emiNumber;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public PaymentCommand(String bankName, String borrowerName, Long amount, Integer emiNumber) {
        this.bankName = bankName;
        this.borrower = new Borrower(borrowerName, bankName);
        this.amount = amount;
        this.emiNumber = emiNumber;
    }

    @Override
    public void execute(LedgerLoanProcessor ledgerLoanProcessor) {
        ledgerLoanProcessor.handlePayment(this);
    }
}
