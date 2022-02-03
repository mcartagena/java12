package com.mcartagena.datastructure.liststructure.doublylinkedlist;

import com.mcartagena.model.Employee;

public class NodeEmployee {
    private Employee employee;
    private NodeEmployee next;
    private NodeEmployee previous;

    public NodeEmployee(Employee employee) {
        this.employee = employee;
    }

    public NodeEmployee getNext() {
        return next;
    }

    public Employee getEmployee() {
        return employee;
    }

    public NodeEmployee getPrevious() {
        return previous;
    }

    public void setNext(NodeEmployee next) {
        this.next = next;
    }

    public void setPrevious(NodeEmployee previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return employee.toString();
    }
}
