package com.mcartagena.modernjavainaction.chap09;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.function.Consumer;

public class OnlineBankingLambda {

    public static void main(String[] args) {
        new OnlineBankingLambda().processCustomer(1337, (Customer c) -> System.out.println("Hello!"));
        new OnlineBankingLambda().processCustomer(1338, (Customer c) -> System.out.println("Hello " + c + "!"));
    }

    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }

    // dummy Customer class
    @AllArgsConstructor
    static private class Customer {
        private String firstName;

        @Override
        public String toString(){
            return firstName;
        }
    }

    // dummy Database class
    static private class Database {

        static Customer getCustomerWithId(int id) {
            return new Customer("Marcelo " + id);
        }

    }
}
