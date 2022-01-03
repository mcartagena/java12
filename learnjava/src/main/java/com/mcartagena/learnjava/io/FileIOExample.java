package com.mcartagena.learnjava.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FileIOExample {

    // This method uses a FileWriter to print 10 random numbers
    private static void writeRandomNumbersToFile(String fileName) {
        String numbersList;

        try (var fileWriter = new FileWriter(fileName)) {
            numbersList = IntStream.range(0, 10)
                    .mapToObj(String::valueOf)
                    .reduce("", (first, second) -> String.join(" ", first, second));

            // Dump the string to the output file with a carriage return
            fileWriter.write(numbersList + "\n");

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    // This method uses a FileReader to read 10 random numbers
    private static void readRandomNumbersFromFile(String fileName) {
        List<Integer> numbersList = new ArrayList<>();
        try (var fileReader = new FileReader(fileName)) {
            int c;
            while ((c = fileReader.read()) != -1) {
                if (c != 32 && c != 10)
                    numbersList.add(c);
            }
        } catch (IOException io) {
            io.printStackTrace();
        }

        System.out.println(numbersList);
    }

    private static void writeRandomNumbersToFileUsingPrintWriter(String fileName) {
        String numbersList;
        try (var printWriter = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(fileName)
                )
        )) {
            numbersList = IntStream.range(0, 10)
                    .mapToObj(String::valueOf)
                    .reduce("", (first, second) -> String.join(" ", first, second));

            printWriter.println(numbersList);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    private static void readRandomNumbersFromFileUsingBufferedReader(String fileName) {
        List<Integer> numbersList = new ArrayList<>();
        try (var bufferedReader = new BufferedReader(
                new FileReader(fileName)
        )) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Arrays.asList(line.split("\\s"))
                        .forEach(s ->
                                numbersList.add(
                                        Integer.parseInt(
                                                s.equals("") ? "0" : s
                                        )
                                )
                        );
            }
        } catch (IOException io) {
            io.printStackTrace();
        }

        System.out.println(numbersList);
    }

    // This method uses a DataInputStream to write numbers in a list
    private static void writeRandomNumberDataStream(String fileName) {
        List<Integer> numbersList = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        try (var outputStream = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fileName)
                )
        )) {
            numbersList.forEach(s ->
                    {
                        try {
                            outputStream.writeInt(s);
                            System.out.println("Send to file -> " + s);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    // This method uses a DataInputStream to read 2500  numbers
    private static void readRandomNumbersDataSream(String fileName){
        List<Integer> numbers = new ArrayList<>();

        try(var inputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(fileName)
                )
        )) {
            try{
                while(true){
                    numbers.add(inputStream.readInt());
                }
            } catch (IOException io){
                io.printStackTrace();
            }

        } catch (IOException io){
            io.printStackTrace();
        }

        System.out.println(numbers);
    }

    public static void main(String[] args) {
        System.out.println("Writing strings to file");
        // writeRandomNumbersToFile("characterData.txt");
        // writeRandomNumbersToFileUsingPrintWriter("characterData.txt");

        // readRandomNumbersFromFile("characterData.txt");
        // readRandomNumbersFromFileUsingBufferedReader("characterData.txt");
        // writeRandomNumberDataStream("binaryIOData.bin");
        readRandomNumbersDataSream("binaryIOData.bin");

    }
}
