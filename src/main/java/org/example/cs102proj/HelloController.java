package org.example.cs102proj;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

import java.util.*;

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
        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(new Human("Player1"));
        playerList.add(new Computer("Bot1"));
        playerList.add(new Computer("Bot2"));
        playerList.add(new Computer("Bot3"));
//
        GameMaster gm = new GameMaster(playerList);
//        gm.gameStart();
        System.out.println("game started");
    }
}