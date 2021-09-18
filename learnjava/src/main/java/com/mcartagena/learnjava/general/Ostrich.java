package com.mcartagena.learnjava.general;

public class Ostrich {
    private static int count;
    private interface Wild{}
    static class OstrichWrangler implements Wild{
        public int stampede(){
            return count;
        }
    }
}
