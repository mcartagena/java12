package com.mcartagena.learnjava.exceptions;

public class Storm {
    public static void main(String... rain) throws Exception {
        var weatherTracker = new AutoCloseable() {
            public void close() throws RuntimeException {
                System.out.println("Thunder");
            }
        };
        try (weatherTracker) {
            System.out.println("Tracking");
        } catch (Exception e) {
            System.out.println("Lightning");
        } finally {
            System.out.println("Storm gone");
            weatherTracker.close();  // it's allowed to call the close method because weatherTrakcer is declared outsite of the try
        }
    }
}
