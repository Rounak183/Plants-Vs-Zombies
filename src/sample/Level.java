package sample;

import java.io.Serializable;

public abstract class Level implements Serializable {
    private int level;
    public Lawn lawn_1;
    public Lawn lawn_2;
    public Lawn lawn_3;
    public Lawn lawn_4;
    public Lawn lawn_5;

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level=level;
    }
}
