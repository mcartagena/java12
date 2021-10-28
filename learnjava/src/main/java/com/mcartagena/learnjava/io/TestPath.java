package com.mcartagena.learnjava.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestPath {
    public static void main(String[] args) {
        Path p1 = Path.of("./found/..keys");
        Path p2 = Path.of("/lost/blue.txt");

        System.out.println("p1.resolve(p2) -> " + p1.resolve(p2));
        System.out.println("p2.resolve(p1) -> " + p2.resolve(p1));

        var p3 = Path.of("baseball.txt");
        var p4 = Path.of("/Users/la-marcelocartagena/workspace/java11-certification/files/home");
        var p5 = Path.of("/Users/la-marcelocartagena/workspace/java11-certification/files/away");

        try {
            Files.createDirectories(p4);
            System.out.println(p5.resolve(p3));
            System.out.println(p4);
            Files.copy(p5.resolve(p3), p4);  // FileAlreadyExistsException It's trying to copy baseball.txt to home as a file
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
