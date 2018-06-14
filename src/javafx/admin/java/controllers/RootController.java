package javafx.admin.java.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.*;

public class RootController implements Initializable {

    @FXML
    public Label ueberschrift;
    @FXML
    public AnchorPane main_pane;


    private List<String> moduleList;
    private Map<String, Node> moduleMap;
    private List<AnchorPane> allAnchorPanes;
    private List<Tab> allTabs;
    private int TAB_COUNT = 4;


    public RootController() {
        moduleList = new ArrayList<>();
        moduleMap = new HashMap<>();
        allAnchorPanes = new ArrayList<>();
        allTabs = new ArrayList<>();
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

    }

    public void addModule(String name, Node content) {
        moduleList.add(name);
        moduleMap.put(name, content);
    }


    public void changeContent(Event event) {
        MenuItem item = (MenuItem) event.getSource();

        String action;
        String category = "";
        String ueberschriftKategorie = "";
        String ueberschriftAktion = "";

        Menu menu = item.getParentMenu();

        //Für feststellen aus welchem Menü man kommt und den Filename weiterzugeben
        switch (menu.getText()) {
            case "QRCode":
                category = "QRCode";
                ueberschriftKategorie = "einen QRCode";
                break;
            case "Kletterwand":
                category = "Kletterwand";
                ueberschriftKategorie = "eine Kletterwand";
                break;
            case "Frage":
                category = "Question";
                ueberschriftKategorie = "eine Frage";
                break;
            case "Nutzer":
                category = "User";
                ueberschriftKategorie = "die Nutzer";
                break;
        }

        if (item.getText().contains("Erstellen")) {
            action = "create";
            ueberschriftAktion = "Erstelle ";
        } else if (item.getText().contains("Bearbeiten")) {
            action = "edit";
            ueberschriftAktion = "Bearbeite ";
        } else {
            action = "manage";
            ueberschriftAktion = "Verwalte ";
        }

        if (moduleMap.get(action + category) != null) {
            main_pane.getChildren().clear();
            main_pane.getChildren().add(moduleMap.get(action + category));
            ueberschrift.setText(ueberschriftAktion + ueberschriftKategorie);
            ueberschrift.setTextFill(new Color(0,0,0,1));
        } else {
            item.setDisable(true);
            ueberschrift.setText("Diese Funktion ist leider noch nicht implementiert.");
            ueberschrift.setTextFill(new Color(1, 0, 0, 1));
        }

    }
}
