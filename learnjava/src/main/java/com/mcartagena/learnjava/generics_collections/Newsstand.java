package com.mcartagena.learnjava.generics_collections;

import java.util.TreeSet;

class Magazine implements Comparable<Magazine>{
    private String name;
    public Magazine(String name) {
        this.name = name;
    }
    @Override
    public int compareTo(Magazine m) {
        return name.compareTo(m.name);
    }
    public String toString() {
        return name;
    }

}

public class Newsstand {
    public static void main(String[] args) {
        var set = new TreeSet<Magazine>();
        set.add(new Magazine("highlights"));
        set.add(new Magazine("Newsweek"));
        set.add(new Magazine("highlights"));
        System.out.println(set.iterator().next());
    }
}

