package com.mcartagena.learnjava.generics_collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestCollections {
    public static void main(String[] args) {
        listExamples();
        setExamples();



    }

    private static void setExamples() {
        Collection<String> set = new HashSet<>();

        set.add("Wand");
        set.add("");

        set.removeIf(String::isEmpty);

        System.out.println(set);
    }

    private static void listExamples() {
        Collection<String> list = new ArrayList<>();

        list.add("Magician");
        list.add("Assistant");

        System.out.println(list);

        list.removeIf(s -> s.startsWith("A"));

        System.out.println(list);
    }
}
