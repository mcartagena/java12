package com.mcartagena.datastructure.liststructure;

import com.mcartagena.model.Division;
import com.mcartagena.model.Employee;

import java.util.Date;

public class EmployeeLinkedList {
    private NodeEmployee heap;
    private int size;

    public NodeEmployee addOnFrontOf(Employee employee) {
        NodeEmployee node = new NodeEmployee(employee);
        node.setNext(heap);
        heap = node;
        size++;
        return heap;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return heap == null;
    }

    public NodeEmployee removeHeapNode() {
        NodeEmployee node = heap;
        heap = node.getNext();
        node.setNext(null);
        size--;
        return node;
    }

    public void print() {
        NodeEmployee current = heap;
        System.out.print("HEAD->");
        while (current != null) {
            System.out.print(current);
            System.out.print("->");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Employee jane = new Employee(123, "Jane Jones", new Division(1, "Catalyst"), new Date());
        Employee john = new Employee(4567, "John Doe", new Division(2, "ATG"), new Date());
        Employee mary = new Employee(22, "Mary Smith", new Division(1, "Catalyst"), new Date());
        Employee mike = new Employee(3245, "Mike Wilson", new Division(2, "ATG"), new Date());

        EmployeeLinkedList employeeLinkedList = new EmployeeLinkedList();

        employeeLinkedList.addOnFrontOf(jane);
        employeeLinkedList.addOnFrontOf(john);
        employeeLinkedList.addOnFrontOf(mary);
        employeeLinkedList.addOnFrontOf(mike);

        employeeLinkedList.print();


        while (!employeeLinkedList.isEmpty()) {
            System.out.println("LinkedList of " + employeeLinkedList.getSize());
            System.out.println("Removing the heap...");
            employeeLinkedList.removeHeapNode();
            employeeLinkedList.print();
        }

    }
}
