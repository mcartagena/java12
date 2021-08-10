package com.mcartagena.learnjava.lambdafunction;

public class CheckIfHopper implements CheckTrail{
    @Override
    public boolean test(Animal animal) {
        return animal.canHop();
    }
}
