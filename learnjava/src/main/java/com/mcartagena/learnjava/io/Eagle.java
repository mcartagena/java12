package com.mcartagena.learnjava.io;

import java.io.*;

class Bird {
    protected transient String name;
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
    public Bird() {
        this.name = "Matt";
    }
}
public class Eagle extends Bird implements Serializable {
    { this.name = "Olivia"; }
    public Eagle() {
        this.name = "Bridget";
    }
    public static void main(String[] args) throws Exception {
        var e = new Eagle();
        e.name = "Adeline";

        System.out.println(e.name);  // Adeline

        FileOutputStream fos = new FileOutputStream("Eagle.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(e);

        FileInputStream fis = new FileInputStream("Eagle.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Eagle e2 = (Eagle) ois.readObject();

        System.out.println(e2.name);  // Matt
    }
}
