package com.mcartagena.learnjava.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Backup {
    public void performBackup() {
        try {
            throw new IOException("Disk not found");  // z1
        } catch (Exception e) {
            try {
                throw new FileNotFoundException("File not found");
            } catch (FileNotFoundException ex) {       // z2
                System.out.print("Failed");
            }
        }
    }

    public static void main(String[] args) {
        new Backup().performBackup();                // z3
    }

}
