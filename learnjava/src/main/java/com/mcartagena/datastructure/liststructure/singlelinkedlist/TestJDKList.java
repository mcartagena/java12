package com.mcartagena.datastructure.liststructure.singlelinkedlist;

import com.mcartagena.model.Division;
import com.mcartagena.model.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestJDKList {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(123, "Jane Jones", new Division(1, "Catalyst"), new Date()));
        employeeList.add(new Employee(4567, "John Doe", new Division(2, "ATG"), new Date()));
        employeeList.add(new Employee(22, "Mary Smith", new Division(1, "Catalyst"), new Date()));
        employeeList.add(new Employee(3245, "Mike Wilson", new Division(2, "ATG"), new Date()));

//        employeeList.forEach(System.out::println);
//
//        System.out.println(employeeList.get(1));
//        System.out.println(employeeList.isEmpty());

        employeeList.add(1, new Employee(4568, "John Adams", new Division(2, "ATG"), new Date()));

//        employeeList.forEach(System.out::println);
//        System.out.println(employeeList.size());

        employeeList.add(3, new Employee(4567, "John Doe", new Division(2, "ATG"), new Date()));

//        employeeList.forEach(System.out::println);

//        Employee[] empArray = employeeList.toArray(new Employee[employeeList.size()]);
//
//        for(Employee emp : empArray)
//            System.out.println(emp);

        System.out.println(employeeList.contains(new Employee(4567, "John Doe", new Division(2, "ATG"), new Date())));
        System.out.println(employeeList.indexOf(new Employee(3245, "Mike Wilson", new Division(2, "ATG"), new Date())));

        employeeList.remove(2);
        employeeList.forEach(System.out::println);

    }
}
