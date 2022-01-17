package com.mcartagena.datastructure.liststructure;

import com.mcartagena.model.Division;
import com.mcartagena.model.Employee;

import java.util.Date;
import java.util.List;
import java.util.Vector;

public class TestVector {
    public static void main(String[] args) {
        List<Employee> employeeList = new Vector<>();

        employeeList.add(new Employee(123, "Jane Jones", new Division(1, "Catalyst"), new Date()));
        employeeList.add(new Employee(4567, "John Doe", new Division(2, "ATG"), new Date()));
        employeeList.add(new Employee(22, "Mary Smith", new Division(1, "Catalyst"), new Date()));
        employeeList.add(new Employee(3245, "Mike Wilson", new Division(2, "ATG"), new Date()));

        employeeList.forEach(System.out::println);
    }
}
