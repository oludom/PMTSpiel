package javafx.admin.java.controllers;

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
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import org.orm.PersistentException;
import pmt.spielspaß.codegenerierung.Frage;
import pmt.spielspaß.codegenerierung.FrageDAO;
import pmt.spielspaß.codegenerierung.QRCode;
import pmt.spielspaß.codegenerierung.QRCodeDAO;

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

public class EditQRCodeController implements Initializable {
    @FXML
    public TextField QRName;
//    @FXML
//    public TextField QRLat;
//    @FXML
//    public TextField QRLong;
    @FXML
    public Label QRE;
    @FXML
    public TextArea QRHint;
    @FXML
    public ChoiceBox QRQuestion;
    @FXML
    public ChoiceBox QRNext;
    @FXML
    public Button QRReset;
    @FXML
    public Button QRSave;
    @FXML
    public ImageView QRImage;
    @FXML
    public ChoiceBox alleQRCodes;
    @FXML
    public Label editQRStatus;
    @FXML
    public Button refresh;
    @FXML
    private BufferedImage bufferedImage;

    private QRCode currentQR;

    public EditQRCodeController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<QRCode> qrCodes = new ArrayList<>();
        try {
            QRCode[] qrQuerry = QRCodeDAO.listQRCodeByQuery(null, null);
            for (QRCode qrCode : qrQuerry) {
                alleQRCodes.getItems().add(qrCode.getName());
                qrCodes.add(qrCode);
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        alleQRCodes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue != null){
                    fillInputFields(findByQRCodeName(qrCodes, (String) alleQRCodes.getSelectionModel().getSelectedItem()));
                }
            }
        });

        QRName.textProperty().addListener((observable, oldValue, newValue) -> {
            paintQR(newValue);
        });
    }

    private QRCode findByQRCodeName(List<QRCode> qrCodes, String selectedItem) {
        for (QRCode qrCode : qrCodes) {
            if (qrCode.getName().equals(selectedItem)) {
                return qrCode;
            }
        }
        return null;
    }

    private void fillInputFields(QRCode selectedQRCode) {

        currentQR = selectedQRCode;

        QRName.setText(selectedQRCode.getName());
        QRHint.setText(selectedQRCode.getHinweis());
        /*
         * get and insert all questions available
         */
        try {
            int index = 0;
            Frage[] fragen = FrageDAO.listFrageByQuery(null, null);
            for (Frage frage : fragen) {
                QRQuestion.getItems().add(frage.getFrage());
                if (frage.equals(selectedQRCode.getAufgabe())) {
                    index = QRQuestion.getItems().size() - 1;
                }
            }
            QRQuestion.getSelectionModel().select(index);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        /*
         * get and insert all other qr-codes available
         */

        try {
            int index = 0;
            QRCode[] codes = QRCodeDAO.listQRCodeByQuery(null, null);
            for (QRCode code : codes) {
                QRNext.getItems().add(code.getName());
                if (code.equals(selectedQRCode.getNextQRCode())) {
                    index = QRNext.getItems().size() - 1;
                }
            }
            QRNext.getSelectionModel().select(index);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        QRName.textProperty().addListener((observable, oldValue, newValue) -> {
            paintQR(newValue);
        });


    }

    public void getCode(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(QRReset.getScene().getWindow());

        try {
            if (bufferedImage != null && file != null) {
                ImageIO.write(bufferedImage, "png", file);
            } else {
                QRE.setText("Es ist ein Fehler aufgetreten.");
                QRE.setTextFill(javafx.scene.paint.Color.RED);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(ActionEvent actionEvent) {
        if (!QRName.getText().equals("") &&
//                !QRLat.getText().equals("") &&
//                !QRLong.getText().equals("") &&
                !QRHint.getText().equals("")) {

            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {

                    QRCode code = QRCodeDAO.createQRCode();

                    code.setName(QRName.getText());
//                    code.setLat(NumberFormat.getInstance(Locale.GERMAN).parse(QRLat.getText()).floatValue());
//                    code.setLon(NumberFormat.getInstance(Locale.GERMAN).parse(QRLong.getText()).floatValue());
                    code.setHinweis(QRHint.getText());


                    try {
                        Frage[] fragen = FrageDAO.listFrageByQuery(null, null);
                        for (Frage frage : fragen) {
                            if (frage.getFrage().equals(QRQuestion.getValue())) {
                                code.setAufgabe(frage);
                            }
                        }
                    } catch (PersistentException e) {
                        editQRStatus.setText("Es gab ein Problem mit der Frage.");
                        editQRStatus.setTextFill(javafx.scene.paint.Color.RED);
                        e.printStackTrace();
                    }

                    try {
                        QRCode[] codes = QRCodeDAO.listQRCodeByQuery(null, null);
                        for (QRCode c : codes) {
                            if (c.getName().equals(QRNext.getValue().toString().substring(9))) {
                                code.setNextQRCode(c);
                            }
                        }
                        Platform.runLater(() -> {
                            QRNext.getSelectionModel().select(0);
                        });
                    } catch (PersistentException e) {
                        editQRStatus.setText("Es gab ein Problem mit dem nächsten QRCode.");
                        editQRStatus.setTextFill(javafx.scene.paint.Color.RED);
                        e.printStackTrace();
                    }

                    MaintenanceMethods maintenanceMethods = new MaintenanceMethods();
                    maintenanceMethods.updateQRCode(currentQR, code);
                    Platform.runLater(() -> {
                        editQRStatus.setText("Erfolgreich gespeichert.");
                        editQRStatus.setTextFill(javafx.scene.paint.Color.GREEN);
                        reset();
                    });

                    return null;

                }
            };

            Thread th = new Thread(task);

            th.setDaemon(true);

            th.start();
        } else {
            editQRStatus.setText("Bitte alle Felder ausfüllen.");
            editQRStatus.setTextFill(javafx.scene.paint.Color.RED);
        }
    }

    public void delete(ActionEvent event) {
        MaintenanceMethods maintenance = new MaintenanceMethods();
        String hinweis = maintenance.deleteQRCode(currentQR);
        reset();
    }

    private void reset() {
        QRName.setText("");
//        QRLat.setText("");
//        QRLong.setText("");
        QRHint.setText("");
        QRNext.getSelectionModel().selectFirst();
        QRQuestion.getSelectionModel().selectFirst();
        alleQRCodes.getSelectionModel().selectFirst();
    }

    private void paintQR(String value) {

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

    @FXML
    private void refreshButton() {
        MaintenanceMethods maintenanceMethods = new MaintenanceMethods();

        String selectedQRCode = (String) alleQRCodes.getSelectionModel().getSelectedItem();
        String selectedFrage = (String) QRQuestion.getSelectionModel().getSelectedItem();
        String selectedNextQRCode = (String) QRNext.getSelectionModel().getSelectedItem();

        //refresh für normale QRCode Choicebox
        alleQRCodes.getItems().clear();
        try {
            List<String> alleQRs = maintenanceMethods.refreshQrcodes();
            for (String string : alleQRs) {
                alleQRCodes.getItems().add(string);
            }
            if (selectedQRCode != null){
                alleQRCodes.getSelectionModel().select(selectedQRCode);
            }
        } catch (SQLException e) {
            QRE.setTextFill(javafx.scene.paint.Color.RED);
            QRE.setText("Es gab einen Fehler beim Laden der QRCodes.");
        }

        //refresh für Fragen Choicebox
        QRQuestion.getItems().clear();
        try {
            List<String> qrFragen = maintenanceMethods.refreshQuestions();
            for (String string : qrFragen) {
                QRQuestion.getItems().add(string);
            }
            if (selectedFrage != null){
                QRQuestion.getSelectionModel().select(selectedFrage);
            }
        } catch (SQLException e) {
            QRE.setTextFill(javafx.scene.paint.Color.RED);
            QRE.setText("Es gab einen Fehler beim Laden der Fragen.");
        }

        //refresh für nächste QRCode Choicebox
        QRNext.getItems().clear();
//        QRNext.getItems().add(null);
        try {
            List<String> qrNext = maintenanceMethods.refreshQrcodes();
            for (String string : qrNext) {
                QRNext.getItems().add(string);
            }
            if (selectedNextQRCode != null){
                QRNext.getSelectionModel().select(selectedNextQRCode);
            }
        } catch (SQLException e) {
            QRE.setTextFill(javafx.scene.paint.Color.RED);
            QRE.setText("Es gab einen Fehler beim Laden der nächsten QRCodes.");
        }

    }
}
