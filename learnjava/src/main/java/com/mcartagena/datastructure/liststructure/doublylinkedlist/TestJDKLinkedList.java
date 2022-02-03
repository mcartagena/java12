package com.mcartagena.datastructure.liststructure.doublylinkedlist;

import com.mcartagena.model.Division;
import com.mcartagena.model.Employee;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public class TestJDKLinkedList {
    public static void main(String[] args) {
        var employeeList = new LinkedList<Employee>();

        employeeList.addFirst(new Employee(123, "Jane Jones", new Division(1, "Catalyst"), new Date()));
        employeeList.addFirst(new Employee(4567, "John Doe", new Division(2, "ATG"), new Date()));
        employeeList.addFirst(new Employee(22, "Mary Smith", new Division(1, "Catalyst"), new Date()));
        employeeList.addFirst(new Employee(3245, "Mike Wilson", new Division(2, "ATG"), new Date()));

//        employeeList.forEach(System.out::println);

        print(employeeList);

        Employee billEnd = new Employee(78, "End Bill", new Division(1, "Catalyst"), new Date());

        // add to the end of the list using add or addLast
//        employeeList.add(billEnd);
        employeeList.addLast(billEnd);
        print(employeeList);

        employeeList.removeFirst();
        print(employeeList);

        employeeList.removeLast();
        print(employeeList);

    }

    public static void print(LinkedList<Employee> employeeList){
        Iterator<Employee> iter = employeeList.iterator();

        System.out.print("HEAD -> ");
        while(iter.hasNext()){
            System.out.print(iter.next());
            System.out.print("<=>");
        }
        System.out.println("null");
    }
}
