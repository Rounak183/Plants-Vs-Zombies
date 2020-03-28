package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Lawn implements Serializable {
    private ArrayList<Zombie> zombies;
    private ArrayList<Plant> plants;
    private boolean LawnMover;

    public Lawn()
    {
        this.zombies=new ArrayList<Zombie>();
        this.plants=new ArrayList<Plant>();
        this.LawnMover=true;
    }

    public void addPlant(Plant plant){
        plants.add(plant);
    }

    public void removePlant(Plant plant){
        plants.remove(plant);
    }
}
