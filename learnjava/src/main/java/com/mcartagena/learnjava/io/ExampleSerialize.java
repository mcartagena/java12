package com.mcartagena.learnjava.io;

import java.io.*;
class Student implements Serializable{
    public static String name = "Cielo";

    public Student(String name){
        this.name = name;
    }
    public static String getName() {
        return name;
    }
    public static void setAge(String name) {
        Student.name = name;
    }
}

public class ExampleSerialize{
    public static void main(String args[]) throws Exception{

        System.out.println(Student.name);

        Student std1 = new Student("Marcelo");
        FileOutputStream fos = new FileOutputStream("student.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(std1);

        FileInputStream fis = new FileInputStream("student.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student std2 = (Student) ois.readObject();
        System.out.println(std2.getName());
    }
}
