package org.example.cs102proj;

import java.util.ArrayList;

public class Computer extends Player{
    public Computer(ArrayList<Card> hand, String name) {
        super(hand, name);
    }

    public Card playCard(Card card) {
//        check if there are playable cards in hand
        if (isPlayable(getHand(), //TODO: discard pile)) 
//        if not draw card
//        check again if there are playable cards
//        until draw 5
        return null;
    }

    public boolean isPlayable (ArrayList<Card> hand, int topCardValue, Card.Suit topCardSuit) {
//        check if can play card of same value
        boolean hasValue = false;
        for (Card i: hand) {
            if (i.getValue() == topCardValue) {hasValue = true;}
        }
//        check if can play card of same suit
        boolean hasSuit = false;
        for (Card i: hand) {
            if (i.getSuit() == topCardSuit) {
                hasSuit = true;
            }
        }
//        check if can play 8
        boolean has8 = false;
        for (Card i: hand) {
            if (i.getValue() == 8) {
                has8 = true;
            }
        }
        return hasValue || hasSuit || has8;
    }

}
