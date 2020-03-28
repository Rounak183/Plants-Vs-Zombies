package sample;

import java.io.Serializable;

public abstract class Character implements Serializable {

    private String name;
    public String getName(){
        return this.name;
    }
}
