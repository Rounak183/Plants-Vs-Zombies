package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

import javax.swing.*;

public class Controller implements Initializable{

    @Override
    public void initialize(URL url, ResourceBundle rb){

    }

    @FXML
    private AnchorPane root;

    @FXML
    private Button Start_Button;

    @FXML
    private Button LoadGame_Button;

    @FXML
    private Button Exit;

    Stage stage;
    public void Switch_To_Start(ActionEvent event) throws IOException {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();

        Parent  pane=  FXMLLoader.load(getClass().getResource("Start_Screen.fxml"));
        stage =new Stage();
        stage.setTitle("Plants Vs. Zombies");
        stage.setScene(new Scene(pane, 850, 575));
        stage.show();

    }

    public void Switch_To_Load(ActionEvent event) throws IOException {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();

        Parent pane=FXMLLoader.load(getClass().getResource("LoadGame_Screen.fxml"));
        stage=new Stage();
        stage.setTitle("Plants Vs. Zombies");
        stage.setScene(new Scene(pane, 850, 575));
        stage.show();
    }

    public void Switch_To_Level(ActionEvent event) throws IOException {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();

        Parent pane=FXMLLoader.load(getClass().getResource("ChooseLevel_Screen.fxml"));
        stage=new Stage();
        stage.setTitle("Plants Vs. Zombies");
        stage.setScene(new Scene(pane, 850, 575));
        stage.show();
    }

    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }
}
