package com.example.geektrust.factory;

import com.example.geektrust.command.BalanceCommand;
import com.example.geektrust.command.Command;
import com.example.geektrust.command.LoanCommand;
import com.example.geektrust.command.PaymentCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandFactoryTest {

    @Test
    void shouldCreateLoanCommandObject() {
        Command command = CommandFactory.create("LOAN", new String[]{"LOAN", "IDIDI", "Dale", "4000", "3", "4"});
        assertEquals(command.getClass(), LoanCommand.class);
    }

    @Test
    void shouldCreatePaymentCommandObject() {
        Command command = CommandFactory.create("PAYMENT", new String[]{"PAYMENT", "MBI", "Dale", "2000", "0"});
        assertEquals(command.getClass(), PaymentCommand.class);
    }

    @Test
    void shouldCreateBalanceCommandObject() {
        Command command = CommandFactory.create("BALANCE", new String[]{"BALANCE", "IDIDI", "Dale", "3"});
        assertEquals(command.getClass(), BalanceCommand.class);
    }
}