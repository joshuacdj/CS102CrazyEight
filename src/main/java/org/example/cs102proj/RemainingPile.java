package org.example.cs102proj;

import java.util.*;
import java.util.Collections;

public class RemainingPile implements Deck{
    private ArrayList<Card> listOfCards;

    public void setPile(ArrayList<Card> listOfCards){
        this.listOfCards = listOfCards;
        this.shuffleDeck(listOfCards);
    }

    public void shuffleDeck(ArrayList<Card> listOfCards){
        Collections.shuffle(listOfCards);
    }

    public Card drawCard(ArrayList<Card> listOfCards){
        if(getNoOfCardsRemaining() == 0){
            //attain top card (i.e. last of list)
            Card c = listOfCards.getLast();
            //remove card from the RemainingPile
            listOfCards.removeLast();
            return c;
        }else {
            this.setPile(DiscardPile.getCards());
            return this.drawCard(listOfCards);
        }
    }

    public int getNoOfCardsRemaining(){
        return listOfCards.size();
    }
}
