package org.example.cs102proj;

import java.util.ArrayList;
import java.util.Collections;

public class Computer extends Player {


    public Computer(ArrayList<Card> hand, String name) {
        super(hand, name);
    }

    public Card action(Card lastPlayedCard, DrawPile deck) {
        int cardsDrawn = 0;
//        set list of playable cards
        setPlayableCards(lastPlayedCard);
        System.out.println(getPlayableCards());
//        check if there are playable cards in hand
        while (getPlayableCards().isEmpty() && cardsDrawn < 5) {
            System.out.println(cardsDrawn);
            drawCard(deck.getTopCard());
            setPlayableCards(lastPlayedCard);
            cardsDrawn++;
        }
//        check if player drew 5 cards
        if (cardsDrawn <= 5) {
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

