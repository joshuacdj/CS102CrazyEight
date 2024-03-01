package org.example.cs102proj;

import java.util.*;
import java.util.Collections;


import java.util.*;
import java.util.Collections;

public class RemainingPile implements Deck{
    private ArrayList<Card> listOfCards;

    public RemainingPile() {
        listOfCards = new ArrayList<>();

        for (int i = 1; i <= 13; i++) {

            for (Suit suit : Suit.values()) {

                listOfCards.add(new Card(i, suit));
            }
        }
    }

    public void setPile(ArrayList<Card> listOfCards){
        this.listOfCards = listOfCards;
        this.shuffleDeck(listOfCards);
    }

    @Override
    public void shuffleDeck(ArrayList<Card> listOfCards){
        Collections.shuffle(listOfCards);
    }

    public Card getTopCard(ArrayList<Card> listOfCards){
        //attain top card (i.e. last of list)
        Card c = listOfCards.getLast();
        //remove card from the RemainingPile
        listOfCards.removeLast();
        return c;
    }

    public int getNoOfCardsRemaining(){
        return listOfCards.size();
    }

}
