package com.example.geektrust.handler;

import com.example.geektrust.processor.LedgerLoanProcessor;
import com.example.geektrust.command.Command;

public class CommandHandler {

    private LedgerLoanProcessor ledgerLoanProcessor;

    public CommandHandler(LedgerLoanProcessor ledgerLoanProcessor) {
        this.ledgerLoanProcessor = ledgerLoanProcessor;
    }

    public void handleCommand(Command command) {
        command.execute(ledgerLoanProcessor);
    }
}
