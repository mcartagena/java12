package com.mcartagena.learnjava.general;

public class Jump {
    private int rope = 1;
    protected boolean outside;

    public Jump() {
        // line p1
        this(4);
        outside = true;
    }

    public Jump(int rope) {
        this.rope = outside ? rope : rope + 1;
    }

    public static void main(String[] bounce) {
        System.out.print(new Jump().rope);
    }
}

