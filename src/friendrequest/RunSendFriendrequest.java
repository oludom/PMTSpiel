package friendrequest;

import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.*;

public class RunSendFriendrequest extends Application {

  public void start(Stage primaryStage) {
    try {
      VBox root = (VBox)FXMLLoader.load(getClass().getResource("FreundschaftsanfragenSenden.fxml"));
      Scene scene = new Scene(root,345,480);
      //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
      primaryStage.setTitle("Freundschaftsanfragen senden");
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }

}
