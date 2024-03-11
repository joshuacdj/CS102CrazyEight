package org.example.cs102proj;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void draw(ActionEvent e) {
        System.out.println("draw card");
    }

    public void onStartGameClick(ActionEvent e) {
        System.out.println("start game");
    }
}