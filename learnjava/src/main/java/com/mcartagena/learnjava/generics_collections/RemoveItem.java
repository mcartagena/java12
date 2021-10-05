package com.mcartagena.learnjava.generics_collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RemoveItem {
    public static void main(String[] args) {
        List<?> q = List.of("mouse", "parrot");
        var v = List.of("mouse", "parrot");
//        Doesn't compile
//        q.removeIf(String::isEmpty);
//        q.removeIf(s -> s.length() == 4);

        // Throw an exception at runtime UnsupportedOperationException
        // due that it is an inmutable list
//        v.removeIf(String::isEmpty);
//        v.removeIf(s -> s.length() == 4);

        var greetings = new LinkedList<String>();
        greetings.offer("hello");
        greetings.offer("hi");
        greetings.offer("ola");
        greetings.pop();
        greetings.peek();

        while (greetings.peek() != null)
            System.out.print(greetings.pop());

        var numbers = new HashSet<Number>();
        numbers.add(Integer.valueOf(86));
        numbers.add(75);
        numbers.add(Integer.valueOf(86));
        numbers.add(null);
        numbers.add(309L);
        Iterator iter = numbers.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());


    }
}
