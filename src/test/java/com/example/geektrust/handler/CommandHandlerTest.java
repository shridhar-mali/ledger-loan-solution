package com.example.geektrust.handler;

import com.example.geektrust.command.BalanceCommand;
import com.example.geektrust.processor.LedgerLoanProcessor;
import com.example.geektrust.command.LoanCommand;
import com.example.geektrust.command.PaymentCommand;
import com.example.geektrust.model.Borrower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandHandlerTest {

    @Test
    void shouldHandleLoanCommand() {
        LedgerLoanProcessor ledgerLoanProcessor = new LedgerLoanProcessor();

        CommandHandler commandHandler = new CommandHandler(ledgerLoanProcessor);

        commandHandler.handleCommand(new LoanCommand("IDIDI", "Joe", 10000l, 3 , 3d));

        assertEquals(ledgerLoanProcessor.calculateTotalPaidAmount(new Borrower("Joe", "IDIDI"), 1), 303);
    }


    @Test
    void shouldHandlePaymentCommand() {
        LedgerLoanProcessor ledgerLoanProcessor = new LedgerLoanProcessor();

        CommandHandler commandHandler = new CommandHandler(ledgerLoanProcessor);

        commandHandler.handleCommand(new LoanCommand("IDIDI", "Joe", 10000l, 3 , 3d));
        commandHandler.handleCommand(new PaymentCommand("IDIDI", "Joe", 1000l, 1));

        assertEquals(ledgerLoanProcessor.calculateTotalPaidAmount(new Borrower("Joe", "IDIDI"), 1), 1303);
    }

    @Test
    void shouldHandleBalanceCommand() {
        LedgerLoanProcessor ledgerLoanProcessor = new LedgerLoanProcessor();

        CommandHandler commandHandler = new CommandHandler(ledgerLoanProcessor);

        commandHandler.handleCommand(new LoanCommand("IDIDI", "Joe", 10000l, 3 , 3d));
        commandHandler.handleCommand(new BalanceCommand("IDIDI", "Joe", 1));

        assertEquals(ledgerLoanProcessor.calculateTotalPaidAmount(new Borrower("Joe", "IDIDI"), 1), 303);
        assertEquals(ledgerLoanProcessor.calculatePendingEMIs(new Borrower("Joe", "IDIDI"), 1), 35);
    }
}