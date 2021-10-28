package com.mcartagena.learnjava.io;

import java.nio.file.Files;
import java.nio.file.Path;

public class Resume {
    public void writeResume() throws Exception{
        var f1 = Path.of("/Users/la-marcelocartagena/workspace/java11-certification/files/templates/proofs");
        Files.createDirectories(f1);  // change 1
        var f2 = Path.of("/Users/la-marcelocartagena/workspace/java11-certification/files/templates");
        //Files.createDirectory(f2);  //k1 change 2  FileAlreadyExistsException

        try(var w = Files.newBufferedWriter(
                Path.of(f2.toString(),"draft.txt"))
        ){
            w.append("My dream job");
            w.flush();
        }

        Files.delete(f1);  // change 3
        Files.delete(f2);    // k2   // change 4  DirectoryNotEmptyException

    }

    public static void main(String[] args) {
        try{
            new Resume().writeResume();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
