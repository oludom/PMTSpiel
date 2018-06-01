package javafx.admin;

/**
 * @author Jan
 */

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.orm.PersistentException;
import pmt.spielspaß.codegenerierung.Kletterwand;
import pmt.spielspaß.codegenerierung.KletterwandDAO;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;


public class CreateKletterwandController implements Initializable {

    @FXML
    public Button KletterwandReset;
    @FXML
    public Button KletterwandSave;
    @FXML
    public ImageView KletterwandImageEnd;
    @FXML
    public ImageView KletterwandImageStart;
    @FXML
    public TextField KletterwandName;
    @FXML
    public TextField KletterwandLat;
    @FXML
    public TextField KletterwandLong;
    @FXML
    public Label KletterwandE;

    private BufferedImage bufferedImageStart = null;
    private BufferedImage bufferedImageEnd = null;

    public CreateKletterwandController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert KletterwandName != null : "fx:id=\"KletterwandName\" was not injected: check your FXML file 'Run.fxml'.";
        assert KletterwandLat != null : "fx:id=\"KletterwandLat\" was not injected: check your FXML file 'Run.fxml'.";
        assert KletterwandLong != null : "fx:id=\"KletterwandLong\" was not injected: check your FXML file 'Run.fxml'.";
        assert KletterwandImageStart != null : "fx:id=\"KletterwandImageStart\" was not injected: check your FXML file 'Run.fxml'.";
        assert KletterwandImageEnd != null : "fx:id=\"KletterwandImageEnd\" was not injected: check your FXML file 'Run.fxml'.";

        KletterwandName.textProperty().addListener((observable, oldValue, newValue) -> {
            updateKletterwand(newValue);
        });

    }

    private void updateKletterwand(String newValue) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWebStart = newValue.equals("") ? "example" : newValue + "_start";
        String myWebEnd = newValue.equals("") ? "example" : newValue + "_end";
        int width = 200;
        int height = 200;
        String fileType = "png";

//    bufferedImage = null;
        try {
            BitMatrix byteMatrixStart = qrCodeWriter.encode(myWebStart, BarcodeFormat.QR_CODE, width, height);
            BitMatrix byteMatrixEnd = qrCodeWriter.encode(myWebEnd, BarcodeFormat.QR_CODE, width, height);
            bufferedImageStart = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImageStart.createGraphics();
            bufferedImageEnd = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImageEnd.createGraphics();

            Graphics2D graphicsStart = (Graphics2D) bufferedImageStart.getGraphics();
            graphicsStart.setColor(Color.WHITE);
            graphicsStart.fillRect(0, 0, width, height);
            graphicsStart.setColor(Color.BLACK);

            Graphics2D graphicsEnd = (Graphics2D) bufferedImageEnd.getGraphics();
            graphicsEnd.setColor(Color.WHITE);
            graphicsEnd.fillRect(0, 0, width, height);
            graphicsEnd.setColor(Color.BLACK);

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrixStart.get(i, j)) {
                        graphicsStart.fillRect(i, j, 1, 1);
                    }
                    if (byteMatrixEnd.get(i, j)) {
                        graphicsEnd.fillRect(i, j, 1, 1);
                    }
                }
            }

            KletterwandImageStart.setImage(SwingFXUtils.toFXImage(bufferedImageStart, null));
            KletterwandImageEnd.setImage(SwingFXUtils.toFXImage(bufferedImageEnd, null));

        } catch (WriterException ex) {
            System.out.println("qrcode fehler");
        }
    }

    public void save(ActionEvent actionEvent) {
        if (!KletterwandName.getText().equals("") &&
                !KletterwandLat.getText().equals("") &&
                !KletterwandLong.getText().equals("")
                ) {

            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {

                    Kletterwand kletterwand = KletterwandDAO.createKletterwand();

                    kletterwand.setName(KletterwandName.getText());
                    kletterwand.setLat(NumberFormat.getInstance(Locale.GERMAN).parse(KletterwandLat.getText()).floatValue());
                    kletterwand.setLon(NumberFormat.getInstance(Locale.GERMAN).parse(KletterwandLong.getText()).floatValue());
                    kletterwand.setStartTag(KletterwandName.getText() + "_start");
                    kletterwand.setEndTag(KletterwandName.getText() + "_end");


                    KletterwandDAO.save(kletterwand);
                    Platform.runLater(() -> {
                        KletterwandE.setText("Erfolgreich gespeichert.");
                        KletterwandE.setTextFill(javafx.scene.paint.Color.GREEN);
                        reset();
                    });

                    return null;
                }
            };

            Thread th = new Thread(task);

            th.setDaemon(true);

            th.start();
        } else {
            KletterwandE.setTextFill(javafx.scene.paint.Color.RED);
            KletterwandE.setText("Bitte alle Felder ausfüllen.");
        }
    }

    private void reset() {
        KletterwandName.setText("");
        KletterwandLat.setText("");
        KletterwandLong.setText("");
    }

    public void printKletterwand(ActionEvent actionEvent) {
        getCode(bufferedImageStart, KletterwandName.getText() + "_start");
        getCode(bufferedImageEnd, KletterwandName.getText() + "_end");
    }

    public void getCode(BufferedImage image, String name) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setInitialFileName(name);
        File file = fileChooser.showSaveDialog(KletterwandReset.getScene().getWindow());

        try {
            if (image != null && file != null) {
                ImageIO.write(image, "png", file);
            } else {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
