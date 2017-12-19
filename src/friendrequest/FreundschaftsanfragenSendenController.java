package friendrequest;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import org.orm.PersistentException;
import pmt.spielspaß.codegenerierung.*;

public class FreundschaftsanfragenSendenController implements Initializable {

  @FXML Label headline;
  @FXML
  TextField suchfeldAnfragen;
  @FXML
  Button suchenAnfagenKnopf;
  @FXML
  Button ladeMehrNamen;

  @FXML
  AnchorPane spielerPane1;
  @FXML
  AnchorPane spielerPane2;
  @FXML
  AnchorPane spielerPane3;
  @FXML
  AnchorPane spielerPane4;
  @FXML
  AnchorPane spielerPane5;
  @FXML
  AnchorPane spielerPane6;
  @FXML
  AnchorPane spielerPane7;
  @FXML
  AnchorPane spielerPane8;
  @FXML
  AnchorPane spielerPane9;
  @FXML
  AnchorPane spielerPane10;

  ArrayList<String> geladeneNamen = new ArrayList<>();
  ArrayList<AnchorPane> spielerPanes = new ArrayList<>();
  ArrayList<Benutzer> arrayUsers = new ArrayList<>();
  Benutzer jetzigerUser;


  public FreundschaftsanfragenSendenController() {

  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    System.out.println("Initializing Controller");

    // Ziehe Namen aus der DB
    try {
      Benutzer[] nutzers = BenutzerDAO.listBenutzerByQuery("Discriminator = 'user'", null);
      for (int i = 0; i < nutzers.length; i++) {
        if (!(nutzers[i].username.equals("jleppich"))) {
          arrayUsers.add(nutzers[i]);
        } else {
          jetzigerUser = nutzers[i];
          String text = headline.getText();
          headline.setText(jetzigerUser.username+": "+text);
        }
      }
    } catch (PersistentException e) {
      e.printStackTrace();
    }

    // Beispielnutzer wird ausgewählt, wird normalerweise von der App gesetzt

    for (int i = 0; i < arrayUsers.size(); i++) {
      String name = arrayUsers.get(i).username;
      geladeneNamen.add(name);
    }

    // Adde SpielerPanes zu Arraylist
    spielerPanes.add(spielerPane1);
    spielerPanes.add(spielerPane2);
    spielerPanes.add(spielerPane3);
    spielerPanes.add(spielerPane4);
    spielerPanes.add(spielerPane5);
    spielerPanes.add(spielerPane6);
    spielerPanes.add(spielerPane7);
    spielerPanes.add(spielerPane8);
    spielerPanes.add(spielerPane9);
    spielerPanes.add(spielerPane10);

    zeigeNamen(geladeneNamen);

  }

  public void zeigeNamen(ArrayList<String> list) {
    System.out.println("Loading 'zeigeNamen'");
    if (list.size() < 10) { //Weniger als 10 User ausgegeben
      for (int i = 0; i < spielerPanes.size(); i++) {
        if (i >= list.size()) {
          spielerPanes.get(i).setVisible(false);
          ladeMehrNamen.setVisible(false);
        } else {
          AnchorPane pane = spielerPanes.get(i);
          List<Node> kids = pane.getChildren();
          Label spielerName = new Label();

          for (int j = 0; j < kids.size(); j++) {
            if (kids.get(j).getClass().equals(Label.class)) {
              spielerName = (Label) kids.get(j);
            }
          }

          spielerName.setText(list.get(i));
        }
      }
    } else if (list.size() == 10) { //genau 10 User ausgegeben

    } else { //Mehr als 10 User ausgeben

    }
  }

  public void sucheNachNamen(ActionEvent event) {

    System.out.println("Loading 'sucheNachNamen'");

    if (suchfeldAnfragen.getText().equals("Suchen...") || suchfeldAnfragen.getText().equals(null)) {

    } else {
      String searchedObject = suchfeldAnfragen.getText();
      ArrayList<String> gesuchteNamen = search(geladeneNamen, searchedObject);
      zeigeNamen(gesuchteNamen);
    }

  }

  public void freundschaftsanfragenSenden(ActionEvent event) {
    Button source = (Button) event.getSource();
    AnchorPane pane = (AnchorPane) source.getParent();
    Label spielerName = new Label();
    for (int i = 0; i < spielerPanes.size(); i++) {
      if (spielerPanes.get(i).equals(pane)) {
        List<Node> kids = pane.getChildren();
        if (kids.get(0).equals(source)) {
          spielerName = (Label) kids.get(1);
        } else {
          spielerName = (Label) kids.get(0);
        }
      }
    }
    BugaBesucher wantedUser = new BugaBesucher();
    for (int i = 0; i < arrayUsers.size(); i++) {
      if (arrayUsers.get(i).username.equals(spielerName.getText())) {
        wantedUser = (BugaBesucher) arrayUsers.get(i);
        break;
      }
    }
    wantedUser.offeneAnfragen.add((BugaBesucher) jetzigerUser);
    System.out.println("Sent friend request to " + spielerName.getText());

    source.setText("Anfrage gesendet");
    source.setDisable(true);

    try {
      BugaBesucherDAO.save(wantedUser);
    } catch (PersistentException e) {
      e.printStackTrace();
    }

  }

  public static ArrayList<String> search(ArrayList<String> list, String name) {
    ArrayList<String> foundStrings = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      String searchedObject = list.get(i);
      if (searchedObject.contains(name)) {
        foundStrings.add(searchedObject);
      }
    }
    return foundStrings;
  }


}
