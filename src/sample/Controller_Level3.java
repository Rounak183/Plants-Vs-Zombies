package sample;

import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.sound.midi.Soundbank;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


public class Controller_Level3 implements Initializable {
    ImageView SunImg;
    Peashooter peashooter_plant;
    BasicZombie Basic_Zombie= new BasicZombie();
    BasicZombie Second_Zombie=new BasicZombie();
    ImageView Pea;
    int suncount=150;
    double PeaX;
    double ZombieX;
    double ZombieX_2;
    int Sun_Count=150;
    double first_y=205;
    double second_y=124;
    double y_min1;
    double y_min2;
    double y_max1;
    double y_max2;
    double T=0;
    boolean placed_once=false;
    boolean hit_status=false;
    boolean hit_status_2=false;

    public void startTimer_sun(ImageView Iv,double t) {Timer SunTimer= new Timer();
        TimerTask SunTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        checkTime(Iv,t);
                        //System.out.println(T);

                    }
                });
            }
        };
        long frameTimeInMilliseconds = (long) (1);
        SunTimer.schedule(SunTask, 0, frameTimeInMilliseconds);
    }

    public void checkTime(ImageView Iv,double t){
        T=T +0.01;
        if(T>=100){
            Iv.setVisible(true);
        }

        SunImg.setOnMouseClicked(event -> {
            SunImg.setVisible(false);
            T = 0;
            int s=Main.player.Player_Game.getSunCount();
            suncount=suncount+25;
            Main.player.Player_Game.setSunCount(Sun_Count);
            SunCounter.setText(Integer.toString(suncount));
        } );


    }




    public void startTimer(ImageView Iv, double i_x,double s,double y_min,double y_max) {

        Timer timer = new Timer();
        //System.out.println("s = "+s);
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {

                        int a=updateAnimation(Iv,i_x,s,y_min,y_max);
                        if(a==1){
                            Main.player.Player_Game.setSunCount(50);
                            //timer.cancel();
                            try {
                                ChangeLevel(stage);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        };
        long frameTimeInMilliseconds = (long) (1);
        timer.schedule(timerTask, 0, frameTimeInMilliseconds);
    }

    public int updateAnimation(ImageView Iv, double i_x, double s,double y_min,double y_max) {

        double x = Iv.getX();
        x = x + s;
        if (x > 1000) {
            x = i_x;
            hit_status = false;
            hit_status_2 = false;
            Pea.setVisible(true);
        }
        Iv.setX(x);
        if (s == 0.4f) {
            //System.out.println("Plant ");
            PeaX = x;
        }

        if (s == -0.02f) {
            //System.out.println("Zombie_2");
            ZombieX_2 = x;
        }
        if (s == -0.03f) {
            //System.out.println("Zombie");
            ZombieX = x;
        }

        System.out.println("y_min1 = " + y_min1);
        System.out.println("y_max1 = " + y_max1);
        System.out.println("y_min2 = " + y_min2);
        System.out.println("y_max2 = " + y_max2);
        System.out.println("first_y = " + first_y);
        System.out.println("second_y = " + second_y);
        if (-ZombieX >= 1100 - PeaX && hit_status == false && ((y_min1 <= first_y) && (first_y <= y_max1))) {
            System.out.println("Andar aa gaya pehle waale ke liye");
            hit_status = true;
            Pea.setVisible(false);
            System.out.println("Zombie Hit!");
            Basic_Zombie.reduceHealth(peashooter_plant.getAttack());
            if (Basic_Zombie.status == false) {
                zombie.setVisible(false);
                zombie2.setVisible(false);
                return 1;
            }
        }

        if (-ZombieX_2 >=1010 - PeaX && hit_status_2 == false && ((y_min2 <= second_y && second_y <= y_max2))) {
            System.out.println("Second ke liye andar");
            hit_status_2 = true;
            Pea.setVisible(false);
            System.out.println("Zombie_2 Hit!");
            Second_Zombie.reduceHealth(peashooter_plant.getAttack());
            if (Second_Zombie.status == false) {
                System.out.println("change");
                zombie2.setVisible(false);
            }
        }
        if (Basic_Zombie.status == false && Second_Zombie.status==false) {
            System.out.println("Return ke liye");
            return 1;
        }
        return 0;
    }

    @FXML
    private Button Pause_Button;
    @FXML
    private AnchorPane Screen;
    @FXML
    private Text SunCounter;

    @FXML
    private ImageView Sun_6;

    @FXML
    private ImageView Sun_2;

    @FXML
    private ImageView Sun_1;

    @FXML
    private ImageView zombie;

    @FXML
    private ImageView zombie2;

    Zombie zombieObj=new BasicZombie();
    @FXML
    private Button Exit;

    @FXML
    void Switch_To_Level(ActionEvent event) {

    }



    Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Line line_1 = new Line();
        line_1.setStartX(0);
        line_1.setStartY(0);
        line_1.setEndX(0);
        line_1.setEndY(500);
        PathTransition transition_1 = new PathTransition();
        transition_1.setNode(Sun_1);
        transition_1.setDuration(Duration.seconds(20));
        transition_1.setPath(line_1);
        transition_1.setCycleCount(1);
        transition_1.play();
        Line line_2 = new Line();
        line_2.setStartX(0);
        line_2.setStartY(0);
        line_2.setEndX(0);
        line_2.setEndY(630);
        PathTransition transition_2 = new PathTransition();
        transition_2.setNode(Sun_2);
        transition_2.setDuration(Duration.seconds(10));
        transition_2.setPath(line_2);
        transition_2.setCycleCount(1);
        transition_2.play();
        Line line_6 = new Line();
        line_6.setStartX(0);
        line_6.setStartY(0);
        line_6.setEndX(0);
        line_6.setEndY(580);
        PathTransition transition_6 = new PathTransition();
        transition_6.setNode(Sun_6);
        transition_6.setDuration(Duration.seconds(10));
        transition_6.setPath(line_1);
        transition_6.setCycleCount(1);
        transition_6.play();
        double s2 = -0.03f;
        double s3= -0.02f;
        Image pea= null;
        try {
            pea = new Image(new FileInputStream("./src/PvZ_img/pea.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Pea= new ImageView(pea);
        startTimer(zombie2,zombie2.getX(),s3,0,0);
        startTimer(zombie, zombie.getX(), s2,0,0);
    }


    @FXML
    void Switch_to_Sunflower(MouseEvent event) throws FileNotFoundException, InterruptedException {
        int s = Main.player.Player_Game.getSunCount();
        System.out.println(s);
        if (suncount >= 50) {
            Image Plant_image = new Image(new FileInputStream("./src/PvZ_img/sunflower.gif"));
            Image sun_image = new Image(new FileInputStream("./src/PvZ_img/sun.png"));
            ImageView SunPlant = new ImageView(Plant_image);
            SunImg = new ImageView(sun_image);
            SunPlant.setX(event.getX() + 100);
            SunPlant.setY(event.getY());
            SunImg.setX(SunPlant.getX());
            SunImg.setY(SunPlant.getY());
            SunPlant.setFitWidth(72);
            SunPlant.setFitHeight(57);
            SunImg.setFitWidth(49);
            SunImg.setFitHeight(42);
            Screen.getChildren().addAll(SunPlant);
            Screen.getChildren().addAll(SunImg);
            SunImg.setVisible(false);
            double t = 0;
            suncount=suncount-50;
            System.out.println(Sun_Count);
            Main.player.Player_Game.setSunCount(Sun_Count);
            SunCounter.setText(Integer.toString(suncount));
            startTimer_sun(SunImg,t);


        }
    }

    @FXML
    public void Switch_To_PeaShooter_Gif(MouseEvent e) throws IOException, InterruptedException {
        //int s = Main.player.Player_Game.getSunCount();
        int s=Sun_Count;
        if (suncount >= 100) {
            Image image = new Image(new FileInputStream("./src/PvZ_img/peashooter.gif"));
            //Image pea= new Image(new FileInputStream("./src/PvZ_img/pea.png"));
            ImageView P = new ImageView(image);
            //Pea= new ImageView(pea);
            P.setX(e.getX()+90);
            P.setY(e.getY());
            double X_for_Pea = P.getX();
            double Y_for_Pea = P.getY();
            Pea.setX(X_for_Pea);
            Pea.setY(Y_for_Pea);
            P.setFitHeight(57);
            P.setFitWidth(83);
            Pea.setFitWidth(64);
            Pea.setFitHeight(26);
            P.setPreserveRatio(true);
            Pea.setPreserveRatio(true);
            Screen.getChildren().addAll(P);
            Screen.getChildren().addAll(Pea);
            suncount=suncount-100;
            Main.player.Player_Game.setSunCount(Sun_Count);
            SunCounter.setText(Integer.toString(suncount));
            double i_x= Pea.getX();
            double s1=0.4f;
            System.out.println("placed once = "+placed_once);
            if (y_max1==0.0)
            {
                y_min1=e.getY()-100;
                y_max1=e.getY()+100;
                placed_once=true;
            }
            else
            {
                System.out.println("y_");
                y_min2=e.getY()-100;
                y_max2=e.getY()+100;
            }
            //System.out.println(e.getY()+15);
            startTimer(Pea,i_x,s1,e.getY()-100,e.getY()+100);
            peashooter_plant= new Peashooter();
            //Main.player.Player_Game.level.lawn_1.addPlant(peashooter_plant);


        } else {

        }
    }

    public void ChangeLevel(Stage primaryStage) throws IOException{

        Main.player.Player_Game.setLevel(2);
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
        Parent root= FXMLLoader.load(getClass().getResource("ChooseLevel_Screen.fxml"));
        primaryStage=new Stage();
        primaryStage.setTitle("Plants Vs. Zombies");
        primaryStage.setScene(new Scene(root, 850, 575));
        primaryStage.show();
    }

    public void Switch_To_Level(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) Pause_Button.getScene().getWindow();
        stage.close();


        Parent pane= FXMLLoader.load(getClass().getResource("ChooseLevel_Screen.fxml"));
        stage=new Stage();
        stage.setTitle("Plants Vs. Zombies");
        stage.setScene(new Scene(pane, 850, 575));
        stage.show();
    }

    //    public void ChangeLevel(Stage primaryStage) throws IOException{
//
//        Main.player.Player_Game.setLevel(2);
//        Parent root= FXMLLoader.load(getClass().getResource("ChooseLevel_Screen.fxml"));
//        primaryStage=new Stage();
//        primaryStage.setTitle("Plants Vs. Zombies");
//        primaryStage.setScene(new Scene(root, 850, 575));
//        primaryStage.show();
//    }
//
    public int countSun() throws NullPointerException{
        int s=Main.player.Player_Game.getSunCount();
        s=s+50;
        Main.player.Player_Game.setSunCount(s);
        return  s;
    }

    @FXML
    public void collect_1(MouseEvent event) throws IOException
    {
        //System.out.println("Andar hai 1");
        //int w=Main.player.Player_Game.getSunCount();
        //System.out.println("w = "+w);
        Sun_1.setVisible(false);
        Sun_1.setDisable(true);
        suncount=suncount+50;
        //int s=Sun_Count+50;
        SunCounter.setText(Integer.toString(suncount));
    }

    @FXML
    public void collect_2(MouseEvent event) throws  IOException
    {
        //System.out.println("Andar hai 2");
        //int w=Main.player.Player_Game.getSunCount();
        //System.out.println("w = "+w);
        Sun_2.setVisible(false);
        Sun_2.setDisable(true);
        suncount=suncount+50;
        //int s=Sun_Count+50;

        SunCounter.setText(Integer.toString(suncount));
    }

    @FXML
    public void collect_6(MouseEvent event) throws  IOException
    {
        System.out.println("Andar hai");
        //int w=Main.player.Player_Game.getSunCount();
        //System.out.println("w = "+w);
        Sun_6.setVisible(false);
        Sun_6.setDisable(true);
        suncount=suncount+50;
        //int s=Sun_Count+50;
        SunCounter.setText(Integer.toString(suncount));
    }
}
