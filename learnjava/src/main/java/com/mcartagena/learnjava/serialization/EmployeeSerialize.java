package com.mcartagena.learnjava.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EmployeeSerialize {
    public static void main(String[] args) throws Exception{
        Employee emp1 = Employee.getEmployee("Marcelo","12345");

        System.out.println(emp1);

        FileOutputStream fos = new FileOutputStream("employee.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(emp1);

        FileInputStream fis = new FileInputStream("employee.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Employee emp2 = (Employee) ois.readObject();
        System.out.println(emp2);
    }
}
