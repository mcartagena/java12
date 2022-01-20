package com.mcartagena.datastructure.liststructure;

import com.mcartagena.model.Employee;

public class NodeEmployee {
    private Employee employee;
    private NodeEmployee next;

    public NodeEmployee(Employee employee) {
        this.employee = employee;
    }

    public NodeEmployee getNext() {
        return next;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setNext(NodeEmployee next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return employee.toString();
    }
}
