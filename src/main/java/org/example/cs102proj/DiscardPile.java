package org.example.cs102proj;

import java.util.*;

public class DiscardPile implements Deck{
    private ArrayList<Card> listOfCards = new ArrayList<>();
    private Card topCard;

//    [Card, DesiredSuit]
    public void addCard(Card c){
        listOfCards.add(c);
        if(c.getValue() != 8){
            topCard = c;
        }else{
            Scanner sc = new Scanner(System.in);
            String suitName = sc.nextLine();
            Suit suit = switch (suitName) {
                case ("DIAMONDS") -> Suit.DIAMONDS;
                case ("CLUBS") -> Suit.CLUBS;
                case ("HEARTS") -> Suit.HEARTS;
                case ("SPADES") -> Suit.SPADES;
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
    public void shuffleDeck() {
        Collections.shuffle(listOfCards);
    }

    public void transferTo(DrawPile drawPile) {
        for(int i = 0; i < listOfCards.size() - 1; i++){
            drawPile.add(listOfCards.getFirst());
            listOfCards.removeFirst();
        }
    }
}
