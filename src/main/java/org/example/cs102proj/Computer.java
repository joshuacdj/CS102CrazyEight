package org.example.cs102proj;

import java.util.*;

public class Computer extends Player {


    public Computer(ArrayList<Card> hand, String name) {
        super(hand, name);
    }

    public ArrayList<Object> action(Card lastPlayedCard, DrawPile deck) {
        int cardsDrawn = 0;
        ArrayList<Object> output = new ArrayList<>();
//        set list of playable cards
        setPlayableCards(lastPlayedCard);
//        check if there are no playable cards in hand
        while (getPlayableCards().isEmpty() && cardsDrawn < 5) {
            drawCard(deck.getTopCard());
            setPlayableCards(lastPlayedCard);
            cardsDrawn++;
        }
        System.out.println(getHand());
//        check if player drew 5 cards
        if (cardsDrawn <= 5) {
//            choose to discard the card worth the most points
//            if 8 present, return 8 and choose suit which is most common in hand
            for (Card card : getPlayableCards()) {
                if (card.getValue() == 8) {
                    removeCard(card);
//                    find which suit is most common in computer's hand
                    HashMap<Suit, Integer> suitCount = new HashMap<>();
                    suitCount.put(Suit.DIAMONDS, 0);
                    suitCount.put(Suit.CLUBS, 0);
                    suitCount.put(Suit.HEARTS, 0);
                    suitCount.put(Suit.SPADES, 0);
                    for (Card c: getHand()) {
                        if (c.equals(card)) { break; } // exclude current 8 card from suit count
                        suitCount.put(c.getSuit(), suitCount.get(c.getSuit()) + 1);
                    }
                    Suit desiredSuit = Collections.max(suitCount.entrySet(), HashMap.Entry.comparingByValue()).getKey();
                    output.add(card);
                    output.add(desiredSuit);
                    return output;
                }
            }
//            else choose highest face value card
            Card cardWithHighestPoints = Collections.max(getPlayableCards(), new CardCompare());
            removeCard(cardWithHighestPoints);
            output.add(cardWithHighestPoints);
            output.add(cardWithHighestPoints.getSuit());
            return output;
        }
        return null;
    }
}

