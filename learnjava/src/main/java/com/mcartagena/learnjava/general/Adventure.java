package com.mcartagena.learnjava.general;

class Story {
    void recite(int chapter) throws Exception {}
}
public class Adventure extends Story {
    final void recite(final int chapter) {  // g1
        switch(chapter) {                    // g2
            case 2: System.out.print(9);
            default: System.out.print(3);
        }
    }
    public static void main(String... u) {
        var bedtime = new Adventure();
        bedtime.recite(2);
    }
}
