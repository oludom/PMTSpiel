package javafx.admin.java.controllers;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.admin.java.modules.MaintenanceMethods;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
import java.util.ResourceBundle;

public class EditKletterwandController implements Initializable {

    @FXML public Button KletterwandSave;
    @FXML public Button KletterwandReset;
    @FXML public Button KletterwandDelete;
    @FXML public ImageView KletterwandImageStart;
    @FXML public ImageView KletterwandImageEnd;
    @FXML public Label KletterwandE;
    @FXML public TextField KletterwandName;
    @FXML public ChoiceBox KletterwandList;

    private BufferedImage bufferedImageStart;
    private BufferedImage bufferedImageEnd;
    private Kletterwand aktuelleKletterwand;

    public EditKletterwandController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        assert KletterwandName != null : "fx:id=\"KletterwandName\" was not injected: check your FXML file 'Run.fxml'.";
        assert KletterwandImageStart != null : "fx:id=\"KletterwandImageStart\" was not injected: check your FXML file 'Run.fxml'.";
        assert KletterwandImageEnd != null : "fx:id=\"KletterwandImageEnd\" was not injected: check your FXML file 'Run.fxml'.";

        try {
            Kletterwand[] kletterwaende = KletterwandDAO.listKletterwandByQuery(null, null);
            for (Kletterwand kletterwand : kletterwaende) {
                KletterwandList.getItems().add(kletterwand.getName());
            }
            //KletterwandList.getSelectionModel().select(0);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        KletterwandList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                updateKletterwand((String) KletterwandList.getSelectionModel().getSelectedItem());
            }
        });
    }

    private void updateKletterwand(String kletterwand) {
        try {
            aktuelleKletterwand = KletterwandDAO.getKletterwandByORMID(kletterwand);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        KletterwandName.setText(kletterwand);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        System.out.println("test:" + kletterwand);
        String myWebStart = kletterwand == null || kletterwand.equals("") ? "example" : kletterwand + "_start";
        String myWebEnd = kletterwand == null || kletterwand.equals("") ? "example" : kletterwand + "_end";
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
            System.out.println("Fehler");
        }
    }

    public void deleteKletterwand(ActionEvent actionEvent) {

        try {
            KletterwandDAO.delete(aktuelleKletterwand);
            reset();
            KletterwandE.setText("Erfolgreich gelöscht.");

        } catch (PersistentException e) {
            KletterwandE.setText("Löschen hat nicht funktioniert; " + e.getMessage());
        }
    }

    private void reset() {
        KletterwandList.getItems().remove(0, KletterwandList.getItems().size());
        try {
            Kletterwand[] kletterwaende = KletterwandDAO.listKletterwandByQuery(null, null);
            for (Kletterwand kletterwand : kletterwaende) {
                KletterwandList.getItems().add(kletterwand.getName());
            }
            KletterwandList.getSelectionModel().select(0);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        updateKletterwand((String) KletterwandList.getItems().get(0));
    }

    public void printKletterwand(ActionEvent actionEvent) {
        getCode(bufferedImageStart, KletterwandName.getText() + "_start");
        getCode(bufferedImageEnd, KletterwandName.getText() + "_end");
    }

    public void save(ActionEvent actionEvent) {
        Kletterwand kletterwand = new Kletterwand();
        kletterwand.setName(KletterwandName.getText());
        kletterwand.setStartTag(KletterwandName.getText() + "_start");
        kletterwand.setEndTag(KletterwandName.getText() + "_end");

        MaintenanceMethods maintenance = new MaintenanceMethods();
        maintenance.updateKletterwand(aktuelleKletterwand, kletterwand);

    }

    private void getCode(BufferedImage image, String name) {
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
