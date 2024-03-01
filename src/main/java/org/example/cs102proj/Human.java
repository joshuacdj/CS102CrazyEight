package org.example.cs102proj;

import java.util.*;

public class Human {

    private ArrayList<Card> hand = new ArrayList<>();
    private String name;

    public Human(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
    // Return the current hand of the player

    public Card playCard(Card card) {
        // Remove the card from current hand
        hand.remove(card);
        return card;
    }

    public void drawCard(Card card) {
        hand.add(card);
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