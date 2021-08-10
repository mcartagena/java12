package com.mcartagena.learnjava.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Clock;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class BigFile {

    private static final int MAP_SIZE = 5242880; // 5 MB in bytes

    public static void main(String[] args) throws IOException {
        Clock clock = Clock.systemUTC();
        Path storyFile = Paths.get("story.txt");
        String search = "remarkable";

        long startTimeV1 = clock.millis();
        long countV1 = countOccurrences(storyFile, search, StandardCharsets.UTF_8);
        displayExecutionTime(clock.millis() - startTimeV1);
        System.out.println("V1 BufferedReader: '" + search + "' was found " + countV1 + " times\n");

        long startTimeV2 = clock.millis();
        long countV2 = countOccurrencesRAM(storyFile, search, StandardCharsets.UTF_8);
        displayExecutionTime(clock.millis() - startTimeV2);
        System.out.println("V2 RAM: '" + search + "' was found " + countV2 + " times\n");

        long startTimeV3 = clock.millis();
        long countV3 = countOccurrencesLazy(storyFile, search, StandardCharsets.UTF_8);
        displayExecutionTime(clock.millis() - startTimeV3);
        System.out.println("V3 Lazy: '" + search + "' was found " + countV3 + " times\n");

        long startTimeV4 = clock.millis();
        long countV4 = countOccurrencesScanner(storyFile, search, StandardCharsets.UTF_8);
        displayExecutionTime(clock.millis() - startTimeV4);
        System.out.println("V4 Scanner: '" + search + "' was found " + countV4 + " times\n");

        long startTimeV5 = clock.millis();
        long countV5 = countOccurrences(storyFile, search);
        displayExecutionTime(clock.millis() - startTimeV5);
        System.out.println("V5 MappedByteBuffer: '" + search + "' was found " + countV5 + " times");

    }

    private static int countStringInString(String string, String tofind) {
        if (string == null || tofind == null) {
            throw new IllegalArgumentException("The given strings cannot be null");
        }

        if (string.isBlank() || tofind.isBlank()) {
            return 0;
        }

        return string.split(Pattern.quote(tofind), -1).length - 1;
    }

    public static int countOccurrences(Path path, String text, Charset ch)
            throws IOException {
        if (path == null || text == null) {
            throw new IllegalArgumentException("Path/text cannot be null");
        }

        if (text.isBlank()) {
            return 0;
        }

        if (ch == null) {
            ch = StandardCharsets.UTF_8;
        }

        int count = 0;
        try (BufferedReader br = Files.newBufferedReader(path, ch)) {

            String line;
            while ((line = br.readLine()) != null) {
                count += countStringInString(line, text);
            }
        }

        return count;
    }

    public static int countOccurrencesRAM(Path path, String text, Charset ch)
            throws IOException {

        if (path == null || text == null) {
            throw new IllegalArgumentException("Path/text cannot be null");
        }

        if (text.isBlank()) {
            return 0;
        }

        if (ch == null) {
            ch = StandardCharsets.UTF_8;
        }

        return Files.readAllLines(path, ch).parallelStream()
                .mapToInt((p) -> countStringInString(p, text))
                .sum();
    }

    public static int countOccurrencesLazy(Path path, String text, Charset ch)
            throws IOException {
        if (path == null || text == null) {
            throw new IllegalArgumentException("Path/text cannot be null");
        }

        if (text.isBlank()) {
            return 0;
        }

        if (ch == null) {
            ch = StandardCharsets.UTF_8;
        }

        return Files.lines(path, ch).parallel()
                .mapToInt((p) -> countStringInString(p, text))
                .sum();
    }

    public static long countOccurrencesScanner(
            Path path, String text, Charset ch) throws IOException {
        if (path == null || text == null) {
            throw new IllegalArgumentException("Path/text cannot be null");
        }

        if (text.isBlank()) {
            return 0;
        }

        if (ch == null) {
            ch = StandardCharsets.UTF_8;
        }

        long count;

        try (Scanner scanner = new Scanner(path, ch)
                .useDelimiter(Pattern.quote(text))) {

            count = scanner.tokens().count() - 1;
        }

        return count;
    }

    public static long countOccurrences(Path path, String text)
            throws IOException {
        if (path == null || text == null) {
            throw new IllegalArgumentException("Path/text cannot be null");
        }

        if (text.isBlank()) {
            return 0;
        }

        final byte[] texttofind = text.getBytes(StandardCharsets.UTF_8);

        long count = 0;
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {

            long position = 0;
            long length = fileChannel.size();
            while (position < length) {

                long remaining = length - position;
                long bytestomap = Math.min(MAP_SIZE, remaining);
                MappedByteBuffer mbBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, position, bytestomap);

                long limit = mbBuffer.limit();
                long lastSpace = -1;
                long firstChar = -1;
                while (mbBuffer.hasRemaining()) {

                    boolean isFirstChar = false;
                    while (firstChar != 0 && mbBuffer.hasRemaining()) {

                        byte currentByte = mbBuffer.get();

                        if (Character.isWhitespace((char) currentByte)) {
                            lastSpace = mbBuffer.position();
                        }

                        if (texttofind[0] == currentByte) {
                            isFirstChar = true;
                            break;
                        }
                    }

                    if (isFirstChar) {

                        boolean isRestOfChars = true;

                        int j;
                        for (j = 1; j < texttofind.length; j++) {
                            if (!mbBuffer.hasRemaining() || texttofind[j] != mbBuffer.get()) {
                                isRestOfChars = false;
                                break;
                            }
                        }

                        if (isRestOfChars) {
                            count++;
                            lastSpace = -1;
                        }

                        firstChar = -1;
                    }
                }

                if (lastSpace > -1) {
                    position = position - (limit - lastSpace);
                }

                position += bytestomap;
            }
        }

        return count;

    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ms" + " ("
                + TimeUnit.SECONDS.convert(time, TimeUnit.MILLISECONDS) + " s)");
    }

}
