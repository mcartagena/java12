package com.mcartagena.learnjava.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CerealSerialize {
    public static void main(String[] args) throws Exception {
        Cereal cereal = new Cereal();

        System.out.println(cereal);
        System.out.println(cereal.getCategory());

        FileOutputStream fos = new FileOutputStream("cereal.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(cereal);

        FileInputStream fis = new FileInputStream("cereal.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Cereal cereal2 = (Cereal) ois.readObject();
        System.out.println(cereal2);
        System.out.println(cereal2.getCategory());

    }
}
