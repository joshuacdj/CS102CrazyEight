package org.example.cs102proj;

import javafx.scene.image.Image;
import java.util.*;
import java.util.Collections;

public class DrawPile implements Deck{
    private ArrayList<Card> listOfCards;

    public DrawPile() {
        listOfCards = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            for (Suit suit : Suit.values()) {
                Card cardToAdd = new Card(i, suit);
                String filename = cardToAdd.getValue() + "_of_" + cardToAdd.getSuit();
                cardToAdd.setImage(new Image( "./images/" + filename));
                listOfCards.add(cardToAdd);
            }
        }
        Image back_card = new Image("./images/back_card");
    }

    public Card getCard(){
        return listOfCards.getFirst();
    }

    public void add(Card c){
        listOfCards.add(c);
    }

    @Override
    public void shuffleDeck(){
        Collections.shuffle(listOfCards);
    }

    public Card getTopCard(){
        //attain top card (i.e. last of list)
        Card c = listOfCards.getLast();
        //remove card from the DrawPile
        listOfCards.removeLast();
        return c;
    }

    public int getNoOfCardsRemaining(){
        return listOfCards.size();
    }

    public ArrayList<Card> getListOfCards() {
        return listOfCards;
    }
}
