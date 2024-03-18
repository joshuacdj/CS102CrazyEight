package org.example.cs102proj;

import java.util.*;

public class GameMasterTest {
    public static void main(String[] args) {
        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(new Human("Player 1"));
        playerList.add(new Computer("Bot 1"));
        playerList.add(new Computer("Bot 1"));
        playerList.add(new Computer("Bot 1"));

        GameMaster gm = new GameMaster(playerList);
        gm.gameStart();
    }
}
