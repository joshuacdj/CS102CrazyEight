package org.example.cs102proj;

import java.util.Comparator;

public class CardCompare implements Comparator<Card> {
    public int compare(Card a, Card b) {
        if (a.getValue() > b.getValue()) {
            return -1; // highest value first
        }
        if (a.getValue() < b.getValue()) {
            return 1; // highest value first
        }
        return 0;
    }
}
