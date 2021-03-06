package sample;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.animations.Scale;
import sample.animations.Shake;
import sample.animations.ShakeUpDown;

public class Newcard extends GeneralForNewCards{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea wordInput;

    @FXML
    private TextArea exampleInput;

    @FXML
    private TextArea translationInput;

    @FXML
    private Button addNewCard;

    @FXML
    private Button backButton;

    @FXML
    private Label wordLabel;

    @FXML
    private Label exampleLabel;

    @FXML
    private Label translationLabel;



    @FXML
    void goBack(ActionEvent event) throws IOException {
        Stage stagee = new Stage();
        Pane layout = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stagee.setScene(new Scene(layout));
        stagee.show();
        Stage stage = (Stage) wordInput.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        addNewCard.setOnAction(e -> {
            try {
                addToFile("b1Words.txt");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        addNewCard.setOnMouseClicked(e -> {
            scaleButton();
        });

    }

    private void scaleButton(){
        Scale sc = new Scale(addNewCard);
        sc.PlayAnim();
    }
}