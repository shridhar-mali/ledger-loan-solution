package com.example.geektrust.command;

import com.example.geektrust.processor.LedgerLoanProcessor;

public interface Command {
    void execute(LedgerLoanProcessor ledgerLoanProcessor);
}
