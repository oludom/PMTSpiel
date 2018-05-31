package javafx.admin;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
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
import java.text.NumberFormat;
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
 * @author Micha Heiß
 */
public class CreateQRCodeController implements Initializable {

  @FXML
  private ResourceBundle resources;

  @FXML
  private URL location;

  @FXML
  private TextField QRName;

  @FXML
  private TextField QRLat;

  @FXML
  private TextField QRLong;

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

    assert QRName != null : "fx:id=\"QRName\" was not injected: check your FXML file 'createQRCode.fxml'.";
    assert QRLat != null : "fx:id=\"QRLat\" was not injected: check your FXML file 'createQRCode.fxml'.";
    assert QRLong != null : "fx:id=\"QRLong\" was not injected: check your FXML file 'createQRCode.fxml'.";
    assert QRImage != null : "fx:id=\"QRImage\" was not injected: check your FXML file 'createQRCode.fxml'.";
    assert QRHint != null : "fx:id=\"QRHint\" was not injected: check your FXML file 'createQRCode.fxml'.";
    assert QRQuestion != null : "fx:id=\"QRquestion\" was not injected: check your FXML file 'createQRCode.fxml'.";
    assert QRNext != null : "fx:id=\"QRNext\" was not injected: check your FXML file 'createQRCode.fxml'.";
    assert QRReset != null : "fx:id=\"QRReset\" was not injected: check your FXML file 'createQRCode.fxml'.";
    assert QRSave != null : "fx:id=\"QRSave\" was not injected: check your FXML file 'createQRCode.fxml'.";
    assert QRE != null : "fx:id=\"QRError\" was not injected: check your FXML file 'createQRCode.fxml'.";


    /*
     * get and insert all questions available
     */
    try {
      Frage[] fragen = FrageDAO.listFrageByQuery(null, null);
      for (Frage frage : fragen) {
        QRQuestion.getItems().add(frage.getFrage());
      }
      QRQuestion.getSelectionModel().select(0);
    } catch (PersistentException e) {
      e.printStackTrace();
    }

    /*
     * get and insert all other qr-codes available
     */

    try {
      QRCode[] codes = QRCodeDAO.listQRCodeByQuery(null, null);
      for (QRCode code : codes) {
        QRNext.getItems().add("QR-Code: " + code.getName());
      }
      QRNext.getSelectionModel().select(0);
    } catch (PersistentException e) {
      e.printStackTrace();
    }

    /*
     * set text of Hint TextField
     */

    QRHint.setText("Hier steht ein Hinweis auf die Position des nächsten QR-Codes.");

    QRName.textProperty().addListener((observable, oldValue, newValue) -> {
      updateQR(newValue);
    });

  }

  public void save() {

    if (
        !QRName.getText().equals("") &&
        !QRLat.getText().equals("") &&
        !QRLong.getText().equals("") &&
        !QRHint.getText().equals("")
        ) {

      Task<Void> task = new Task<Void>() {
        @Override
        protected Void call() throws Exception {

          QRCode code = QRCodeDAO.createQRCode();

          code.setName(QRName.getText());
          code.setLat(NumberFormat.getInstance(Locale.GERMAN).parse(QRLat.getText()).floatValue());
          code.setLon(NumberFormat.getInstance(Locale.GERMAN).parse(QRLong.getText()).floatValue());
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
    QRLat.setText("");
    QRLong.setText("");
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

}
