package org.example.cs102proj;

import java.util.Comparator;

public class PlayerCompare implements Comparator<Player> {
    public int compare(Player a, Player b) {
        return Integer.compare(a.getPoints(), b.getPoints()); // highest points first
    }
}
