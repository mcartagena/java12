package com.mcartagena.learnjava.concurrency;

import java.util.List;

public class SearchList<T> {
    private List<T> data;
    private boolean foundMatch = false;

    public SearchList(List<T> list) {
        this.data = list;
    }

    public void exists(T v, int start, int end) {
        if (end - start == 0) {
        } else if (end - start == 1) {
            foundMatch = foundMatch || v.equals(data.get(start));
        } else {
            final int middle = start + (end - start) / 2;
            new Thread(() -> exists(v, start, middle)).run();
            new Thread(() -> exists(v, middle, end)).run();
        }
    }

    public static void main(String[] a) throws Exception {
        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
        SearchList<Integer> t = new SearchList<Integer>(data);
        t.exists(5, 0, data.size());
        System.out.print(t.foundMatch);
    }

}
