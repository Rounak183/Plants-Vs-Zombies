package sample;

public class BasicZombie extends Zombie implements Cloneable {
    private final int attack=20;
    private int health=100;
    public BasicZombie(){
        status=true;
    }

    public void reduceHealth(int damage)
    {
        this.health-=damage;
        if (this.health<=0)
        {
            status=false;
        }
    }

    public BasicZombie Clone()
    {
        try
        {
            BasicZombie zombie=(BasicZombie)super.clone();
            return zombie;
        }
        catch(CloneNotSupportedException e)
        {
            return null;
        }
    }


    public void attack(Plant plant)
    {
        plant.setHealth(plant.getHealth()-this.attack);
    }

}
