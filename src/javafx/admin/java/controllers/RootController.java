package javafx.admin.java.controllers;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.*;

public class RootController implements Initializable {

    @FXML
    public Label Ueberschrift;
    @FXML
    public TabPane main_window;
    @FXML
    public AnchorPane createQRCode;
    @FXML
    public AnchorPane createKletterwand;
    @FXML
    public AnchorPane editKletterwand;


    private List<String> moduleList;
    private Map<String, Node> moduleMap;
    private Node firstModule = null;


    public RootController() {
        moduleList = new ArrayList<>();
        moduleMap = new HashMap<>();
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
//    listView.getSelectionModel().selectedItemProperty().addListener(
//            (ObservableValue<? extends String> observable,
//             String oldValue, String newValue) -> {
//              modulePane.getChildren().clear();
//              modulePane.getChildren().add(moduleMap.get(newValue));
//            }
//    );

    }

    public void addModule(String name, Node content) {
        moduleList.add(name);
        moduleMap.put(name, content);
        if (firstModule == null) {
            firstModule = content;
            //main_window.getSelectionModel().selectFirst();
        }
    }


    public void changeTab(Event event) {
        Tab src = (Tab) event.getSource();
        AnchorPane view = new AnchorPane();
        switch (src.getText()) {
            case "QRCode erstellen":
                createQRCode.getChildren().add(moduleMap.get("createQRCode"));
                break;
            case "Kletterwand erstellen":
                createKletterwand.getChildren().add(moduleMap.get("createKletterwand"));
                break;
            case "Kletterwand bearbeiten":
                editKletterwand.getChildren().add(moduleMap.get("editKletterwand"));
                break;
        }
    }
}
