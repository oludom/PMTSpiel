package javafx;

import static pmt.spielspaß.codegenerierung.BenutzerDAO.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import org.orm.PersistentException;
import pmt.spielspaß.codegenerierung.*;

public class QRCodeQuizFragenController implements Initializable {

  @FXML
  Button ans1;

  @FXML
  Button ans2;

  @FXML
  Button ans3;

  @FXML
  Label qrcodelabel;

  @FXML
  TextArea question;

  @FXML
  TextArea hint;

  @FXML
  Label hintlabel;

  @FXML
  Label answerlabel;

  QRCode qrCode;

  Frage frage;

  String RichtigeAntwort;

  ArrayList<Node> content = new ArrayList<>();

  BugaBesucher ich;

  int counter = 0;


  public void initialize(URL url, ResourceBundle rb) {
    try {
      QRCode[] pMTSpielSpaßCodeGenerierungQRCodes = QRCodeDAO.listQRCodeByQuery(null, null);
      qrCode = pMTSpielSpaßCodeGenerierungQRCodes[1];
      Benutzer[] user = BenutzerDAO.listBenutzerByQuery("Discriminator = 'user'", null);
      ich = (BugaBesucher) user[1];
    } catch (PersistentException e) {
      e.printStackTrace();
    }
    frage = qrCode.getAufgabe();
    RichtigeAntwort = frage.getAntwortrichtig();

    qrcodelabel.setText(qrCode.getName());
    question.setText(frage.getFrage());
    ans1.setText(frage.getAntwort1());
    ans2.setText(frage.getAntwort2());
    ans3.setText(frage.getAntwortrichtig());
    hint.setText(qrCode.getHinweis());
    hintlabel.setText("Hinweis:");
    hintlabel.setVisible(false);
    hint.setVisible(false);

    content.add(question);
    content.add(answerlabel);
    content.add(ans1);
    content.add(ans2);
    content.add(ans3);
  }


  public void ans_click(ActionEvent actionEvent) {
    Alert errBox = new Alert(Alert.AlertType.ERROR);
    errBox.setTitle("Falsche Antwort");
    errBox.setHeaderText(null);
    errBox.setContentText("Deine Antwort war leider falsch.");

    Alert errBox2 = new Alert(AlertType.INFORMATION);
    errBox2.setTitle("Richtige Antwort");
    errBox2.setHeaderText(null);

    Button source = (Button) actionEvent.getSource();
    if (source.getText() == RichtigeAntwort) {
      errBox2.show();
      hintlabel.setVisible(true);
      hint.setVisible(true);
      for (int i = 0; i < content.size(); i++) {
        content.get(i).setVisible(false);
      }
      if (counter == 0){
      ich.setPunktzahl(ich.getPunktzahl() + 5);
        errBox2.setContentText("Erster Versuch! +5 Punkte");
      }

      else if(counter == 1){
        ich.setPunktzahl(ich.getPunktzahl() + 2);
        errBox2.setContentText("Zweiter Versuch! +2 Punkte");
      } else {
        errBox2.setContentText("Erst beim letzten Versuch keine Punkte!");
      }
      try {
        BenutzerDAO.save(ich);
      } catch (PersistentException e) {
        e.printStackTrace();
      }
    } else {
      errBox.show();
      counter++;
    }
    }
}



