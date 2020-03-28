package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_LevelMenu implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Button Level1_Button;


    @FXML
    private Button Level2_Button;

    @FXML
    private Button Level3_Button;

    @FXML
    private Button Level4_Button;

    @FXML
    private Button Level5_Button;

    @FXML
    private Button GoBack_Button;

    Stage stage;

    public void Switch_To_Load(ActionEvent event) throws IOException {

        Stage stage = (Stage) GoBack_Button.getScene().getWindow();
        stage.close();

        Parent pane= FXMLLoader.load(getClass().getResource("LoadGame_Screen.fxml"));
        stage=new Stage();
        stage.setTitle("Plants Vs. Zombies");
        stage.setScene(new Scene(pane, 850, 575));
        stage.show();
    }

    public void Switch_To_Level1(ActionEvent event) throws IOException {
        Stage stage = (Stage) GoBack_Button.getScene().getWindow();
        stage.close();

        Parent pane= FXMLLoader.load(getClass().getResource("Level1_Screen.fxml"));
        stage=new Stage();
        stage.setTitle("Plants Vs. Zombies");
        stage.setScene(new Scene(pane, 850, 575));
        stage.show();
    }

    public void Switch_To_Level2(ActionEvent event) throws IOException {

        Stage stage = (Stage) GoBack_Button.getScene().getWindow();
        stage.close();
        Parent pane= FXMLLoader.load(getClass().getResource("Level2_Screen.fxml"));
        stage=new Stage();
        stage.setTitle("Plants Vs. Zombies");
        stage.setScene(new Scene(pane, 896, 500));
        stage.show();
    }

    public void Switch_To_Level3(ActionEvent event) throws IOException{
        Stage stage = (Stage) GoBack_Button.getScene().getWindow();
        stage.close();
        Parent pane= FXMLLoader.load(getClass().getResource("Level3_Screen.fxml"));
        stage=new Stage();
        stage.setTitle("Plants Vs. Zombies");
        stage.setScene(new Scene(pane, 896, 500));
        stage.show();
    }
    public void Switch_To_OtherLevels(ActionEvent event) throws IOException {
        Stage stage = (Stage) GoBack_Button.getScene().getWindow();
        stage.close();

        Parent pane= FXMLLoader.load(getClass().getResource("OtherLevels_Screen.fxml"));
        stage=new Stage();
        stage.setTitle("Plants Vs. Zombies");
        stage.setScene(new Scene(pane, 850, 575));
        stage.show();
    }
}
