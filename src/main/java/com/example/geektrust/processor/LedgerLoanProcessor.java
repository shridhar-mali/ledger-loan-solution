package com.example.geektrust.processor;

import com.example.geektrust.command.LoanCommand;
import com.example.geektrust.command.PaymentCommand;
import com.example.geektrust.model.Borrower;
import com.example.geektrust.model.Loan;
import com.example.geektrust.model.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;

public class LedgerLoanProcessor {
    private static final int HUNDRED = 100;
    private Map<Borrower, Loan> loanInfoMap;
    private Map<Borrower, List<Payment>> borrowerPrePayments;

    public LedgerLoanProcessor() {
        this.loanInfoMap = new HashMap<>();
        this.borrowerPrePayments = new HashMap<>();
    }

    public void saveLoanDetails(LoanCommand loanCommand) {
        loanInfoMap.put(loanCommand.getBorrower(), new Loan(loanCommand.getBankName(), loanCommand.getAmount(), loanCommand.getInterestRate(), loanCommand.getYears()));
    }

    public void handlePayment(PaymentCommand paymentCommand) {
        Payment payment = new Payment(paymentCommand.getAmount(), paymentCommand.getEmiNumber());
        List<Payment> payments = borrowerPrePayments.getOrDefault(paymentCommand.getBorrower(), new ArrayList<>());
        payments.add(payment);
        borrowerPrePayments.put(paymentCommand.getBorrower(), payments);
    }

    public Long calculateTotalPaidAmount(Borrower borrower, Integer emiNumber) {
        Loan loan = loanInfoMap.get(borrower);
        Double totalAmountToRepay = loan.getAmount() + (loan.getAmount() * loan.getInterestRate() * loan.getYears()) / HUNDRED;
        Integer emi = loan.getEmi();
        Long totalAmountPaid = Long.valueOf(emiNumber * emi);
        Double totalPrePayment = borrowerPrePayments.getOrDefault(borrower, emptyList()).stream().filter(payment -> payment.getEmiNumber() <= emiNumber).mapToDouble(Payment::getAmount).sum();
        totalAmountPaid += totalPrePayment.longValue();
        return totalAmountToRepay.longValue() < totalAmountPaid ? totalAmountToRepay.longValue() : totalAmountPaid;
    }

    public Integer calculatePendingEMIs(Borrower borrower, Integer emiNumber) {
        Loan loan = loanInfoMap.get(borrower);
        double totalAmountToRepay = loan.getAmount() + (loan.getAmount() * loan.getInterestRate() * loan.getYears()) / HUNDRED;
        return (int) Math.ceil((totalAmountToRepay - calculateTotalPaidAmount(borrower, emiNumber)) / (double) loan.getEmi());
    }
}
