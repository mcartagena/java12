package com.mcartagena.learnjava.io;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class ConsoleExamples {

    public static void main(String[] args) {

        Console console = System.console();

        LocalDateTime currentDate = LocalDateTime.now();

        String name;

        if (console != null) {
            // Console support a simple printf statement
            console.printf("Interacting with user via Console\n");

            // read a line from console terminated by the enter key
            name = console.readLine("What is your name? ");

            // print data to console
            console.writer().println("Your input is appreciated, " + name);

            console.format("The local date and time is %1$tF %1$tr", currentDate);
        } else {
            // console is not available
            System.out.println("Interacting with user via standard input/output streams");
            System.out.println("What is your name?");

            // Read in text using carriage return with BufferedReader
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in)
            );

            try {
                name = reader.readLine();

                // Output the name user typed in

                System.out.println("Your input is appreciated, " + name);
                System.out.println(String.format("The local date and time is: %1$tF %1$tr", currentDate));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
