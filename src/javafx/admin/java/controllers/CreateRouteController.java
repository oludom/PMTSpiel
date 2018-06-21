package javafx.admin.java.controllers;

/**
 * @author Jan
 */

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.admin.java.modules.MaintenanceMethods;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


public class CreateRouteController implements Initializable {


    public ImageView Route1EndImage;
    public Button printRoute;
    public Button saveRoutes;
    public Button refresh;
    public ChoiceBox KletterwandList;
    public Label KletterwandE;
    public TextField Route1Name;
    public TextField Route2Name;
    public ImageView Route2StartImage;
    public ImageView Route2EndImage;
    public ImageView Route1StartImage;
    private BufferedImage bufferedImageR1Start = null;
    private BufferedImage bufferedImageR2Start = null;
    private BufferedImage bufferedImageR1End = null;
    private BufferedImage bufferedImageR2End = null;
    private List<Kletterwand> alleKletterwaende;
    private Kletterwand aktuelleKletterwand;

    public CreateRouteController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        alleKletterwaende = new ArrayList<>();
        refreshButton(new ActionEvent());

        Route1Name.textProperty().addListener((observable, oldValue, newValue) -> {
            updateRoute1(newValue);
        });

        Route2Name.textProperty().addListener((observable, oldValue, newValue) -> {
            updateRoute2(newValue);
        });

        KletterwandList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null){
                    setAktuelleKletterwand((String) KletterwandList.getSelectionModel().getSelectedItem());
                }
            }
        });

    }

    private void setAktuelleKletterwand(String selectedItem) {
        try {
            aktuelleKletterwand = KletterwandDAO.getKletterwandByORMID(selectedItem);
        } catch (PersistentException e) {

        }
    }

    private void updateRoute1(String newValue) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWebStart = newValue.equals("") ? "example" : newValue + "_start";
        String myWebEnd = newValue.equals("") ? "example" : newValue + "_end";
        int width = 200;
        int height = 200;
        String fileType = "png";
        try {
            BitMatrix byteMatrixStart = qrCodeWriter.encode(myWebStart, BarcodeFormat.QR_CODE, width, height);
            BitMatrix byteMatrixEnd = qrCodeWriter.encode(myWebEnd, BarcodeFormat.QR_CODE, width, height);
            bufferedImageR1Start = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImageR1Start.createGraphics();
            bufferedImageR1End = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImageR1End.createGraphics();

            Graphics2D graphicsStart = (Graphics2D) bufferedImageR1Start.getGraphics();
            graphicsStart.setColor(Color.WHITE);
            graphicsStart.fillRect(0, 0, width, height);
            graphicsStart.setColor(Color.BLACK);

            Graphics2D graphicsEnd = (Graphics2D) bufferedImageR1End.getGraphics();
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

            Route1StartImage.setImage(SwingFXUtils.toFXImage(bufferedImageR1Start, null));
            Route1EndImage.setImage(SwingFXUtils.toFXImage(bufferedImageR1End, null));

        } catch (WriterException ex) {
            System.out.println("qrcode fehler");
        }
    }

    private void updateRoute2(String newValue) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWebStart = newValue.equals("") ? "example" : newValue + "_start";
        String myWebEnd = newValue.equals("") ? "example" : newValue + "_end";
        int width = 200;
        int height = 200;
        String fileType = "png";
        try {
            BitMatrix byteMatrixStart = qrCodeWriter.encode(myWebStart, BarcodeFormat.QR_CODE, width, height);
            BitMatrix byteMatrixEnd = qrCodeWriter.encode(myWebEnd, BarcodeFormat.QR_CODE, width, height);
            bufferedImageR2Start = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImageR2Start.createGraphics();
            bufferedImageR2End = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImageR2End.createGraphics();

            Graphics2D graphicsStart = (Graphics2D) bufferedImageR2Start.getGraphics();
            graphicsStart.setColor(Color.WHITE);
            graphicsStart.fillRect(0, 0, width, height);
            graphicsStart.setColor(Color.BLACK);

            Graphics2D graphicsEnd = (Graphics2D) bufferedImageR2End.getGraphics();
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

            Route2StartImage.setImage(SwingFXUtils.toFXImage(bufferedImageR2Start, null));
            Route2EndImage.setImage(SwingFXUtils.toFXImage(bufferedImageR2End, null));

        } catch (WriterException ex) {
            System.out.println("qrcode fehler");
        }
    }

    public void save(ActionEvent actionEvent) {

            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {

                    MaintenanceMethods maintenance = new MaintenanceMethods();

                    if (!Route1Name.getText().equals("")){
                        maintenance.createRoute(aktuelleKletterwand, Route1Name.getText());
                    }

                    if (!Route2Name.getText().equals("")){
                        maintenance.createRoute(aktuelleKletterwand, Route2Name.getText());
                    }

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

    }

    private void reset() {
        KletterwandList.getSelectionModel().clearSelection();
        Route1Name.setText("");
        Route2Name.setText("");
    }

    public void printKletterwand(ActionEvent actionEvent) {
        getCode(bufferedImageR1Start, Route1Name.getText() + "_start");
        getCode(bufferedImageR1End, Route1Name.getText() + "_end");
        getCode(bufferedImageR2Start, Route2Name.getText() + "_start");
        getCode(bufferedImageR2End, Route2Name.getText() + "_end");
    }

    public void getCode(BufferedImage image, String name) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setInitialFileName(name);
        File file = fileChooser.showSaveDialog(printRoute.getScene().getWindow());

        try {
            if (image != null && file != null) {
                ImageIO.write(image, "png", file);
            } else {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refreshButton(ActionEvent actionEvent) {
        String aktuelleWand = (String) KletterwandList.getSelectionModel().getSelectedItem();

        KletterwandList.getItems().clear();
        alleKletterwaende.clear();

        MaintenanceMethods maintenanceMethods = new MaintenanceMethods();
        try {
            List<String> kletterwaende = maintenanceMethods.refreshKletterwand();
            alleKletterwaende = maintenanceMethods.listKletterwaende();
            for (String kletterwand :
                    kletterwaende) {
                KletterwandList.getItems().add(kletterwand);
            }
            if (aktuelleWand != null) {
                KletterwandList.getSelectionModel().select(aktuelleWand);
            }
        } catch (SQLException e) {
            KletterwandE.setTextFill(javafx.scene.paint.Color.RED);
            KletterwandE.setText("Es gab einen Fehler bei der Datenbankabfrage.");
        }
    }
}
