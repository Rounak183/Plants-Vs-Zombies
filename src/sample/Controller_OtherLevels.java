package sample;

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

public class Controller_OtherLevels implements Initializable {

    @FXML
    private Button Pause_Button;

    Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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
}
