package sample;

public abstract class Plant extends Character implements Cloneable {
    private int Xpos;
    private int Ypos;
    private int health;
    private int cost;
    private int waitTime;
    public int status;

    public void setXpos(int x){
        Xpos=x;
    }
    public void setYpos(int y){
        Ypos= y;
    }
    public void setHealth(int h){
        health=h;
    }
    public void setCost(int c){
        cost=c;
    }
    public int getXpos(){
        return Xpos;
    }
    public int getYpos(){
        return Ypos;
    }
    public int getHealth(){
        return health;
    }
    public int getCost(){
        return cost;
    }

}
