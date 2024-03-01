package org.example.cs102proj;

import java.util.ArrayList;

public class Human extends Player {

    public Human(ArrayList<Card> hand, String name) {
        super(hand, name);
    }

    @Override
    public Card action(Card card, RemainingPile deck) {
        // Check if card can be played by looking at the top of the discard pile. Use a try catch. Return InvalidCardException
        // If user chooses a wrong card

        // Remove the played card from the hand of the human
        removeCard(card);

        // Return the card that was played by the player so that it can be used
        return card;
    }
}
