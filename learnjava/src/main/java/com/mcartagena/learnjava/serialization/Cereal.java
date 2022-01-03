package com.mcartagena.learnjava.serialization;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
class Food {
    private String category;

    public Food(String category) {
        this.category = category;
    }
}

@Data
class Bowl {
    boolean spoon = true;
}

@Data
public class Cereal extends Food implements Serializable {
    private String name = "CocoaCookies";
    private transient int sugar = 10;
    // private Bowl bowl;  // NotSerializableException

    public Cereal() {
        super("Breakfast");
        this.name = "CaptainPebbles";
        //this.bowl = new Bowl();
        sugar = 2;
    }

    {
        name = "SugarPops";
    }
}
