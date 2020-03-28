package sample;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.w3c.dom.ls.LSOutput;

public class Controller_game implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb){
        Line line= new Line();
        line.setStartX(23);
        line.setStartY(168);
        line.setEndX(-700);
        line.setEndY(168);
        PathTransition transition= new PathTransition();
        transition.setNode(zombie);
        transition.setDuration(Duration.seconds(25));
        transition.setPath(line);
        transition.setCycleCount(1);

        Line line2= new Line();
        line2.setStartX(0);
        line2.setStartY(10);
        line2.setEndX(700);
        line2.setEndY(10);
        PathTransition transition2= new PathTransition();
        transition2.setNode(Landmower1);
        transition2.setDuration(Duration.seconds(8));
        transition2.setPath(line2);
        transition2.setCycleCount(15);
        Line line3= new Line();
        line3.setStartX(0);
        line3.setStartY(0);
        line3.setEndX(700);
        line3.setEndY(0);
        PathTransition transition3= new PathTransition();
        transition3.setNode(pea);
        transition3.setDuration(Duration.seconds(1));
        transition3.setPath(line3);
        transition3.setCycleCount(Animation.INDEFINITE);
        Line line4= new Line();
        line4.setStartX(0);
        line4.setStartY(0);
        line4.setEndX(0);
        line4.setEndY(500);
        PathTransition transition4= new PathTransition();
        transition4.setNode(sun);
        transition4.setDuration(Duration.seconds(6));
        transition4.setPath(line4);
        transition4.setCycleCount(1);
        transition4.play();
        transition3.play();
        transition2.play();
        transition.play();


    }
    @FXML
    private ImageView Pea_card;

    @FXML
    private ImageView sun;

    @FXML
    private ImageView Sunflower_card;

    @FXML
    private ImageView zombie;
    @FXML
    private Text status;

    @FXML
    private ImageView pea;

    @FXML
    private Button SaveGame_Button;

    @FXML
    private Button ExitGame_Button;


    @FXML
    private ImageView Landmower1;
    public void Move(){

            double x = zombie.getX();
            x = x -10 ;
            zombie.setX(x);
            System.out.println("move" + x);


    }
    ArrayList<Plant> plantArrayList= new ArrayList<Plant>();
    ArrayList<Zombie> zombieArrayList= new ArrayList<Zombie>();
    public void Switch_To_Main(ActionEvent event) throws IOException {
        Stage stage = (Stage) ExitGame_Button.getScene().getWindow();
        stage.close();

        Parent pane=  FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage =new Stage();
        stage.setTitle("Plants Vs. Zombies");
        stage.setScene(new Scene(pane, 850, 575));
        stage.show();
    }

    public void Switch_To_MainSave(ActionEvent event) throws IOException {
        Stage stage = (Stage) SaveGame_Button.getScene().getWindow();
        stage.close();

        Parent pane=  FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage =new Stage();
        stage.setTitle("Plants Vs. Zombies");
        stage.setScene(new Scene(pane, 850, 575));
        stage.show();
    }


    public void display(javafx.scene.input.MouseEvent mouseEvent) {
        status.setText("x: "+ mouseEvent.getX()+ " y: "+mouseEvent.getY());
    }

    public void collect(MouseEvent mouseEvent) {
        sun.setVisible(false);
    }
}