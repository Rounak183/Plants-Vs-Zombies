package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_LoadGame implements Initializable{

    @Override
    public void initialize(URL url, ResourceBundle rb){

    }
    @FXML
    private TextField Textbox_name;
    @FXML
    private Button Play_Button;

    @FXML
    private Button GoBack_Button;
    @FXML
    private Button Exit;

    Stage stage;

    public void Switch_To_Main(ActionEvent event) throws IOException {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
        Parent  pane=  FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage =new Stage();
        stage.setTitle("Plants Vs. Zombies");
        stage.setScene(new Scene(pane, 850, 575));
        stage.show();
    }

    public void Switch_To_Level(ActionEvent event) throws IOException {
        String name= Textbox_name.getText();
        System.out.println(name);
        Main.player= new Player(name);
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
        Parent  pane=  FXMLLoader.load(getClass().getResource("ChooseLevel_Screen.fxml"));
        stage =new Stage();
        stage.setTitle("Plants Vs. Zombies");
        stage.setScene(new Scene(pane, 850, 575));
        stage.show();
    }

    public void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
    }

}
