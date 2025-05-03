package org.example.magic_trick_fx;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

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
            promptLabel.setText("✨ You thought of: " + number + " ✨");
            inputField.setVisible(false);
            resultLabel.setVisible(true);
        });
        pause.play();
    }
}
