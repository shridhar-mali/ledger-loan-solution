package com.example.geektrust;

import com.example.geektrust.command.Command;
import com.example.geektrust.factory.CommandFactory;
import com.example.geektrust.handler.CommandHandler;
import com.example.geektrust.model.CommandType;
import com.example.geektrust.processor.LedgerLoanProcessor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        CommandHandler commandHandler = new CommandHandler(new LedgerLoanProcessor());

        try {
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
                String currentLine = sc.nextLine();
                String[] arguments = currentLine.split(" ");
                CommandType commandType = CommandType.valueOf(arguments[0]);
                Command command = CommandFactory.create(arguments[0], arguments);
                commandHandler.handleCommand(command);
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
}
