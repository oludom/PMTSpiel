package javafx.admin;/**
 * @author Micha Heiß
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class createQRCode extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    Parent root = null;
    try {
      root = FXMLLoader.load(getClass().getResource("resources/createQRCode.fxml"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    primaryStage.setTitle("Administration");
    primaryStage.setScene(new Scene(root, 600, 520));
    primaryStage.show();

  }

}
