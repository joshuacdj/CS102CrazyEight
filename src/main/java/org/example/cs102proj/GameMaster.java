package org.example.cs102proj;

import java.lang.reflect.Array;
import java.util.ArrayList;
public class GameMaster {

    private ArrayList<Player> listOfPlayers;
    private final int maximumPoints = 100;

    GameMaster(ArrayList<Player> listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }

    public ArrayList<Player> getListOfPlayers() {
        return listOfPlayers;
    }

    //Checks if game has ended by checking if
    //any player has >= maximumPoints allowed
    boolean gameEnd() {

        //Initialise end to false
        boolean end = false;

        //Loop for all players playing
        for (Player currentPlayer : listOfPlayers) {

            //If the current player's score exceeds the maximum allowed, game will end
            if (currentPlayer.getPoints >= maximumPoints) {
                return true;
            }
        }

        return end;
    }
}
