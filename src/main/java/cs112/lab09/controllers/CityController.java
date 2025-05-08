package cs112.lab09.controllers;

import cs112.lab09.models.RevisedHistoricalEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;


public class CityController {

    @FXML
    private Button closeButton;

    @FXML
    private Label locationLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label revisedDescriptionLabel;

    @FXML
    private Label citationLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private void handleCloseButton() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    };


    public void initData(RevisedHistoricalEvent event) {
        locationLabel.setText(event.getLocation());
        dateLabel.setText(event.getEventDay().toString());
        descriptionLabel.setText(event.getDescription());
        revisedDescriptionLabel.setText(event.getRevisedDescription());
        citationLabel.setText(event.getCitation());

        // Try loading the image
        String imagePath = "/cs112/lab09/images/" + event.getImageName();
        System.out.println("Trying to load image: " + imagePath);
        try {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            imageView.setImage(image);
        } catch (Exception e) {
            System.out.println("Failed to load image: " + imagePath);
            e.printStackTrace();
        }

    }

}


