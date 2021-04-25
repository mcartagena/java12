package com.mcartagena.modernjavainaction.chap10;

import com.mcartagena.model.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class SmallDsls {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                Person.builder().age(20).name("Anna").build(),
                Person.builder().age(8).name("Matias").build(),
                Person.builder().age(40).name("Juan").build(),
                Person.builder().age(38).name("Gabriela").build(),
                Person.builder().age(50).name("Sebastian").build()
        );

        // Before lambdas
        // syntactic noise that provides no additional benefit
        System.out.println("Before lambdas");
        Collections.sort(persons, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.getAge() - p2.getAge();
            }
        });

        persons.forEach(System.out::println);

        persons.set(0,Person.builder().age(35).name("Pedro").build());

        // With lambda expresions
        System.out.println("With lambda expresions");
        Collections.sort(persons, (p1, p2) -> p1.getAge() - p2.getAge());

        persons.forEach(System.out::println);

        // Using static utility methods that let you create Comparator
        // objects in a more readable manner

        persons.set(2, Person.builder().age(26).name("Silvia").build());

        System.out.println("Using Comparator static utility methods");

        Collections.sort(persons, comparing(p -> p.getAge()));

        persons.forEach(System.out::println);

        // Even better, you can replace the lambda with a method reference:

        persons.set(4, Person.builder().age(40).name("Cesar").build());

        System.out.println("replacing the lambda with a method reference");

        Collections.sort(persons, comparing(Person::getAge));

        persons.forEach(System.out::println);

        // If you want to sort the people by age, but in reverse order

        System.out.println("reverse order");

        Collections.sort(persons, comparing(Person::getAge).reversed());

        persons.forEach(System.out::println);

        // if you want the people of the same age to be sorted alphabetically

        System.out.println("same age to be sorted alphabetically");

        Collections.sort(persons, comparing(Person::getAge)
                .thenComparing(Person::getName));

        persons.forEach(System.out::println);

        // using the new sort method added on the List interface

        persons.set(1, Person.builder().age(28).name("Cesar").build());

        System.out.println("using the new sort method added on the List interface");

        persons.sort(comparing(Person::getName)
                .thenComparing(Person::getAge));

        persons.forEach(System.out::println);
    }


}
