package org.example.cs102proj;
import java.util.ArrayList;

public class Round {
    private ArrayList<Player> playerPosition;
    private int roundNumber = 1;

    // setter for player position
    public void setPlayerPosition(ArrayList<Player> playerPosition) {
        // Get the player who went first
        Player first = playerPosition.getFirst();

        // Remove that player from the arraylist
        playerPosition.removeFirst();

        // Move the player to the end
        playerPosition.add(first);
    }

    // set the first card of the round
    public void setFirstCard(RemainingPile remainingPile, DiscardPile discardPile) {
        // obtain starting card
        Card startingCard = remainingPile.getTopCard();

        // if starting card drawn is 8, put it back into the pile and draw a new starting card
        while (startingCard.getValue() == 8) {
            remainingPile.add(0, startingCard);
            startingCard = remainingPile.getTopCard();
        }

        // add starting card to discard pile
        discardPile.addCard(startingCard);
    }

    public Round(ArrayList<Player> playerPosition) {
        // create new deck
        RemainingPile remainingPile = new RemainingPile();

        // (TO DO!) add the 52 cards to the new deck
        remainingPile.addCards();

        // shuffle deck
        remainingPile.shuffleDeck();

        // from round 2 onwards, move player positions down one to change dealer
        // since in round 1, the dealer is set to be the player
        if (roundNumber != 1) {
            setPlayerPosition(playerPosition);
        }

        // create new discard pile
        DiscardPile discardPile = new DiscardPile();

        // set the first playing card of the game
        setFirstCard(remainingPile, discardPile);

        // each of the 4 players draws 5 cards
        for (int i = 0; i < 5; i++) {
            for (Player p : playerPosition) {
                p.drawCard();
            }
        }

        // each player goes through their turns until the round ends this is going to take forever!
        while (!roundEnd(playerPosition)) {
            for (Player currentPlayer : playerPosition) {
                // current player makes his move
                currentPlayer.play();

                // check if player's hand is 0
                if (roundEnd(playerPosition)) {
                    break;
                }
            }
        }

        // update round number to move to next round
        roundNumber++;

    }

    public boolean roundEnd(ArrayList<Player> playerPosition) {
        for (Player p : playerPosition) {
            if (p.getHand().size() == 0) {
                return true;
            }
        }
        return false;
    }
}
