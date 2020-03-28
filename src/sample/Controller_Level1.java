package sample;


import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Controller_Level1 implements Initializable {
    Peashooter peashooter_plant;
    BasicZombie Basic_Zombie= new BasicZombie();
    ImageView Pea;
    double PeaX;
    double ZombieX;
    boolean hit_status=false;
    Stage stage;
    public void startTimer(ImageView Iv, double i_x,double s) {
        Timer timer = new Timer();
        //System.out.println("s = "+s);
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {

                        int a=updateAnimation(Iv,i_x,s);
                        if(a==1){
                            Main.player.Player_Game.setSunCount(50);
                            timer.cancel();
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

    public int updateAnimation(ImageView Iv, double i_x, double s){
        int actual_count=0;
        double x= Iv.getX();
        x=x+s;
        if(x>1000){
            x=i_x;
            hit_status=false;
            Pea.setVisible(true);
        }
        Iv.setX(x);
        if (s==0.4f)
        {
            PeaX=x;
        }

        if (s==-0.05f)
            ZombieX= x;

        if (-ZombieX>=1100-PeaX && hit_status==false){
                //(ZombieX>-200+check_x && ZombieX<200+check_x)
            hit_status=true;
            Pea.setVisible(false);
            System.out.println("Zombie Hit!");
            Basic_Zombie.reduceHealth(peashooter_plant.getAttack());
            if (Basic_Zombie.status==false)
            {
                zombie.setVisible(false);
                return 1;
//                try {
//                    endLevel();
//                }
//                catch (IOException e){
//
//                }

            }
        }
        return 0;
    }

    VBox root=new VBox(10);

    @FXML
    private ImageView PeaShooterCard;

    @FXML
    private Text SunCounter;

    @FXML
    private Button Pause_Button;
    @FXML
    private ImageView zombie;
    @FXML
    private ImageView Sun;

    @FXML
    private ImageView Sun1;

    @FXML
    private ImageView Sun11;

    @FXML
    private ImageView Sun111;
    Zombie zombieObj= new BasicZombie();

    @FXML
    private AnchorPane Screen;
    @FXML
    private Button Exit;


    private boolean First_PeaShooter_Placed=false;

    ArrayList<PathTransition> transition_list=new ArrayList<PathTransition>();

    //Stage stage;

    //private void ChangeLevel() throws IOException {
//        Parent root=FXMLLoader.load(getClass().getResource("Level2_Screen.fxml"));
//
//        Scene scene=new Scene(root);
//        stage.show();
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        root.getChildren().add(Pause_Button);
        //Line line= new Line();
        //line.setStartX(0);
        //line.setStartY(0);
        //line.setEndX(-700);
        //line.setEndY(0);
        //PathTransition transition= new PathTransition();
        //transition.setNode(zombie);
        //transition.setDuration(Duration.seconds(25));
        //transition.setPath(line);
        //transition.setCycleCount(1);
        //transition.play();
        Line line_1 = new Line();
        line_1.setStartX(0);
        line_1.setStartY(0);
        line_1.setEndX(0);
        line_1.setEndY(500);
        PathTransition transition_1 = new PathTransition();
        transition_1.setNode(Sun);
        transition_1.setDuration(Duration.seconds(60));
        transition_1.setPath(line_1);
        transition_1.setCycleCount(1);
        transition_1.play();
        transition_list.add(transition_1);
        Line line_2 = new Line();
        line_2.setStartX(0);
        line_2.setStartY(0);
        line_2.setEndX(0);
        line_2.setEndY(530);
        PathTransition transition_2 = new PathTransition();
        transition_2.setNode(Sun1);
        transition_2.setDuration(Duration.seconds(35));
        transition_2.setPath(line_2);
        transition_2.setCycleCount(1);
        transition_2.play();
        transition_list.add(transition_2);
        Line line_3 = new Line();
        line_3.setStartX(0);
        line_3.setStartY(0);
        line_3.setEndX(0);
        line_3.setEndY(600);
        PathTransition transition_3 = new PathTransition();
        transition_3.setNode(Sun11);
        transition_3.setDuration(Duration.seconds(30));
        transition_3.setPath(line_2);
        transition_3.setCycleCount(1);
        transition_3.play();
        transition_list.add(transition_3);
        Line line_4 = new Line();
        line_4.setStartX(0);
        line_4.setStartY(0);
        line_4.setEndX(0);
        line_4.setEndY(700);
        PathTransition transition_4 = new PathTransition();
        transition_4.setNode(Sun111);
        transition_4.setDuration(Duration.seconds(10));
        transition_4.setPath(line_2);
        transition_4.setCycleCount(1);
        transition_4.play();
        transition_list.add(transition_4);
        double s2 = -0.05f;
        Image pea= null;
        try {
            pea = new Image(new FileInputStream("./src/PvZ_img/pea.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Pea= new ImageView(pea);
        startTimer(zombie, zombie.getX(), s2);
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

    @FXML
    public void Switch_To_PeaShooter_Gif(MouseEvent e) throws IOException, InterruptedException {
        int s = Main.player.Player_Game.getSunCount();
        if (s >= 100) {
            Image image = new Image(new FileInputStream("./src/PvZ_img/peashooter.gif"));
            //Image pea= new Image(new FileInputStream("./src/PvZ_img/pea.png"));
            ImageView P = new ImageView(image);

            P.setX(e.getX());
            P.setY(e.getY());
            double X_for_Pea = P.getX();
            double Y_for_Pea = P.getY();
            Pea.setX(X_for_Pea);
            Pea.setY(Y_for_Pea);
            P.setFitHeight(88);
            P.setFitWidth(72);
            Pea.setFitWidth(64);
            Pea.setFitHeight(26);
            P.setPreserveRatio(true);
            Pea.setPreserveRatio(true);
            Screen.getChildren().addAll(P);
            Screen.getChildren().addAll(Pea);
            s = s - 100;
            Main.player.Player_Game.setSunCount(s);
            SunCounter.setText(Integer.toString(s));
            double i_x= Pea.getX();
            double s1=0.4f;
            startTimer(Pea,i_x,s1);
            peashooter_plant= new Peashooter();
            //Main.player.Player_Game.level.lawn_1.addPlant(peashooter_plant);


        } else {

        }
    }

    public int countSun() throws NullPointerException{
        int s=Main.player.Player_Game.getSunCount();
        s=s+50;
        Main.player.Player_Game.setSunCount(s);
        return  s;
    }

    @FXML
    public void collect(MouseEvent event) throws IOException
    {
        Sun.setVisible(false);
        Sun.setDisable(true);
        int s= countSun();
        SunCounter.setText(Integer.toString(s));
    }
    @FXML
    public void collect1(MouseEvent event) throws IOException{
        Sun1.setVisible(false);
        Sun1.setDisable(true);
        int s= countSun();
        SunCounter.setText(Integer.toString(s));
    }

    @FXML
    public void collect11(MouseEvent event) throws IOException{
        Sun11.setVisible(false);
        Sun11.setDisable(true);
        int s= countSun();
        SunCounter.setText(Integer.toString(s));

    }
    @FXML
    public void collect111(MouseEvent event) throws IOException{
        Sun111.setVisible(false);
        Sun111.setDisable(true);
        int s= countSun();
        SunCounter.setText(Integer.toString(s));
    }

    @FXML
    public void Show_Popup_Window(javafx.event.ActionEvent event) throws IOException {
        Parent pane=FXMLLoader.load(getClass().getResource("Dialog_Box.fxml"));
        stage=new Stage();
        stage.setTitle("Plants Vs. Zombies");
        stage.setScene(new Scene(pane,450,250));
        stage.show();
    }
    
}
