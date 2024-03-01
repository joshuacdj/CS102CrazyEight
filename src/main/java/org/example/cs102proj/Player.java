package org.example.cs102proj;

import java.util.*;

public abstract class Player {

    // Each player will have a hand, a name and their total points for a game
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<Card> playableCards = new ArrayList<>();
    private String name;
    private int points;

    public Player(ArrayList<Card> hand, String name) {
        this.hand = hand;
        this.name = name;
        // All players should have 0 points initially
        this.points = 0;
    }

    // Return the current hand of the player
    public ArrayList<Card> getHand() {
        return hand;
    }

    // Remove the card from current hand
    public void removeCard(Card card) {
        hand.remove(card);
    }

//    returns card if player plays a card, else returns false if player skips turn (drew 5 cards)
    public abstract Card action(Card card, RemainingPile deck);

    // Draw a card from the deck
    public void drawCard(Card card) {
        hand.add(card);
    }

    // Add points to the player depending on the value of the cards left in their hand at the end of a round
    public void addPoints(int points) {
        this.points += points;
    }

    // Return the points accumulated by the player in total for that game
    public int getPoints() {
        return points;
    }

    // Return name of player
    public String getName() {
        return name;
    }

    // Calculate the points in player's hand
    public int calculatePoints() {
        int points = 0;
        for (Card c : hand) {
            points += c.calculatePoints();
        }
        return points;
    }

//    how card is deemed playable
    public boolean isPlayable (Card currCard, Card topCard) {
        if (currCard.getValue() == topCard.getValue()) {
            return true;
        } else if (currCard.getSuit() == topCard.getSuit()) {
            return true;
        } else return currCard.getValue() == 8;
    }

    //    create playable cards list
    public void setPlayableCards (Card topCard) {
        for (Card card : getHand()) {
            if (isPlayable(card, topCard)) {
                playableCards.add(card);
            }
        }
    }

    public ArrayList<Card> getPlayableCards() {
        return playableCards;
    }

    @Override
    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            for (Card c : hand) {
                sb.append(c).append(", ");
            }

            return sb.toString();
        } catch (NullPointerException e) {
            System.out.println("No cards in hand!");
        }

        return "";
    }
}