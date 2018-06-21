package javafx.admin.java.controllers;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.admin.java.modules.MaintenanceMethods;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import org.orm.PersistentException;
import pmt.spielspaß.codegenerierung.Frage;
import pmt.spielspaß.codegenerierung.FrageDAO;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.google.zxing.WriterException;

import java.awt.Color;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.ImageView;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pmt.spielspaß.codegenerierung.QRCode;
import pmt.spielspaß.codegenerierung.QRCodeDAO;

import javax.imageio.ImageIO;

/**
 * @author Jan Leppich
 */
public class CreateQRCodeController implements Initializable {

   @FXML public Button refresh;
  @FXML
  private ResourceBundle resources;

  @FXML
  private URL location;

  @FXML
  private TextField QRName;

  @FXML
  private ImageView QRImage;

  @FXML
  private TextArea QRHint;

  @FXML
  private ChoiceBox<String> QRQuestion;

  @FXML
  private ChoiceBox<String> QRNext;

  @FXML
  private Button QRReset;

  @FXML
  private Button QRSave;

  @FXML
  private Label QRE;

  private BufferedImage bufferedImage = null;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

    assert QRName != null : "fx:id=\"QRName\" was not injected: check your FXML file 'Run.fxml'.";
    assert QRImage != null : "fx:id=\"QRImage\" was not injected: check your FXML file 'Run.fxml'.";
    assert QRHint != null : "fx:id=\"QRHint\" was not injected: check your FXML file 'Run.fxml'.";
    assert QRQuestion != null : "fx:id=\"QRquestion\" was not injected: check your FXML file 'Run.fxml'.";
    assert QRNext != null : "fx:id=\"QRNext\" was not injected: check your FXML file 'Run.fxml'.";
    assert QRReset != null : "fx:id=\"QRReset\" was not injected: check your FXML file 'Run.fxml'.";
    assert QRSave != null : "fx:id=\"QRSave\" was not injected: check your FXML file 'Run.fxml'.";
    assert QRE != null : "fx:id=\"QRError\" was not injected: check your FXML file 'Run.fxml'.";


    /*
     * get and insert all questions and qrcodes available
     */

    refreshQuestionsAndQRCodes();

    QRName.textProperty().addListener((observable, oldValue, newValue) -> {
      updateQR(newValue);
    });

  }

  private void refreshQuestionsAndQRCodes(){
    try{

      QRQuestion.getItems().clear();
      QRNext.getItems().clear();

      Frage[] fragen = FrageDAO.listFrageByQuery(null, null);
      for (Frage frage : fragen) {
        QRQuestion.getItems().add(frage.getFrage());
      }

      QRCode[] codes = QRCodeDAO.listQRCodeByQuery(null, null);
      for (QRCode code : codes) {
        QRNext.getItems().add("QR-Code: " + code.getName());
      }
    } catch (PersistentException e){
      e.printStackTrace();
    }
  }

  public void save() {

    if (
        !QRName.getText().equals("") &&
        !QRHint.getText().equals("")
        ) {

      Task<Void> task = new Task<Void>() {
        @Override
        protected Void call() throws Exception {

          QRCode code = QRCodeDAO.createQRCode();

          code.setName(QRName.getText());
          code.setHinweis(QRHint.getText());


          try {
            Frage[] fragen = FrageDAO.listFrageByQuery(null, null);
            for (Frage frage : fragen) {
              if (frage.getFrage().equals(QRQuestion.getValue())) {
                code.setAufgabe(frage);
              }
            }
          } catch (PersistentException e) {
            e.printStackTrace();
          }

          try {
            QRCode[] codes = QRCodeDAO.listQRCodeByQuery(null, null);
            for (QRCode c : codes) {
              if (c.getName().equals(QRNext.getValue().substring(9))) {
                code.setNextQRCode(c);
              }
            }
            Platform.runLater(() -> {QRNext.getSelectionModel().select(0);});
          } catch (PersistentException e) {
            e.printStackTrace();
          }

          QRCodeDAO.save(code);
          Platform.runLater(() -> {
            QRE.setText("Erfolgreich gespeichert.");
            QRE.setTextFill(javafx.scene.paint.Color.GREEN);
            reset();
            QRNext.getItems().add(code.getName());
          });

          return null;
        }
      };

      Thread th = new Thread(task);

      th.setDaemon(true);

      th.start();


    }else {
      QRE.setTextFill(javafx.scene.paint.Color.RED);
      QRE.setText("Bitte alle Felder ausfüllen.");
    }
  }
  
  private void reset() {

    QRName.setText("");
    QRHint.setText("");

  }

  private void updateQR(String value) {

    QRCodeWriter qrCodeWriter = new QRCodeWriter();
    String myWeb = value.equals("") ? "example" : value;
    int width = 200;
    int height = 200;
    String fileType = "png";

//    bufferedImage = null;
    try {
      BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
      bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
      bufferedImage.createGraphics();

      Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
      graphics.setColor(Color.WHITE);
      graphics.fillRect(0, 0, width, height);
      graphics.setColor(Color.BLACK);

      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          if (byteMatrix.get(i, j)) {
            graphics.fillRect(i, j, 1, 1);
          }
        }
      }

      QRImage.setImage(SwingFXUtils.toFXImage(bufferedImage, null));

    } catch (WriterException ex) {
      System.out.println("qrcode fehler");
    }
  }

  public void getCode() {
    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
    fileChooser.getExtensionFilters().add(extFilter);
    File file = fileChooser.showSaveDialog(QRReset.getScene().getWindow());

    try {
      if (bufferedImage != null && file != null) {
        ImageIO.write(bufferedImage, "png", file);
      } else {

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  private void refreshButton(){
    MaintenanceMethods maintenanceMethods = new MaintenanceMethods();
    //refresh für Fragen Choicebox
    QRQuestion.getItems().clear();
    try {
      List<String> qrFragen = maintenanceMethods.refreshQuestions();
      for (String string : qrFragen) {
        QRQuestion.getItems().add(string);
      }
    } catch (SQLException e) {
      QRE.setTextFill(javafx.scene.paint.Color.RED);
      QRE.setText("Es gab einen Fehler beim Laden der Fragen.");
    }

    //refresh für nächste QRCode Choicebox
    QRNext.getItems().clear();
    QRNext.getItems().add(null);
    try {
      List<String> qrNext = maintenanceMethods.refreshQrcodes();
      for (String string : qrNext) {
        QRNext.getItems().add(string);
      }
    } catch (SQLException e) {
      QRE.setTextFill(javafx.scene.paint.Color.RED);
      QRE.setText("Es gab einen Fehler beim Laden der nächsten QRCodes.");
    }
  }

}
