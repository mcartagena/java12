package com.mcartagena.learnjava.general;

import com.mcartagena.model.Customer;

public class TestLombok {
    public static void main(String[] args) {

        // create a object customer from scratch
        Customer testCustomer1 = Customer.builder().id(1L).name("Marcelo").build();
        Customer testCustomer2 = new Customer(1L,"Marcelo","password","email@domain.com");
        Customer testCustomer3 = new Customer();

        testCustomer1.setEmail("emailWithSet@domain.com");

        System.out.println("The first customer: " + testCustomer1);
        System.out.println("The first customer name: " + testCustomer1.getName());
        System.out.println("The second customer> " + testCustomer2.toString());
        System.out.println("The objects are equals: " + testCustomer1.equals(testCustomer2));
        System.out.println("The hashCode for two customers: " + testCustomer1.hashCode() + " " + testCustomer2.hashCode());
        System.out.println("Customer with constructor without arguments: " + testCustomer3);

    }
}
