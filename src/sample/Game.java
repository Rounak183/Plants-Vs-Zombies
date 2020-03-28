package sample;

import java.io.Serializable;

public class Game implements Serializable {
    //public Narrator narrator;
    public Level level;
    private volatile int sunCount;
    public Game(){
        this.level= new Level_1();
        this.sunCount=50;
    }

    public void setLevel(int level)
    {
        if(level==1)
        {
            this.level=new Level_1();
        }
        else if (level==2)
        {
            this.level=new Level_2();
        }
        else if (level==3){
            this.level=new Level_3();
        }
        else if (level==4)
        {
            this.level=new Level_4();
        }
        else
        {
            this.level=new Level_5();
        }
    }

    public Level getLevel()
    {
        return this.level;
    }

    public void setSunCount(int sunCount)
    {
        this.sunCount=sunCount;
    }

    public int getSunCount(){
        return this.sunCount;
    }
}
