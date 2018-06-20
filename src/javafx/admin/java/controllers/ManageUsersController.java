package javafx.admin.java.controllers;

import javafx.admin.java.modules.MaintenanceMethods;
import javafx.admin.java.modules.ManagedUsers;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManageUsersController implements Initializable {
    public TableColumn usernameColumn;
    public TableColumn lastQRCodeColumn;
    public TableColumn lastQuestionColumn;
    public TableColumn pointsColumn;
    public TableColumn profilePictureLink;
    public TableView manageUsersTable;
    public Button deleteButton;
    public Label statusUsermanagement;

    private ManagedUsers managedUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            ObservableList<ManagedUsers> allUsers = allUsersToManagedUsers();
            usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
            lastQRCodeColumn.setCellValueFactory(new PropertyValueFactory<>("lastQRCode"));
            lastQuestionColumn.setCellValueFactory(new PropertyValueFactory<>("lastQuestionAnswered"));
            pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));
            profilePictureLink.setCellValueFactory(new PropertyValueFactory<>("profilePicLink"));

            manageUsersTable.setItems(allUsers);
            manageUsersTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                    selectUser();
                }
            });
    }

    private ObservableList<ManagedUsers> allUsersToManagedUsers() {
        try {
            MaintenanceMethods maintenanceMethods = new MaintenanceMethods();
            ObservableList<ManagedUsers> results = FXCollections.observableArrayList(maintenanceMethods.listManageableUsers());
            return results;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @FXML
    private void selectUser(){
        ObservableList<TablePosition> test = manageUsersTable.getSelectionModel().getSelectedCells();
        if (test.size() > 0){
            int row = test.get(0).getRow();
            managedUser = (ManagedUsers) manageUsersTable.getItems().get(row);
            deleteButton.setDisable(false);
            statusUsermanagement.setTextFill(Color.BLACK);
            statusUsermanagement.setText("Ausgewählter Nutzer: "+managedUser.getUsername());
        }

    }

    @FXML
    private void deleteUser(){
        try {
            MaintenanceMethods maintenanceMethods = new MaintenanceMethods();
            maintenanceMethods.deleteUser(managedUser);
            refreshUserTable();
            statusUsermanagement.setTextFill(Color.GREEN);
            statusUsermanagement.setText("Nutzer "+managedUser.getUsername()+" erfolgreich gelöscht.");
        } catch (SQLException e) {
            statusUsermanagement.setTextFill(Color.RED);
            statusUsermanagement.setText("Es ist ein Fehler bei der Datenbankabfrage aufgetreten.");
        }
    }

    private void refreshUserTable() {
        manageUsersTable.getItems().clear();
        manageUsersTable.setItems(allUsersToManagedUsers());
        deleteButton.setDisable(true);
        statusUsermanagement.setText("");
    }
}
