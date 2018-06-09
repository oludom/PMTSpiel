package javafx.admin.java.controllers;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EditQRCodeController implements Initializable {
    @FXML public TextField QRName;
    @FXML public TextField QRLat;
    @FXML public TextField QRLong;
    @FXML public Label QRE;
    @FXML public TextArea QRHint;
    @FXML public ChoiceBox QRQuestion;
    @FXML public ChoiceBox QRNext;
    @FXML public Button QRReset;
    @FXML public Button QRSave;
    @FXML public ImageView QRImage;
    @FXML public ChoiceBox alleQRCodes;
    @FXML private BufferedImage bufferedImage;

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
                fillInputFields(findByQRCodeName(qrCodes, (String) alleQRCodes.getSelectionModel().getSelectedItem()));
            }
        });
    }

    private QRCode findByQRCodeName(List<QRCode> qrCodes, String selectedItem) {
        for (QRCode qrCode : qrCodes) {
            if (qrCode.getName().equals(selectedItem)){
                return qrCode;
            }
        }
        return null;
    }

    private void fillInputFields(QRCode selectedQRCode) {
        QRName.setText(selectedQRCode.getName());
        QRHint.setText(selectedQRCode.getHinweis());
        QRLat.setText(""+selectedQRCode.getLat());
        QRLong.setText(""+selectedQRCode.getLon());
        /*
         * get and insert all questions available
         */
        try {
            int index = 0;
            Frage[] fragen = FrageDAO.listFrageByQuery(null, null);
            for (Frage frage : fragen) {
                QRQuestion.getItems().add(frage.getFrage());
                if(frage.equals(selectedQRCode.getAufgabe())){
                    index = QRQuestion.getItems().size()-1;
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
                QRNext.getItems().add("QR-Code: " + code.getName());
                if(code.equals(selectedQRCode.getNextQRCode())){
                    index = QRNext.getItems().size()-1;
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

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(ActionEvent actionEvent) {

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
}
