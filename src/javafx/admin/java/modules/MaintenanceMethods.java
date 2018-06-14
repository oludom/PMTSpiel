package javafx.admin.java.modules;

import org.orm.PersistentException;
import pmt.spielspaß.codegenerierung.*;


import java.sql.*;
import java.util.List;

public class MaintenanceMethods {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


    public MaintenanceMethods() {
    }

    public void deleteQRCode(QRCode qrCode) {
        /*
         * Vorgänger des QRCodes kriegt dessen Nachfolger als Nachfolger reingeschrieben
         */

        try {
            QRCode nachfolger = qrCode.getNextQRCode();
            QRCode[] vorgaenger = QRCodeDAO.listQRCodeByQuery(null, null);

            for (QRCode code : vorgaenger) {
                if (code.getNextQRCode() != null && code.getNextQRCode().equals(qrCode)) {
                    code.setNextQRCode(nachfolger);
                    QRCodeDAO.save(code);
                }
            }

        } catch (PersistentException e) {
            e.printStackTrace();
        }

        /*
         * QRCode wird gelöscht
         */

        try {
            QRCodeDAO.delete(qrCode);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

    }

    public void updateQRCode(QRCode oldQRCode, QRCode updatedQRCode) {
        /*
         * Check ob Name geändert wurde
         */

        if (!oldQRCode.getName().equals(updatedQRCode.getName())) {
            try {
                connect();
                preparedStatement = connection.prepareStatement("UPDATE bugaspiel.qrcode SET name=? WHERE name=?");
                preparedStatement.setString(1, updatedQRCode.getName());
                preparedStatement.setString(2, oldQRCode.getName());
                resultSet = preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }

        /*
         * Was sonst geändert wurde
         */

        try {
            QRCode code = QRCodeDAO.getQRCodeByORMID(updatedQRCode.getName());
            code.setNextQRCode(updatedQRCode.getNextQRCode());
            code.setAufgabe(updatedQRCode.getAufgabe());
            code.setHinweis(updatedQRCode.getHinweis());
            code.setLat(updatedQRCode.getLat());
            code.setLon(updatedQRCode.getLon());
            QRCodeDAO.save(code);
        } catch (PersistentException e) {
            e.printStackTrace();
        }


    }

    public void deleteKletterwand(Kletterwand kletterwand) {

    }

    public void updateKletterwand(Kletterwand oldKletterwand, Kletterwand updatedKletterwand) {
        /*
         * Wenn Name geändert wurde
         */
        try {
            KletterwandDAO.save(updatedKletterwand);
            Zeit[] alleZeiten = ZeitDAO.listZeitByQuery(null, null);
            for (int i = 0; i < alleZeiten.length; i++) {
                if (alleZeiten[i].getKletterwand().equals(oldKletterwand)){
                    alleZeiten[i].setKletterwand(updatedKletterwand);
                    ZeitDAO.save(alleZeiten[i]);
                }
            }
            KletterwandDAO.delete(oldKletterwand);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        /*
         * Der ganze Rest
         */

    }

    public void deleteQuestion(Frage frage) {

    }

    public void updateQuestion(Frage oldFrage, Frage updatedFrage) {

    }

    private void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://www.se.hs-heilbronn.de/bugaspiel?"
                            + "user=BuGaSpielUser&password=SpielPw");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // You need to close the resultSet
    private void close() {
        try {

            if (resultSet != null) {
                resultSet.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {

        }
    }

}
