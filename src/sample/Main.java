package sample;

import com.sun.webkit.dom.XPathResultImpl;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main extends Application {

    public static void serialize() throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(
                    new FileOutputStream("player1.txt"));

            out.writeObject(player);
            }
        finally {
            out.close();
             }
        }

    public static Player player=null;
    public static Zombie Basic_Zombie= new BasicZombie();
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Plants Vs. Zombies");
        primaryStage.setScene(new Scene(root, 850, 575));
        primaryStage.show();

    }


    public static void main(String[] args) {

        launch(args);
    }
}
