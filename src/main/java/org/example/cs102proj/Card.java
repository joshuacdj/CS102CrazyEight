package org.example.cs102proj;

public class Card {
    /**
     * Stores value of a singular card
     */
    public enum Suit
    {
        DIAMONDS, CLUBS, HEARTS, SPADES;
    }
    // Enum representing playing card suits

    private final int value;
    private final Suit suit;
    // Instance of value and suit

    public Card(int value, Suit suit) {
        // 11 -> J ; 12 -> Q ; 13 -> K
        this.value = value;
        this.suit = suit;
    }
    // Card constructor

    public int getValue() {
        return value;
    }
    // Return the face value of the card

    public Suit getSuit() {
        return suit;
    }
    // Return the suit of the card

    @Override
    public String toString() {
        return String.format("value: %d suit: %s%n", value, suit);
    }

}

