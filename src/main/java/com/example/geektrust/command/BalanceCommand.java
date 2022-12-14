package com.example.geektrust.command;

import com.example.geektrust.processor.LedgerLoanProcessor;
import com.example.geektrust.model.Borrower;

public class BalanceCommand implements Command{
    private String bankName;
    private Integer emiNumber;
    private Borrower borrower;

    public String getBankName() {
        return bankName;
    }

    public Integer getEmiNumber() {
        return emiNumber;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public BalanceCommand(String bankName, String borrowerName, Integer emiNumber) {
        this.bankName = bankName;
        this.borrower = new Borrower(borrowerName, bankName);
        this.emiNumber = emiNumber;
    }

    @Override
    public void execute(LedgerLoanProcessor ledgerLoanProcessor) {
        Long totalPaidAmount = ledgerLoanProcessor.calculateTotalPaidAmount(this.getBorrower(), this.getEmiNumber());
        Integer pendingEMIs = ledgerLoanProcessor.calculatePendingEMIs(this.getBorrower(), this.getEmiNumber());
        StringBuilder output = new StringBuilder(this.getBankName());
        output.append(" ").append(this.getBorrower().getName()).append(" ");
        output.append(totalPaidAmount).append(" ");
        output.append(pendingEMIs);
        System.out.println(output.toString());
    }
}
