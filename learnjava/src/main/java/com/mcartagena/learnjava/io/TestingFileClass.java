package com.mcartagena.learnjava.io;

import java.io.File;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TestingFileClass {
    private File fileEmployee;
    private static TestingFileClass testingFileClass = null;

    public static TestingFileClass getInstance(String path) {
        if (testingFileClass == null) {
            testingFileClass = new TestingFileClass();
            testingFileClass.fileEmployee = new File(path);
        }
        return testingFileClass;
    }

    public static void main(String[] args) {
        TestingFileClass testingFileClass = TestingFileClass.getInstance("./employee.ser");

        if (testingFileClass.fileEmployee.exists())
            System.out.println("The file exists...");
        else
            return;

        String absPath = testingFileClass.fileEmployee.getAbsolutePath();

        System.out.println(absPath);

        String parentDirectory = testingFileClass.fileEmployee.getParent();

        System.out.println(parentDirectory);

        if (testingFileClass.fileEmployee.isFile())
            System.out.println("is File");

        if (testingFileClass.fileEmployee.isDirectory())
            System.out.println("is Directory");

        long lastMod = testingFileClass.fileEmployee.lastModified();

        System.out.println("last modified:" + lastMod);

        Instant instant = Instant.ofEpochMilli(lastMod);

        ZoneId zoneId = ZoneId.of("America/Santiago");

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneId);

        System.out.println("Date " + zonedDateTime + " Day " + zonedDateTime.getDayOfWeek());

        long size = testingFileClass.fileEmployee.length();

        System.out.println("size " + size + " bytes");

        File[] files = new File(parentDirectory).listFiles();
        System.out.println("List of files in " + parentDirectory);

        if (files != null) {
            for (File file : files) {
                if (file.isFile())
                    System.out.println(file.getName());
            }
        }

        if (new File(parentDirectory.concat("directory1")).mkdir())
            System.out.println("directory1 created");

        if (new File(parentDirectory.concat("directory1/directory2/directory3")).mkdirs())
            System.out.println("directory1 directory2 and directory3 created");

        if (new File(parentDirectory.concat("directory1/directory2/directory3")).renameTo(new File("directory4")))
            System.out.println("rename to directory4");

        if (new File("directory4").delete())
            System.out.println("directory4 deleted");
        else
            System.out.println("directory4 dont deleted");

        if (new File(parentDirectory.concat("directory1/directory2")).delete())
            System.out.println("directory2 deleted");
        else
            System.out.println("directory2 dont deleted");

        if (new File(parentDirectory.concat("directory1")).delete())
            System.out.println("directory1 deleted");
        else
            System.out.println("directory1 dont deleted");
    }

}
