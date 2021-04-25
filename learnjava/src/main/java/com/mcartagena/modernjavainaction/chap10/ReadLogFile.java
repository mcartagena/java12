package com.mcartagena.modernjavainaction.chap10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ReadLogFile {

    private static final String FILE = ReadLogFile.class.getResource("./logfile.log").getFile();

    public static void main(String[] args) throws IOException {

        List<String> errors = new ArrayList<>();
        int errorCount = 0;
        String fileName = FILE;

        BufferedReader bufferedReader
                = new BufferedReader(new FileReader(fileName));
        String line = bufferedReader.readLine();
        while (errorCount < 40 && line != null) {
            if (line.contains("ERROR")) {
                errors.add(line);
                errorCount++;
            }
            line = bufferedReader.readLine();
        }

        System.out.printf("The File has %d errors", errorCount);

        // Achieving the same result in a more functional style

        System.out.println("\nAchieving the same result in a more functional style");

        List<String> errorsStream = Files.lines(Paths.get(fileName))
                .filter(lineStream -> lineStream.contains("ERROR"))
                .limit(40)
                .collect(toList());

        System.out.printf("The File has %d errors", errorsStream.size());

    }
}
