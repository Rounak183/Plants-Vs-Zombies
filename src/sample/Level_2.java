package sample;

public class Level_2 extends Level {
    private final int level=2;
    public Lawn lawn_1,lawn_2,lawn_3;

    public int getLevel(){
        return 2;
    }

    public Level_2()
    {
        this.lawn_1=new Lawn();
        this.lawn_2=new Lawn();
        this.lawn_3=new Lawn();
    }
}
