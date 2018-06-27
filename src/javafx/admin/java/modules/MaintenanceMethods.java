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
                //Alle Rallye Einträge auf den neuen mappen
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

    public void deleteKletterwand(Kletterwand kletterwand) throws SQLException {
        connect();
        PreparedStatement statement1 =
                connection.prepareStatement("DELETE FROM bugaspiel.kletterwand_route WHERE kletterwand=?");
        statement1.setString(1, kletterwand.getName());
        statement1.execute();

        PreparedStatement statement2 =
                connection.prepareStatement("DELETE FROM bugaspiel.kletterwand WHERE Name=?");
        statement2.setString(1, kletterwand.getName());
        statement2.execute();

        close();

    }

    public void updateKletterwand(Kletterwand oldKletterwand, Kletterwand updatedKletterwand) {
        /*
         * Wenn Name geändert wurde
         */
        try {
            KletterwandDAO.save(updatedKletterwand);
            connect();
//            preparedStatement = connection.prepareStatement("UPDATE bugaspiel.zeit SET KletterwandName=? WHERE KletterwandName=?");
//            preparedStatement.setString(1, updatedKletterwand.getName());
//            preparedStatement.setString(2, oldKletterwand.getName());
//            preparedStatement.execute();

            PreparedStatement anotherStatement =
                    connection.prepareStatement("UPDATE bugaspiel.kletterwand_route SET kletterwand=? WHERE kletterwand=?");
            anotherStatement.setString(1, updatedKletterwand.getName());
            anotherStatement.setString(2, oldKletterwand.getName());
            anotherStatement.execute();

            PreparedStatement statement2 = connection.prepareStatement("DELETE FROM bugaspiel.kletterwand WHERE Name=?");
            statement2.setString(1, oldKletterwand.getName());
            statement2.execute();

//            KletterwandDAO.delete(oldKletterwand);
        } catch (PersistentException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

    }

    public List<Kletterwand> listKletterwaende() {
        connect();

        try {
            preparedStatement = connection.prepareStatement("SELECT Name FROM bugaspiel.kletterwand");
            resultSet = preparedStatement.executeQuery();
            List<Kletterwand> result = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                Kletterwand wand = new Kletterwand();
                wand.setName(name);
                wand.setStartTag(name + "_start");
                wand.setEndTag(name + "_end");
                result.add(wand);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    /**
     * DONE
     **/
    public void deleteQuestion(Frage frage) throws SQLException, PersistentException {


        //Zufällige Frage wird als Ersatz für Frage in QRCode gewählt

        Frage[] fragen = FrageDAO.listFrageByQuery(null, null);
        int randomIndex = (int) Math.random() * (fragen.length - 1);
        Frage randomFrage = fragen[randomIndex];
        if (randomFrage.getFrage().equals(frage.getFrage())) {
            randomFrage = fragen[randomIndex + 1];
        }

        //Zufällige Frage wird eingesetzt
        QRCode[] qrCodes = QRCodeDAO.listQRCodeByQuery("FrageFrage='" + frage.getFrage() + "'", null);
        for (QRCode qrCode : qrCodes) {
            qrCode.setAufgabe(randomFrage);
            QRCodeDAO.save(qrCode);
        }

        //Alte Frage wird gelöscht
        FrageDAO.delete(frage);
    }

    /**
     * DONE
     **/
    public void updateQuestion(Frage oldFrage, Frage updatedFrage) throws PersistentException {
        if (!oldFrage.getFrage().equals(updatedFrage.getFrage())) {

            connect();
            try {
//                FrageDAO.save(updatedFrage);
                preparedStatement = connection.prepareStatement("UPDATE bugaspiel.frage SET Frage=? WHERE Frage=?");
                preparedStatement.setString(1, updatedFrage.getFrage());
                preparedStatement.setString(2, oldFrage.getFrage());
//                PreparedStatement statement2 = connection.prepareStatement("DELETE FROM bugaspiel.frage WHERE Frage=?");
//                statement2.setString(1, oldFrage.getFrage());
                preparedStatement.execute();
//                statement2.execute();


            } catch (SQLException e) {
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
        while (resultSet.next()) {
            String frage = resultSet.getString("Frage");
            result.add(frage);
        }
        close();
        return result;
    }

    public List<String> refreshKletterwand() throws SQLException {
        connect();
        preparedStatement = connection.prepareStatement("SELECT Name FROM bugaspiel.kletterwand");
        resultSet = preparedStatement.executeQuery();


        List<String> result = new ArrayList<>();
        while (resultSet.next()) {
            String frage = resultSet.getString("Name");
            result.add(frage);
        }
        close();
        return result;
    }

    public List<String> refreshQrcodes() throws SQLException {
        connect();
        preparedStatement = connection.prepareStatement("SELECT Name FROM bugaspiel.qrcode");
        resultSet = preparedStatement.executeQuery();


        List<String> result = new ArrayList<>();
        while (resultSet.next()) {
            String frage = resultSet.getString("Name");
            result.add(frage);
        }
        close();
        return result;
    }

    public List<ManagedUsers> listManageableUsers() throws SQLException {
        connect();
        preparedStatement = connection.prepareStatement("SELECT * FROM bugaspiel.benutzer");
        resultSet = preparedStatement.executeQuery();

        List<ManagedUsers> result = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("Username");
            String lastQR = resultSet.getString("letzterQRCode");
            String points = resultSet.getString("Punktzahl");
            String letzteFrage = resultSet.getString("letzteFrageBeantwortet");
            if (letzteFrage.equals("1")) {
                letzteFrage = "Ja";
            } else {
                letzteFrage = "Nein";
            }
            String profilePic = resultSet.getString("Profilbild");
            result.add(new ManagedUsers(name, lastQR, letzteFrage, points, profilePic));
        }
        close();
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

    public void deleteUser(ManagedUsers managedUser) throws SQLException {

        String username = managedUser.getUsername();

        connect();

        /** Für alle Tabellen in denen der Nutzer vorkommt, kann langfristig durch DB Constraints ersetzt werden**/

        PreparedStatement statement1 = connection.prepareStatement("DELETE FROM bugaspiel.benutzer_freunde WHERE Username=?");
        PreparedStatement statement2 = connection.prepareStatement("DELETE FROM bugaspiel.benutzer_freunde WHERE Freunde=?");
        PreparedStatement statement3 = connection.prepareStatement("DELETE FROM bugaspiel.benutzer_offeneanfragen WHERE Angefragter=?");
        PreparedStatement statement4 = connection.prepareStatement("DELETE FROM bugaspiel.benutzer_offeneanfragen WHERE AnfragenVon=?");
        PreparedStatement statement5 = connection.prepareStatement("DELETE FROM bugaspiel.zeit WHERE BenutzerUsername=?");
        PreparedStatement statement6 = connection.prepareStatement("DELETE FROM bugaspiel.kletterwand_route_bewertung WHERE benutzer=?");

        statement1.setString(1, username);
        statement2.setString(1, username);
        statement3.setString(1, username);
        statement4.setString(1, username);
        statement5.setString(1, username);
        statement6.setString(1, username);

        statement1.execute();
        statement2.execute();
        statement3.execute();
        statement4.execute();
        statement5.execute();
        statement6.execute();

        preparedStatement = connection.prepareStatement("DELETE FROM bugaspiel.benutzer WHERE Username=?");
        preparedStatement.setString(1, username);
        preparedStatement.execute();
        close();
    }

    public void createRoute(Kletterwand aktuelleKletterwand, String route) {
        try {
            connect();
            PreparedStatement statement1 =
                    connection.prepareStatement("INSERT INTO bugaspiel.kletterwand_route (id, kletterwand) VALUES (?, ?)");
            statement1.setString(1, route);
            statement1.setString(2, aktuelleKletterwand.getName());
            statement1.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void updateRoute(Kletterwand aktuelleKletterwand, String alteRoute, String neueRoute) {

        createRoute(aktuelleKletterwand, neueRoute);

        try {
            connect();
            PreparedStatement statement1 =
                    connection.prepareStatement("UPDATE bugaspiel.kletterwand_routen_bewertung SET kletterwand_route=? WHERE kletterwand_route=?");
            statement1.setString(1, neueRoute);
            statement1.setString(2, alteRoute);
            statement1.execute();

            PreparedStatement statement2 =
                    connection.prepareStatement("UPDATE bugaspiel.zeit SET KletterwandRoute=? WHERE KletterwandRoute=?");
            statement2.setString(1, neueRoute);
            statement2.setString(2, alteRoute);
            statement2.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

        deleteRoute(alteRoute);
    }

    public void deleteRoute(String route) {
        try {
            connect();
            PreparedStatement statement1 =
                    connection.prepareStatement("DELETE FROM bugaspiel.kletterwand_route WHERE id=?");
            statement1.setString(1, route);
            statement1.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public Frage pullFrage(String selectedQuestion) {

        connect();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM bugaspiel.frage WHERE Frage=?");
            preparedStatement.setString(1, selectedQuestion);
            ResultSet resultSet = preparedStatement.executeQuery();

            Frage result = new Frage();
            while (resultSet.next()) {
                String question = resultSet.getString("Frage");
                String antwort1 = resultSet.getString("Antwort1");
                String antwort2 = resultSet.getString("Antwort2");
                String antwortrichtig = resultSet.getString("Antwortrichtig");
                result.setFrage(question);
                result.setAntwort1(antwort1);
                result.setAntwort2(antwort2);
                result.setAntwortrichtig(antwortrichtig);
            }

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public List<QRCode> pullCodes() {

        connect();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM bugaspiel.qrcode");
            resultSet = preparedStatement.executeQuery();

            List<QRCode> result = new ArrayList<>();
            while (resultSet.next()) {
                QRCode code = new QRCode();
                code.setName(resultSet.getString("Name"));
                code.setAufgabe(FrageDAO.getFrageByORMID(resultSet.getString("FrageFrage")));

                if (resultSet.getString("QRCodeName") != null){
                    code.setNextQRCode(QRCodeDAO.getQRCodeByORMID(resultSet.getString("QRCodeName")));
                } else {
                    code.setNextQRCode(null);
                }
                code.setHinweis(resultSet.getString("Hinweis"));
                result.add(code);
            }

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch(PersistentException e){
            e.printStackTrace();
        } finally{
            close();
        }

        return null;
    }
}
