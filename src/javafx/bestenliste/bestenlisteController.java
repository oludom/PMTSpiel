package javafx.bestenliste;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.orm.PersistentException;
import pmt.spielspaß.codegenerierung.*;
import javafx.collections.ObservableList;

import java.net.URL;
import java.util.ResourceBundle;

public class bestenlisteController implements Initializable {

    @FXML
    public ComboBox cboxKletterwand;

    @FXML
    public TableView tblHighscores;
    @FXML
    public TableColumn clmZeit;
    @FXML
    public TableColumn clmSpieler;
    @FXML
    public TableColumn clmDatum;

    @FXML
    public TableColumn clmPlatz;
    @FXML
    public TextField txtSuche;
    @FXML
    public Button btnResetList;

    ObservableList<Rekord> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //combobox füllen und erste hightscore liste laden
        data = FXCollections.observableArrayList();

        clmPlatz.setCellValueFactory(new PropertyValueFactory<Rekord, String>("Platz"));
        clmZeit.setCellValueFactory(new PropertyValueFactory<Rekord, String>("Zeit"));
        clmSpieler.setCellValueFactory(new PropertyValueFactory<Rekord, String>("Spieler"));
        clmDatum.setCellValueFactory(new PropertyValueFactory<Rekord, String>("Datum"));

        try {
            Kletterwand[] kletterwaende = KletterwandDAO.listKletterwandByQuery(null, "Name");
            for (Kletterwand wand: kletterwaende) {

                cboxKletterwand.getItems().add(wand.getName());

            }

            cboxKletterwand.setValue(cboxKletterwand.getItems().get(0));
            Zeit[] zeiten = ZeitDAO.listZeitByQuery("KletterwandName = '" + cboxKletterwand.getValue().toString() + "'", "GemesseneZeit");
            int platz = 1;
            for (Zeit zeit: zeiten) {
                data.add(new Rekord(platz,String.valueOf(zeit.getGemesseneZeit()), zeit.getBugaBesucher().username.toString(), zeit.getDatum().toString()));
                platz++;
            }

            tblHighscores.setItems(data);

        } catch (PersistentException e) {
            Alert errBox = new Alert(Alert.AlertType.ERROR);
            errBox.setTitle("Datenbankverbindung nicht möglich");
            errBox.setHeaderText(null);
            errBox.setContentText("Derzeit ist eine Verbindung zum Datenbankserver nicht möglich. Bitte versuchen Sie es später noch einmal.");
            errBox.show();
        }
    }

    public void cboxKletterwand_IndexChanged(ActionEvent actionEvent) {

        try {

            Kletterwand aktuelleWand = KletterwandDAO.getKletterwandByORMID(cboxKletterwand.getValue().toString());


//            Zeit[] zeiten = aktuelleWand.zeits.toArray();
//            Zeit[] zeiten = ZeitDAO.listZeitByQuery(
//                    "ID in (Select id from (select id, min(GemesseneZeit) as Bestzeit, BenutzerUsername " +
//                    "from zeit where KletterwandName = '"+ aktuelleWand.getName() + "' group by BenutzerUsername) as tbl1)", "GemesseneZeit");
//            select min(GemesseneZeit) as Bestzeit, BenutzerUsername
//            from zeit
//            group by BenutzerUsername;

            Zeit[] zeiten = ZeitDAO.listZeitByQuery("KletterwandName = '" + aktuelleWand.getName() + "'", "GemesseneZeit" );

            data.clear();
            int platz = 1;
            for (Zeit zeit: zeiten) {
            //    listHighscores.getItems().add(zeit.getGemesseneZeit().toString() + " : " + zeit.getBugaBesucher().username + " am " + zeit.getDatum().toString());
                data.add(new Rekord(platz, String.valueOf(zeit.getGemesseneZeit()), zeit.getBugaBesucher().username, zeit.getDatum().toString()));
                platz++;
            }


            tblHighscores.setItems(data);

        } catch (PersistentException e) {
            e.printStackTrace();
        }

    }

    public void txtSuche_InputChanged(ActionEvent actionEvent) {

        String value = txtSuche.getText().toLowerCase();
        ObservableList<Object> subentries = FXCollections.observableArrayList();

        if (value.trim().isEmpty()){
            resetHighscoreFilter();
            return;
        }

        long count = tblHighscores.getColumns().stream().count();
        for (int i = 0; i < tblHighscores.getItems().size(); i++) {
            for (int j = 0; j < count; j++) {
                String entry = "" + ((TableColumn) tblHighscores.getColumns().get(j)).getCellData(i);
                if (entry.toLowerCase().contains(value)) {
                    subentries.add(tblHighscores.getItems().get(i));
                    break;
                }
            }
        }

        if(subentries.isEmpty()){
            Alert errBox = new Alert(Alert.AlertType.ERROR);
            errBox.setTitle("Fehler beim Suchen");
            errBox.setHeaderText(null);
            errBox.setContentText("Mit dem Suchparameter '" +  txtSuche.getText() + "' konnten keine Ergebnisse gefunden werden.");
            errBox.show();

            resetHighscoreFilter();
            return;
        }

        tblHighscores.setItems(subentries);
    }

    public void btnResetList_Click(ActionEvent actionEvent) {
        resetHighscoreFilter();
    }

    private void resetHighscoreFilter(){
        txtSuche.clear();
        tblHighscores.setItems(data);
    }
}



