package com.mcartagena.learnjava.io;

import java.io.File;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathBasics {
    public static void main(String[] args) {

        pathCreation();

    }

    public static void pathCreation() {
        //--- Using Path as a reference to a directory

        // Path object to current working directory
        Path currentWorkingDirectory = Paths.get("");
        System.out.println("currentWorkingDirectory " + currentWorkingDirectory);
        System.out.println("currentWorkingDirectory toAbsolutePath " + currentWorkingDirectory.toAbsolutePath());

        File currentDirectory = new File("");
        System.out.println("currentDirectory " + currentDirectory);
        System.out.println("currentDirectory " + currentDirectory.getAbsolutePath());

        // Specifying a full path using mac linux slashes
        Path directory = Path.of("/Users/la-marcelocartagena/workspace/java12/learnjava");
        System.out.println("Path of ");
        System.out.format("Directory: %s Absolute Path: %s", directory, directory.toAbsolutePath());

        // Using Paths.get with initial path as first argument and
        // remaining path as a single String, mixing back & forward slashes
        Path directoryMix = Paths.get("/Users/la-marcelocartagena/", "workspace/java12/learnjava");
        System.out.println("Path of ");
        System.out.format("Directory Mix: %s Absolute Path: %s", directoryMix, directoryMix.toAbsolutePath());

        // Using Path.of to get a path using Strings
        Path directoryUsingStrings = Path.of("/", "Users/la-marcelocartagena", "workspace/java12/learnjava");
        System.out.println("Path of ");
        System.out.format("Directory Using Strings: %s Absolute Path: %s", directoryUsingStrings, directoryUsingStrings.toAbsolutePath());

        //--- Using Path as a reference to a file

        // Use Paths.get to get a file reference with a URI
        Path fileURI = Path.of(URI.create("file:///Users/la-marcelocartagena/workspace/java12/learnjava/cereal.ser"));
        System.out.println("Path of ");
        System.out.format("Directory Using Strings: %s Absolute Path: %s", fileURI, fileURI.toAbsolutePath());


        // FileSystems.getDefault() gives default file system object
        // which has a method getPath
        Path fileSystemDefault = FileSystems.getDefault().getPath("/",
                "Users",
                "la-marcelocartagena",
                "workspace",
                "java12",
                "learnjava");
        System.out.println("Path of ");
        System.out.format("Directory Using SystemDefault: %s Absolute Path: %s", fileSystemDefault, fileSystemDefault.toAbsolutePath());

    }

}
