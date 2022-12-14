package com.example.geektrust.factory;

import com.example.geektrust.command.BalanceCommand;
import com.example.geektrust.command.Command;
import com.example.geektrust.command.LoanCommand;
import com.example.geektrust.command.PaymentCommand;

public final class CommandFactory {

    public static Command create(String commandString, String[] arguments) {
        Command command;
        switch (commandString) {
            case "LOAN" :
                command = new LoanCommand(arguments[1], arguments[2], Long.valueOf(arguments[3]), Integer.valueOf(arguments[4]), Double.valueOf(arguments[5]));
                break;
            case "PAYMENT" :
                command = new PaymentCommand(arguments[1], arguments[2], Long.valueOf(arguments[3]), Integer.valueOf(arguments[4]));
                break;
            case "BALANCE" :
                command = new BalanceCommand(arguments[1], arguments[2], Integer.valueOf(arguments[3]));
                break;
            default:
                throw new IllegalStateException("Unexpected command value: " + commandString);
        }
        return command;
    }
}
