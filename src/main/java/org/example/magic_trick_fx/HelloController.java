package org.example.magic_trick_fx;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloController {

    @FXML private StackPane rootPane;
    @FXML private TextField inputField;
    @FXML private Label promptLabel;
    @FXML private Button magicButton;
    @FXML private Label resultLabel;

    @FXML
    protected void onRevealButtonClick() {
        String number = inputField.getText();
        promptLabel.setText("Reading your mind...");
        magicButton.setDisable(true);

        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("result-view.fxml"));
                Scene resultScene = new Scene(loader.load());

                // Pass the result to the result controller
                ResultController controller = loader.getController();
                controller.setResultText("✨ You thought of: " + number + " ✨");

                Stage popupStage = new Stage();
                popupStage.setTitle("Your Number Is...");
                popupStage.setScene(resultScene);
                popupStage.setResizable(false);
                popupStage.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        pause.play();
    }

}
