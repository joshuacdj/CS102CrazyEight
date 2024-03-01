package org.example.cs102proj;

import java.util.ArrayList;
import java.util.Collections;

public class Computer extends Player{
    private ArrayList<Card> playableCards = new ArrayList<>();
    public Computer(ArrayList<Card> hand, String name) {
        super(hand, name);
    }

    public Card playCard(Card topCard, RemainingPile deck) {
        int cardsDrawn = 0;
        Card cardPlayed = null;
//        set list of playable cards
        setPlayableCards(topCard);
//        check if there are playable cards in hand
        while (!(playableCards.contains(topCard)) || cardsDrawn < 5) {
            drawCard(deck.drawCard());
            cardsDrawn++;
        }
        if (cardsDrawn < 5) {
//            choose to discard the card worth the most points
            for (Card card : playableCards) {
                if (card.getValue() == 8) {
                    return card;
                }
                return Collections.max(playableCards, new CardCompare());
            }
        }
        return cardPlayed;
    }

//    create playable cards list
    public void setPlayableCards (Card topCard) {
        for (Card card : getHand()) {
            if (isPlayable(card, topCard)) {
                playableCards.add(card);
            }
        }
    }

    public boolean isPlayable (Card currCard, Card topCard) {
        if (currCard.getValue() == topCard.getValue()) {
            return true;
        } else if (currCard.getSuit() == topCard.getSuit()) {
            return true;
        } else if (currCard.getValue() == 8) {
            return true;
        }
        return false;
    }
}
