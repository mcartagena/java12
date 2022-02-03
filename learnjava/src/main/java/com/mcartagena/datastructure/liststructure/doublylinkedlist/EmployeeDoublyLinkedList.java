package com.mcartagena.datastructure.liststructure.doublylinkedlist;

import com.mcartagena.model.Division;
import com.mcartagena.model.Employee;

import java.util.Date;

public class EmployeeDoublyLinkedList {
    private NodeEmployee heap;
    private NodeEmployee tail;
    private int size;

    public NodeEmployee addOnFrontOf(Employee employee) {
        NodeEmployee node = new NodeEmployee(employee);

        if (heap == null) {
            tail = node;
        } else {
            heap.setPrevious(node);
            node.setNext(heap);
        }

        heap = node;
        size++;
        return heap;
    }
    public NodeEmployee addToEnd(Employee employee) {
        NodeEmployee node = new NodeEmployee(employee);

        if (tail == null) {
            heap = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        size++;
        return tail;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return heap == null;
    }

    public NodeEmployee removeHeapNode() {
        if(isEmpty())
            return null;

        NodeEmployee node = heap;

        if(heap.getNext()==null){
            tail = null;
        } else {
            heap.getNext().setPrevious(null);
        }

        heap = node.getNext();
        node.setNext(null);
        size--;
        return node;
    }

    public NodeEmployee removeTailNode() {
        if(isEmpty())
            return null;

        NodeEmployee node = tail;

        if(tail.getPrevious()==null){
            heap = null;
        } else {
            tail.getPrevious().setNext(null);
        }

        tail = node.getPrevious();
        node.setPrevious(null);
        size--;
        return node;
    }

    public void print() {
        NodeEmployee current = heap;
        System.out.print("HEAD->");
        while (current != null) {
            System.out.print(current);
            System.out.print("<=>");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Employee jane = new Employee(123, "Jane Jones", new Division(1, "Catalyst"), new Date());
        Employee john = new Employee(4567, "John Doe", new Division(2, "ATG"), new Date());
        Employee mary = new Employee(22, "Mary Smith", new Division(1, "Catalyst"), new Date());
        Employee mike = new Employee(3245, "Mike Wilson", new Division(2, "ATG"), new Date());

        var employeeDoublyLinkedList = new EmployeeDoublyLinkedList();

        employeeDoublyLinkedList.addOnFrontOf(jane);
        employeeDoublyLinkedList.addOnFrontOf(john);
        employeeDoublyLinkedList.addOnFrontOf(mary);
        employeeDoublyLinkedList.addOnFrontOf(mike);

        employeeDoublyLinkedList.print();
        System.out.println(employeeDoublyLinkedList.getSize());

        Employee billEnd = new Employee(78, "End Bill", new Division(1, "Catalyst"), new Date());
        employeeDoublyLinkedList.addToEnd(billEnd);
        employeeDoublyLinkedList.print();
        System.out.println(employeeDoublyLinkedList.getSize());

        employeeDoublyLinkedList.removeHeapNode();
        employeeDoublyLinkedList.print();
        System.out.println(employeeDoublyLinkedList.getSize());

        employeeDoublyLinkedList.removeTailNode();
        employeeDoublyLinkedList.print();
        System.out.println(employeeDoublyLinkedList.getSize());

    }
}
