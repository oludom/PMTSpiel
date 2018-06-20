package javafx.admin.java.controllers;

import javafx.admin.java.modules.MaintenanceMethods;
import javafx.admin.java.modules.ManegedUsers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.orm.PersistentException;
import pmt.spielspaß.codegenerierung.Benutzer;
import pmt.spielspaß.codegenerierung.BenutzerDAO;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

public class ManageUsersController implements Initializable {
    public TableColumn usernameColumn;
    public TableColumn lastQRCodeColumn;
    public TableColumn lastQuestionColumn;
    public TableColumn pointsColumn;
    public TableColumn profilePictureLink;
    public TableView manageUsersTable;
    public Button deleteButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            ObservableList<ManegedUsers> allUsers = allUsersToManagedUsers();
            usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
            lastQRCodeColumn.setCellValueFactory(new PropertyValueFactory<>("lastQRCode"));
            lastQuestionColumn.setCellValueFactory(new PropertyValueFactory<>("lastQuestionAnswered"));
            pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
            profilePictureLink.setCellValueFactory(new PropertyValueFactory<>("profilePicLink"));

            manageUsersTable.setItems(allUsers);
    }

    private ObservableList<ManegedUsers> allUsersToManagedUsers() {
        try {
            MaintenanceMethods maintenanceMethods = new MaintenanceMethods();
            ObservableList<ManegedUsers> results = FXCollections.observableArrayList(maintenanceMethods.listManageableUsers());
            return results;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @FXML
    private void selectUser(){

    }

    @FXML
    private void deleteUser(){

    }
}
