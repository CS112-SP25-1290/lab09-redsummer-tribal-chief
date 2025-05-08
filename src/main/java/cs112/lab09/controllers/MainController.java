package cs112.lab09.controllers;

import cs112.lab09.RedSummer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

import static cs112.lab09.Constants.*;

public class MainController {
    @FXML
    private Button startButton;

    @FXML
    private void handleStartButton(ActionEvent event) {
        System.out.println("Start button clicked");

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cs112/lab09/map-view.fxml"));
            Scene mapScene = new Scene(loader.load());
            Stage stage = (Stage) startButton.getScene().getWindow();
            stage.setScene(mapScene);
            stage.setTitle("Red Summer Map");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleExitButton(ActionEvent event) {
        System.exit(0);
    }


}