package com.mcartagena.datastructure.graphs.socialnetwork;

import java.util.ArrayList;

public class Person {
    private ArrayList<Integer> friends = new ArrayList<>();
    private int personID;
    private String info;

    public Person(int id) {
        this.personID = id;
    }

    public int getID() {
        return personID;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArrayList<Integer> getFriends() {
        return friends;
    }

    public void addFriend(int id) {
        friends.add(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "personID=" + personID +
                ", info='" + info + '\'' +
                '}';
    }
}
