package sample;

public class Level_1 extends Level {
    private final int level = 1;
    public Lawn lawn_1;

    public int getLevel() {
        return 1;
    }

    public Level_1()
    {
        lawn_1=new Lawn();
    }
}
