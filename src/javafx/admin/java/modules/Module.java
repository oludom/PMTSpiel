package javafx.admin.java.modules;


import javafx.admin.java.controllers.Controller;

public class Module {

  private String name;
  private Controller controller;

  public Module(String name, Controller controller) {
    this.name = name;
    this.controller = controller;
  }
}
