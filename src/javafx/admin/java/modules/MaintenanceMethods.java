package javafx.admin.java.modules;

import org.orm.PersistentException;
import pmt.spielspaß.codegenerierung.*;


import java.sql.*;
import java.util.ArrayList;
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
            connect();
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

    /** DONE **/
    public void deleteQuestion(Frage frage) throws SQLException, PersistentException {



        //Zufällige Frage wird als Ersatz für Frage in QRCode gewählt

        Frage[] fragen = FrageDAO.listFrageByQuery(null, null);
        int randomIndex = (int) Math.random()*(fragen.length-1);
        Frage randomFrage = fragen[randomIndex];
        if (randomFrage.getFrage().equals(frage.getFrage())){
            randomFrage = fragen[randomIndex+1];
        }

        //Zufällige Frage wird eingesetzt
        QRCode[] qrCodes = QRCodeDAO.listQRCodeByQuery("FrageFrage='"+frage.getFrage()+"'", null);
        for (QRCode qrCode : qrCodes) {
            qrCode.setAufgabe(randomFrage);
            QRCodeDAO.save(qrCode);
        }

        //Alte Frage wird gelöscht
        FrageDAO.delete(frage);
    }

    /** DONE **/
    public void updateQuestion(Frage oldFrage, Frage updatedFrage) throws PersistentException {
        if (!oldFrage.getFrage().equals(updatedFrage.getFrage())) {

            try {
                FrageDAO.save(updatedFrage);

                QRCode[] qrCodes = QRCodeDAO.listQRCodeByQuery("FrageFrage='"+oldFrage.getFrage()+"'", null);
                for (QRCode qrCode : qrCodes) {
                    qrCode.setAufgabe(updatedFrage);
                    QRCodeDAO.save(qrCode);
                }

                FrageDAO.delete(FrageDAO.getFrageByORMID(oldFrage.getFrage()));

            } catch (PersistentException e) {
                e.printStackTrace();
            } finally {
                close();
            }

        } else {
            Frage frage = FrageDAO.getFrageByORMID(oldFrage.getFrage());
            frage.setAntwort1(updatedFrage.getAntwort1());
            frage.setAntwort2(updatedFrage.getAntwort2());
            frage.setAntwortrichtig(updatedFrage.getAntwortrichtig());
            FrageDAO.save(frage);
        }
    }

    public List<String> refreshQuestions() throws SQLException {
        connect();
        preparedStatement = connection.prepareStatement("SELECT Frage FROM bugaspiel.frage");
        resultSet = preparedStatement.executeQuery();

        List<String> result = new ArrayList<>();
        while(resultSet.next()){
            String frage = resultSet.getString("Frage");
            result.add(frage);
        }
        return result;
    }

    public List<String> refreshKletterwand() throws SQLException{
        connect();
        preparedStatement = connection.prepareStatement("SELECT Name FROM bugaspiel.kletterwand");
        resultSet = preparedStatement.executeQuery();

        List<String> result = new ArrayList<>();
        while(resultSet.next()){
            String frage = resultSet.getString("Name");
            result.add(frage);
        }
        return result;
    }

    public List<String> refreshQrcodes() throws SQLException{
        connect();
        preparedStatement = connection.prepareStatement("SELECT Name FROM bugaspiel.qrcode");
        resultSet = preparedStatement.executeQuery();

        List<String> result = new ArrayList<>();
        while(resultSet.next()){
            String frage = resultSet.getString("Name");
            result.add(frage);
        }
        return result;
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
