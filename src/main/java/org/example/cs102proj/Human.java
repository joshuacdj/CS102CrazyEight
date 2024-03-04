package org.example.cs102proj;

import java.util.*;

public class Human extends Player {

    public Human(ArrayList<Card> hand, String name) {
        super(hand, name);
    }


    public Card action(Card topCard, DrawPile deck) {
        // Take in user input
        Scanner sc = new Scanner(System.in);

        int cardsDrawn = 0;
//        set list of playable cards
        setPlayableCards(topCard);
//        Handles cases where I do not have a playable card
        while (getPlayableCards().isEmpty() && cardsDrawn < 5) {

            System.out.print("Input Action: Draw or Play");

            // Get user input
            String a = sc.nextLine();

            if (a.equals("Draw")) {
                drawCard(deck.getTopCard());
                cardsDrawn++;
            } else {
                System.out.println("No playable cards, please input draw only");
            }

        }

        // If I have a playable card
        if (cardsDrawn < 5) {

            boolean validAction = true;

            // Can only play and not draw
            do {
                System.out.println("Input Action: Draw or Play");

                String a = sc.nextLine();

                if (!a.equals("Play")) {
                    validAction = false;
                }

            } while (!validAction);

            // Print the available cards in hand
            System.out.println("Cards in hand:");
            for (Card c : getHand()) {
                System.out.println(c);
            }

            do {
                // Get value
                System.out.print("Choose a value: ");
                int value = Integer.parseInt(sc.nextLine());

                // Get suit
                System.out.print("Choose a suit: ");
                String s = sc.nextLine();
                Suit suit = Suit.valueOf(s);

                Card inputCard = new Card(value, suit);

                for (Card c : getPlayableCards()) {

                    if (c.equals(inputCard)) {
                        removeCard(c);
                        return c;
                    }
                }

                validAction = false;
            } while (!validAction);


        }
        return null;
    }

    public static void main(String[] args) {

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(3, Suit.DIAMONDS));
        hand.add(new Card(7, Suit.DIAMONDS));
        hand.add(new Card(3, Suit.HEARTS));
        hand.add(new Card(4, Suit.CLUBS));
        hand.add(new Card(8, Suit.DIAMONDS));

        Human h = new Human(hand, "tommy");

        DrawPile rp =  new DrawPile();

        h.action(rp.getTopCard(), rp);
    }
}
