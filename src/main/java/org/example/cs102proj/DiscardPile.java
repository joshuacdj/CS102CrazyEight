package org.example.cs102proj;

import java.util.*;

public class DiscardPile implements Deck{
    private ArrayList<Card> listOfCards = new ArrayList<>();
    private int topCardValue;
    private Suit topCardSuit;

    public void addCard(Card c){
        listOfCards.add(c);
    }

    public void setTopCardValue(Card c){
        topCardValue = c.getValue();
    }

    public void setTopCardSuit(Card c){
        //TO-DO handle 8's
        if(c.getValue() == 8){
            Scanner sc = new Scanner(System.in);
            String suitName = sc.nextLine();
            //
            switch(suitName){
                case("DIAMONDS"):
                    topCardSuit = Suit.DIAMONDS;
                    break;
                case("CLUBS"):
                    topCardSuit = Suit.CLUBS;
                    break;
                case("HEARTS"):
                    topCardSuit = Suit.HEARTS;
                    break;
                case("SPADES"):
                    topCardSuit = Suit.SPADES;
                    break;
            }
        }else{
            topCardSuit = c.getSuit();
        }
    }

    public int getTopCardValue(){
        return topCardValue;
    }

    public Suit getTopCardSuit(){
        return topCardSuit;
    }

    public ArrayList<Card> getCards(){
        return listOfCards;
    }

    @Override
    public void shuffleDeck(ArrayList<Card> cards) {
        Collections.shuffle(cards);
    }

    public void clearPile() {
        listOfCards.clear();
    }
}
