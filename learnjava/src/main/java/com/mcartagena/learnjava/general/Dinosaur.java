package com.mcartagena.learnjava.general;

public class Dinosaur {
    class Pterodactyl extends Dinosaur {
    }

    public void roar() {
        var dino = new Dinosaur();
        dino.new Pterodactyl();
        new Dinosaur.Pterodactyl();
        new com.mcartagena.learnjava.general.Dinosaur.Pterodactyl();
        new Dinosaur.Pterodactyl();
    }

}
