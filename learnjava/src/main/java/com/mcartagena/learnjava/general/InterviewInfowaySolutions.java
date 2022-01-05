package com.mcartagena.learnjava.general;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewInfowaySolutions {
    public static void main(String[] args) {
        List join1 = List.of(1, 2, 3);
        List join2 = List.of(4, 5, 6);

        // my answer
        System.out.println(joiningList(join1, join2));

        // I believe the correct answer
        System.out.println(List.of(join1, join2)
                .stream()
                //.flatMap(e -> e.stream())
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));

    }

    public static List<Integer> joiningList(List<Integer> list1, List<Integer> list2) {

        List result = new ArrayList<Integer>();

        list1.forEach(e -> result.add(e));
        list2.forEach(e -> result.add(e));

        return result;
    }
}
