package sample;

public class Level_3 extends Level {
    private final int level=3;
    public Lawn lawn_1,lawn_2,lawn_3,lawn_4,lawn_5;

    public int getLevel()
    {
        return 3;
    }

    public Level_3()
    {
        this.lawn_1=new Lawn();
        this.lawn_2=new Lawn();
        this.lawn_3=new Lawn();
        this.lawn_4=new Lawn();
        this.lawn_5=new Lawn();
    }
}
