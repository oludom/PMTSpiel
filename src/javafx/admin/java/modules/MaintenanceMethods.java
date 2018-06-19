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

    public String deleteQRCode(QRCode qrCode) {

        try {
            connect();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement("UPDATE bugaspiel.benutzer SET letzterQRCode=null WHERE name=?");
            preparedStatement.setString(1, qrCode.getName());
            preparedStatement.execute();
            connection.commit();

            QRCodeDAO.delete(qrCode);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PersistentException e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return null;

        /*
         * Vorgänger des QRCodes kriegt dessen Nachfolger als Nachfolger reingeschrieben
         */

//        try {
//            QRCode nachfolger = qrCode.getNextQRCode();
//            QRCode[] vorgaenger = QRCodeDAO.listQRCodeByQuery(null, null);
//
//            for (QRCode code : vorgaenger) {
//                if (code.getNextQRCode() != null && code.getNextQRCode().equals(qrCode)) {
//                    code.setNextQRCode(nachfolger);
//                    QRCodeDAO.save(code);
//                }
//            }
//
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }
//
//
//
//        /*
//         * QRCode wird gelöscht
//         */
//
//        try {
//            QRCodeDAO.delete(qrCode);
//        } catch (PersistentException e) {
//            e.printStackTrace();
//        }

    }

    public void updateQRCode(QRCode oldQRCode, QRCode updatedQRCode) {
        /*
         * Check ob Name geändert wurde
         */

        if (!oldQRCode.getName().equals(updatedQRCode.getName())) {
            try {
                QRCodeDAO.save(updatedQRCode);
                QRCode[] vorgaenger = QRCodeDAO.listQRCodeByQuery(null, null);

                for (QRCode code : vorgaenger) {
                    if (code.getNextQRCode() != null && code.getNextQRCode().equals(oldQRCode)) {
                        code.setNextQRCode(updatedQRCode);
                        QRCodeDAO.save(code);
                    }
                }


            } catch (PersistentException e) {
                e.printStackTrace();
            }


            try {
                connect();
                connection.setAutoCommit(false);
                preparedStatement = connection.prepareStatement("UPDATE bugaspiel.benutzer SET letzterQRCode=? WHERE letzerQRCode=?");
                preparedStatement.setString(1, updatedQRCode.getName());
                preparedStatement.setString(2, oldQRCode.getName());
                preparedStatement.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                close();
            }


            try {
                QRCodeDAO.delete(oldQRCode);
            } catch (PersistentException e) {
                e.printStackTrace();
            }

        } else {
            try {
                QRCode code = QRCodeDAO.getQRCodeByORMID(oldQRCode.getName());
                code.setNextQRCode(updatedQRCode.getNextQRCode());
                code.setAufgabe(updatedQRCode.getAufgabe());
                code.setHinweis(updatedQRCode.getHinweis());

                QRCodeDAO.save(code);
            } catch (PersistentException e) {
                e.printStackTrace();
            }
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
            preparedStatement = connection.prepareStatement("UPDATE bugaspiel.zeit SET KletterwandName=? WHERE KletterwandName=?");
            preparedStatement.setString(1, updatedKletterwand.getName());
            preparedStatement.setString(2, oldKletterwand.getName());
            preparedStatement.execute();

            PreparedStatement anotherStatement =
                    connection.prepareStatement("UPDATE bugaspiel.kletterwand_route SET kletterwand=? WHERE kletterwand=?");
            anotherStatement.setString(1, updatedKletterwand.getName());
            anotherStatement.setString(2, oldKletterwand.getName());
            anotherStatement.execute();

            KletterwandDAO.delete(oldKletterwand);
        } catch (PersistentException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    public void deleteQuestion(Frage frage) throws SQLException, PersistentException {

        //Zufällige Frage wird als Ersatz für Frage in QRCode gewählt

        Frage[] fragen = FrageDAO.listFrageByQuery("'Frage'!=" + frage.getFrage(), null);


    }

    public void updateQuestion(Frage oldFrage, Frage updatedFrage) throws PersistentException, SQLException {
        if (!oldFrage.getFrage().equals(updatedFrage.getFrage())) {
            //Frage wird als neue Instaanz gespeichert
            FrageDAO.save(updatedFrage);

            //Foreign Keys mit der Frage werden geändert auf die neue Version
            try {
                connect();
                connection.setAutoCommit(false);
                PreparedStatement statement1 = connection.prepareStatement("UPDATE bugaspiel.qrcode SET FrageFrage=? WHERE FrageFrage=?");
                statement1.setString(1, updatedFrage.getFrage());
                statement1.setString(2, oldFrage.getFrage());
                statement1.execute();
                connection.commit();
            } finally {
                close();
            }

            //Alte Frage wird gelöscht
            FrageDAO.delete(oldFrage);

        } else {
            Frage frage = FrageDAO.getFrageByORMID(oldFrage.getFrage());
            frage.setAntwort1(updatedFrage.getAntwort1());
            frage.setAntwort2(updatedFrage.getAntwort2());
            frage.setAntwortrichtig(updatedFrage.getAntwortrichtig());
            FrageDAO.save(frage);
        }
    }

    private void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://www.se.hs-heilbronn.de:3306/BuGaSpiel?"
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
