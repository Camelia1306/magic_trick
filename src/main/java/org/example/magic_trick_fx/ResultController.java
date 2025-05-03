package org.example.magic_trick_fx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ResultController {
    @FXML private Label resultText;

    public void setResultText(String text) {
        resultText.setText(text);
    }

    @FXML
    private void closeWindow() {
        Stage stage = (Stage) resultText.getScene().getWindow();
        stage.close();
    }
}

