package org.example.cs102proj;

import java.util.*;

import static org.example.cs102proj.Card.Suit.*;

public class DiscardPile implements Deck{
    private ArrayList<Card> listOfCards = new ArrayList<>();
    private Card topCard;

    public void addCard(Card c){
        listOfCards.add(c);
        if(c.getValue() != 8){
            topCard = c;
        }else{
            Scanner sc = new Scanner(System.in);
            String suitName = sc.nextLine();
            Card.Suit suit = switch (suitName) {
                case ("DIAMONDS") -> DIAMONDS;
                case ("CLUBS") -> CLUBS;
                case ("HEARTS") -> HEARTS;
                case ("SPADES") -> SPADES;
                default -> c.getSuit();
            };
            //
            topCard = new Card(c.getValue(), suit);
        }
    }

    public Card getTopCard(){
        return topCard;
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
