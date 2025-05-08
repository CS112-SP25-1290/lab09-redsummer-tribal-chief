package cs112.lab09.controllers;

import cs112.lab09.models.Date;
import cs112.lab09.models.RevisedHistoricalEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MapController {

    @FXML
    private Button bisbeeAzButton, sanFranciscoButton;

    @FXML
    private void handleBisbeeButton(ActionEvent event) {
        openCityPopup(new RevisedHistoricalEvent(
                "bisbee.jpg", "Bisbee, Arizona", "Bisbee description...",
                new Date("01/01/1900"), "Revised description", "Citation for Bisbee"
        ));
    }

    @FXML
    private void handleSanFranciscoButton(ActionEvent event) {
        openCityPopup(new RevisedHistoricalEvent(
                "sf.jpg", "San Francisco", "San Francisco description...",
                new Date("01/01/1900"), "Revised description", "Citation for SF"
        ));
    }

    private void openCityPopup(RevisedHistoricalEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/cs112/lab09/city-view.fxml"));
            Parent root = loader.load();

            CityController controller = loader.getController();
            controller.initData(event);

            Stage popup = new Stage();
            popup.setTitle(event.getLocation());
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.setScene(new Scene(root));
            popup.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to open city popup window.");
        }
    }
}
