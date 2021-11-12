package com.mcartagena.learnjava.generics_collections;

import java.util.Arrays;
import java.util.HashMap;

interface Comic<C> {
    void draw(C c);
}

class ComicClass<C> implements Comic<C> {
    public void draw(C c) {
        System.out.println(c);
    }
}

class SnoopyClass implements Comic<Snoopy> {
    public void draw(Snoopy c) {
        System.out.println(c);
    }
}

class SnoopyComic implements Comic<Snoopy> {
    public void draw(Snoopy c) {
        System.out.println(c);
    }

}

public class Snoopy {
    public static void main(String[] args) {
        Comic<Snoopy> c1 = c -> System.out.println("Good Snoopy... " + c);
        Comic<Snoopy> c2 = new ComicClass<>();
        Comic<Snoopy> c3 = new SnoopyClass();
        Comic<Snoopy> c4 = new SnoopyComic();

        c1.draw(new Snoopy());

        String[] array = {"Natural History", "Science"};
        var museums = Arrays.asList("Natural History, Science");

        museums.set(0, "Art");
        System.out.println(museums.contains("Art"));
        System.out.println(array);

        var names = new HashMap<String, String>();
        names.put("peter", "pan");
        names.put("wendy", "darling");
        var first = names.entrySet();        // line x1
        first.forEach(System.out::println);  // line x2

    }


}
