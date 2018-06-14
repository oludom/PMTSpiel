package javafx.admin.java.controllers;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import pmt.spielspaß.codegenerierung.Frage;
import pmt.spielspaß.codegenerierung.FrageDAO;

import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class CreateQuestionController implements Initializable {

    public TextArea question;
    public TextArea rightAnswer;
    public TextArea answer2;
    public TextArea answer1;
    public Button saveQuestion;
    public Label questionStatus;

    public CreateQuestionController() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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

                    FrageDAO.save(frage);
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

    private void reset() {
        question.setText("");
        answer1.setText("");
        answer2.setText("");
        rightAnswer.setText("");
    }
}
