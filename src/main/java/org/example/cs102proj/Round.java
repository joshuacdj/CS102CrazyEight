import java.util.ArrayList;

public class Round {
    private ArrayList<Player> playerPosition;
    private int roundNumber = 1;

    // setter for player position
    public void setPlayerPosition(ArrayList<Player> playerPosition) {
        // Get the player who went first
        Player first = playerPosition.getFirst();

        // Remove that player from the arraylist
        playerPosition.removeFirst();

        // Move the player to the end
        playerPosition.add(first);
    }

    public void Round(ArrayList<Player> playerPosition) {
        // shuffle deck
        Deck.shuffleDeck();

//        if (roundNumber == 1) {
//            // each player draws one card
//            int minimum = playerPosition.get(dealer).drawCard().getValue();
//
//            for (int i = 1; i < 4; i++) {
//                int current = playerPosition.get(i).drawCard().getValue();
//                if (current < minimum) {
//                    minimum = current;
//                    dealer = i;
//                }
//            }
//        }

        if (roundNumber != 1) {
            setPlayerPosition(playerPosition);
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                playerPosition.get(j).drawCard();
            }
        }
    }


    public boolean roundEnd() {

    }
}
