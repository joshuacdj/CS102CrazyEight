package org.example.cs102proj;
import java.util.ArrayList;

public class Round {
    private ArrayList<Player> playerPosition;

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
            remainingPile.getListOfCards().addFirst(startingCard);
            startingCard = remainingPile.getTopCard();
        }

        // add starting card to discard pile
        discardPile.addCard(startingCard);
    }

    public Round(ArrayList<Player> playerPosition) {
        // create new deck
        RemainingPile remainingPile = new RemainingPile();

        // Store the list of cards from remainingPile
        ArrayList<Card> cardList = remainingPile.getListOfCards();


        // shuffle deck
        remainingPile.shuffleDeck(cardList);


        // create new discard pile
        DiscardPile discardPile = new DiscardPile();

        // set the first playing card of the game
        setFirstCard(remainingPile, discardPile);

        // each of the 4 players draws 5 cards
        for (int i = 0; i < 5; i++) {
            for (Player p : playerPosition) {
                p.drawCard(remainingPile.getTopCard());
            }
        }

        // each player goes through their turns until the round ends this is going to take forever!
        while (!roundEnd(playerPosition)) {
            for (Player currentPlayer : playerPosition) {
                // current player makes his move
                // TODO: Implement player play himself
                Card cardPlayed = currentPlayer.play();
                if (cardPlayed == null) {
                    discardPile.addCard(cardPlayed);
                }

                // check if player's hand is 0
                if (roundEnd(playerPosition)) {
                    break;
                }
            }
        }

        // At the end of the round, we sum up the points of each player
        // Loop through each player
        for (Player p : playerPosition) {
            int totalPointsForRound = 0;

            // Loop through each card, add the point of each card into totalPointsForRound
            for (Card c : p.getHand()) {

                totalPointsForRound += c.calculatePoints();
            }

            // Sum up the total points for each player
            p.addPoints(totalPointsForRound);
        }



    }

    public boolean roundEnd(ArrayList<Player> playerPosition) {
        for (Player p : playerPosition) {
            if (p.getHand().isEmpty()) {
                return true;
            }
        }
        return false;
    }
}
