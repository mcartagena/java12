package com.mcartagena.modernjavainaction.chap08;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Map.entry;

public class CreatingCollections {

    public static void main(String[] args) {
        creatingLists();
        creatingSets();
        creatingMaps();
    }

    public static void creatingLists(){
        System.out.println("------------ Creating Lists --------------");

        System.out.println("Creating List the old-fashioned way");
        List<String> friends = new ArrayList<>();
        friends.add("Hernan");
        friends.add("Marcelo");
        friends.add("Paulina");

        System.out.println(friends);

        System.out.println("--> Using Arrays.asList()");

        List<String> friends2 = Arrays.asList("Hernan", "Marcelo");
        friends2.set(0,"Paulina");

        System.out.println(friends2);

        try {
            friends2.add("Paulina");
            System.out.println("We shouldn't get here...");
        } catch (UnsupportedOperationException exception){
            System.out.println("As expected, we can't add items to a list created with Arrays.asList().");
        }

        System.out.println("--> Creating a Set from a List");

        Set<String> friends3 = new HashSet<>(Arrays.asList("Hernan", "Marcelo","Paulina"));
        System.out.println(friends3);

        System.out.println("--> Creating a Set from a Stream");
        Set<String> friends4 = Stream.of("Hernan","Marcelo","Paulina")
                .collect(Collectors.toSet());
        System.out.println(friends4);

        System.out.println("--> Creating a List with List.of()");
        List<String > friends5 = List.of("Hernan","Marcelo","Paulina");
        System.out.println(friends5);

        try{
            friends5.add("Gerardo");
        } catch (UnsupportedOperationException exception){
            System.out.println("As expected, we can't add items to a list created with List.of().");
        }

        try{
            friends5.set(1,"Rocco");
            System.out.println("We shouldn't get here...");
        } catch (UnsupportedOperationException exception){
            System.out.println("Neither can we replace items in such a list.");
        }
    }

    public static void creatingSets(){
        System.out.println("------ Creating Sets ------");

        System.out.println("--> Creating a Set with Set.of()");
        Set<String> friends = Set.of("Hernan","Marcelo","Paulina");

        System.out.println(friends);

        System.out.println("--> Trying to pass duplicate items to Set.of()");
        try {
            Set<String> friends2 = Set.of("Hernan","Marcelo","Marcelo");
            System.out.println("We shouldn't get here...");
        }catch (IllegalArgumentException e){
            System.out.println("As expected, duplicate items are not allowed with Set.of().");
        }
    }

    public static void creatingMaps(){
        System.out.println("--> Creating a Map with Map.of()");
        Map<String,Integer> ageOfFriends = Map.of("Hernan",42,"Marcelo",30,"Paullina", 35);
        System.out.println(ageOfFriends);

        System.out.println("--> Creating a Map with Map.ofEntries()");
        Map<String,Integer> ageOfFriends2 = Map.ofEntries(
                entry("Hernan",42),
                entry("Marcelo",30),
                entry("Paulina",35)
        );
        System.out.println(ageOfFriends2);

    }
}
