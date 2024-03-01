package org.example.cs102proj;

import java.util.ArrayList;
import java.util.Collections;

public class Computer extends Player {


    public Computer(ArrayList<Card> hand, String name) {
        super(hand, name);
    }

    public Card action(Card topCard, RemainingPile deck) {
        int cardsDrawn = 0;
//        set list of playable cards
        setPlayableCards(topCard);
//        check if there are playable cards in hand
        while (!(getPlayableCards().contains(topCard)) && cardsDrawn < 5) {
            drawCard(deck.getTopCard());
            cardsDrawn++;
        }
        if (cardsDrawn < 5) {
            //            choose to discard the card worth the most points
            for (Card card : getPlayableCards()) {
                if (card.getValue() == 8) {
                    removeCard(card);
                    return card;
                }
                Card cardWithHighestPoints = Collections.max(getPlayableCards(), new CardCompare());
                removeCard(cardWithHighestPoints);
                return cardWithHighestPoints;
            }
        }
        return null;
    }
}

