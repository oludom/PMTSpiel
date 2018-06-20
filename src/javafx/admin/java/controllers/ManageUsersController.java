package javafx.admin.java.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.orm.PersistentException;
import pmt.spielspaß.codegenerierung.Benutzer;
import pmt.spielspaß.codegenerierung.BenutzerDAO;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageUsersController implements Initializable {
    public TableColumn usernameColumn;
    public TableColumn lastQRCodeColumn;
    public TableColumn lastQuestionColumn;
    public TableColumn pointsColumn;
    public TableColumn profilePictureLink;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Benutzer[] alleNutzer = BenutzerDAO.listBenutzerByQuery(null, null);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void delete(){

    }
}
