package com.mcartagena.learnjava.io;

import java.io.Serializable;

class Bird {
    protected transient String name;
    public void setName(String name) { this.name = name; }
    public String getName() { return name; }
    public Bird() {
        this.name = "Matt";
    }
}
public class Eagle extends Bird implements Serializable {
    { this.name = "Olivia"; }
    public Eagle() {
        this.name = "Bridget";
    }
    public static void main(String[] args) {
        var e = new Eagle();
        e.name = "Adeline";
    }
}
