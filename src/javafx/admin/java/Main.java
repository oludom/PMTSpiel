package javafx.admin.java;

import javafx.admin.java.controllers.RootController;
import javafx.admin.java.modules.Module;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

  private RootController controller;

  private final int width = 1280;

  private final int height = 720;

  private Map<String, Module> modules = new HashMap<>();


  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/Root.fxml"));

    final Parent root = loader.load();
    controller = loader.getController();

    primaryStage.setTitle("Administration");
    Scene scene = new Scene(root, width, height);
    primaryStage.setMinWidth(width);
    primaryStage.setMinHeight(height);
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();

    addModule("createQRCode");
    addModule("editQRCode");
    addModule("createKletterwand");
    addModule("editKletterwand");
    addModule("createQuestion");
    addModule("editQuestion");
    addModule("manageUsers");

  }

  private void addModule(String name) {
    try {
      URL url = getClass().getResource("resources/" + name + ".fxml");
      if (url == null) {
        System.out.println("addModule: Fxml File for Module: \"" + name + "\" not found!");
      } else {
        System.out.println("addModule: Loading Module: \"" + name + "\"!");
        Node content = FXMLLoader.load(url);
        controller.addModule(name, content);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * the main method.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {

    System.out.println("java version: "+System.getProperty("java.version"));
    launch(args);
  }

  @Override
  public void stop() {
  }
}