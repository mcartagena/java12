package com.mcartagena.learnjava.ch03_fundamentals;

public interface Planet {
    int circumference = 0;
    public abstract void enterAtmosphere();
    public default int getCircumference() {
        enterAtmosphere();
        return circumference;
    }
    private static void leaveOrbit() {
        var earth = new Planet() {
            public void enterAtmosphere() {}
        };
        earth.getCircumference();
    }
}
