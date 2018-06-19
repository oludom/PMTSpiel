package javafx.admin.java.controllers;

import javafx.admin.java.modules.MaintenanceMethods;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import org.orm.PersistentException;
import pmt.spielspaß.codegenerierung.Frage;
import pmt.spielspaß.codegenerierung.FrageDAO;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class EditQuestionController implements Initializable {

    @FXML
    public Button deleteQuestion;
    @FXML
    public Button saveQuestion;
    @FXML
    public Label questionStatus;
    @FXML
    public TextArea rightAnswer;
    @FXML
    public TextArea answer2;
    @FXML
    public TextArea answer1;
    @FXML
    public TextArea question;
    @FXML
    public ChoiceBox questionList;

    private Frage currentQuestion;

    public EditQuestionController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refreshChoiceBox();
        questionList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                fillInputfields((String) questionList.getSelectionModel().getSelectedItem());
            }
        });
    }

    private void fillInputfields(String selectedQuestion) {
        try {
            Frage frage = FrageDAO.getFrageByORMID(selectedQuestion);
            currentQuestion = frage;
            question.setText(frage.getFrage());
            answer1.setText(frage.getAntwort1());
            answer2.setText(frage.getAntwort2());
            rightAnswer.setText(frage.getAntwortrichtig());
        } catch (PersistentException e) {
            questionStatus.setTextFill(Color.RED);
            questionStatus.setText("Es gab ein Problem mit der Frage: " + e.getMessage());
        }

    }

    public void save(ActionEvent actionEvent) {
        if (
                !question.getText().equals("") &&
                        !rightAnswer.getText().equals("") &&
                        !answer1.getText().equals("") &&
                        !answer2.getText().equals("")
                ) {

            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {

                    Frage frage = FrageDAO.createFrage();

                    frage.setFrage(question.getText());
                    frage.setAntwort1(answer1.getText());
                    frage.setAntwort2(answer2.getText());
                    frage.setAntwortrichtig(rightAnswer.getText());

                    MaintenanceMethods maintenance = new MaintenanceMethods();
                    maintenance.updateQuestion(currentQuestion, frage);

                    Platform.runLater(() -> {
                        questionStatus.setText("Frage erfolgreich gespeichert.");
                        questionStatus.setTextFill(Color.GREEN);
                        reset();
                    });
                    return null;
                }

            };
            Thread th = new Thread(task);

            th.setDaemon(true);

            th.start();
        } else {
            questionStatus.setText("Bitte alle Felder ausfüllen.");
            questionStatus.setTextFill(Color.RED);
        }
    }

    public void delete(ActionEvent actionEvent) {
        try {
            MaintenanceMethods maintenance = new MaintenanceMethods();
            maintenance.deleteQuestion(currentQuestion);
            reset();
            questionStatus.setTextFill(Color.GREEN);
            questionStatus.setText("Frage erfolgreich gelöscht.");
        } catch (SQLException e) {
            questionStatus.setTextFill(Color.RED);
            questionStatus.setText("Es gab ein Problem mit der Datenbank: " + e.getMessage());
        } catch (PersistentException e) {
            questionStatus.setTextFill(Color.RED);
            questionStatus.setText("Es ist ein Problem aufgetreten: " + e.getMessage());
        }
    }

    private void reset() {
        question.setText("");
        answer1.setText("");
        answer2.setText("");
        rightAnswer.setText("");
        questionList.getSelectionModel().selectFirst();
    }

    private void refreshChoiceBox() {
        try {
            questionList.getItems().clear();
            Frage[] fragen = FrageDAO.listFrageByQuery(null, null);
            for (int i = 0; i < fragen.length; i++) {
                questionList.getItems().add(fragen[i].getFrage());
            }
        } catch (PersistentException e) {
            questionStatus.setTextFill(Color.RED);
            questionStatus.setText("Es ist ein Fehler aufgetreten: " + e.getMessage());
        }
    }
}
