package sample;

import java.io.Serializable;

public class Player implements Serializable {
    private String username;
    public Game Player_Game;
    public Player(String s ){
        username= s;
        Player_Game= new Game();
    }
    
    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username=username;
    }
}
