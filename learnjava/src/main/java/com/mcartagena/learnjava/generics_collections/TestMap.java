package com.mcartagena.learnjava.generics_collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

public class TestMap {
    public static void main(String[] args) {
        mapExample();

        treeMapExample();

        mergeMapExample();

    }

    private static void mergeMapExample() {
        System.out.println("** Merge **");

        BiFunction<String, String, String> mapper = (v1, v2)
                -> v1.length() > v2.length() ? v1 : v2;

        Map<String, String> favorites = new HashMap<>();
        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Tram");

        System.out.println(favorites); // {Tom=Tram, Jenny=Bus Tour}

        String jenny = favorites.merge("Jenny", "Skyride", mapper);

        System.out.println(favorites); // {Tom=Tram, Jenny=Bus Tour}
        System.out.println(jenny);     // Bus Tour

        String tom = favorites.merge("Tom", "Skyride", mapper);

        System.out.println(favorites); // {Tom=Skyride, Jenny=Bus Tour}
        System.out.println(tom);       // Skyride

        favorites.put("Sam", null);
        favorites.merge("Marcelo", "Skyride", mapper);
        favorites.merge("Sam", "Skyride", mapper);
        System.out.println(favorites);   // {Tom=Skyride, Marcelo=Skyride, Jenny=Bus Tour, Sam=Skyride}

        favorites.clear();

        mapper = (v1, v2) -> null;

        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", "Bus Tour");

        favorites.merge("Jenny", "Skyride", mapper);
        favorites.merge("Sam", "Skyride", mapper);

        System.out.println(favorites);   // {Tom=Bus Tour, Sam=Skyride}

    }

    private static void treeMapExample() {

        System.out.println("*** TREEMAP ***");
        Map<String, String> treeMap = new TreeMap<>();

        treeMap.put("koala", "bamboo");
        treeMap.put("lion", "meat");
        treeMap.put("giraffe", "leaf");

        String food2 = treeMap.get("koala");

        System.out.println(food2);

        for (String key : treeMap.keySet())
            System.out.println(key + ",");

        // System.out.println(treeMap.contains("lion")); // DOES NOT COMPILE
        System.out.println(treeMap.containsKey("lion"));
        System.out.println(treeMap.containsValue("lion"));
        System.out.println(treeMap.size());
        treeMap.clear();
        System.out.println(treeMap.size());
        System.out.println(treeMap.isEmpty());
    }

    private static void mapExample() {
        System.out.println("*** MAP ***");

        Map<String, String> map = new HashMap<>();

        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");

        String food = map.get("koala");

        System.out.println(food);

        for (String key : map.keySet())
            System.out.println(key + ",");

        System.out.println("** print values using map.forEach **");
        map.forEach((k, v) -> System.out.println(v));

        System.out.println("** print values using map.values().forEach **");
        map.values().forEach(System.out::println);

        System.out.println("** print values using map.entrySet **");
        map.entrySet().forEach(stringStringEntry ->
                System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue()));

        System.out.println("Bear eat " + map.get("bear"));
        System.out.println("Bear eat " + map.getOrDefault("bear", ""));
        System.out.println("Koala eat " + map.get("koala"));
        System.out.println("Koala eat " + map.getOrDefault("koala", ""));

        System.out.println("replace and replaceAll");

        Map<Integer, Integer> mapInt = new HashMap<>();
        mapInt.put(1, 2);
        mapInt.put(2, 4);

        Integer original = mapInt.replace(2, 10); // 4
        System.out.println("replace original " + original);

        System.out.println(mapInt);

        mapInt.replaceAll(Integer::sum);

        System.out.println(mapInt);

        System.out.println("** putIfAbsent **");

        Map<String, String> favorites = new HashMap<>();

        favorites.put("Jenny", "Bus Tour");
        favorites.put("Tom", null);

        favorites.putIfAbsent("Jenny", "Tram");
        favorites.putIfAbsent("Sam", "Tram");
        favorites.putIfAbsent("Tom", "Tram");

        System.out.println(favorites); // {Tom=Tram, Jenny=Bus Tour, Sam=Tram}

    }
}
