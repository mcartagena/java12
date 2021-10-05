package com.mcartagena.learnjava.generics_collections;

import java.util.*;

public class TestCollections {
    public static void main(String[] args) {
        listExamples();
        setExamples();

        comparatorExamples();

        mapExcamples();

        mergeExamples();

    }

    private static void mergeExamples() {
        var map = new HashMap<Integer, Integer>();
        map.put(1, 10);
        map.put(2, 20);
        map.put(3, null);

        map.merge(1, 3, (a, b) -> a + b);
        map.merge(3, 3, (a, b) -> a + b);
        System.out.println(map);
    }

    private static void mapExcamples() {
        Map m = new HashMap();
        m.put(123, "456");
        m.put("abc", "def");
        System.out.println(m.entrySet());
        System.out.println(m.containsKey("123"));
    }

    private static void comparatorExamples() {
        Comparator<Integer> c1 = (o1, o2) -> o2 - o1;
        Comparator<Integer> c2 = Comparator.naturalOrder();
        Comparator<Integer> c3 = Comparator.reverseOrder();

        var list = Arrays.asList(5, 4, 7, 2);
        Collections.sort(list, c2);
        System.out.println(list);
        System.out.println(Collections.binarySearch(list, 2));
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

        Queue<Integer> queue = new LinkedList();

        queue.offer(2);
        queue.offer(3);

        queue.remove(1);

        list.add("Magician");
        list.add("Assistant");

        System.out.println(list);

        list.removeIf(s -> s.startsWith("A"));

        System.out.println(list);
    }
}
