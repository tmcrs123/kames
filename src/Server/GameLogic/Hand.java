package Server.GameLogic;

/**
 * Created by peter on 21-02-2017.
 */

import Server.GameLogic.Card;

/**
 * Class Hand represents the four playable cards of each player
 * Game is going to have a Hand, representing the active cards of each turn
 *
 */
public class Hand {

    private Card[] activeCards;

    public Card[] getActiveCards() {
        return activeCards;
    }
}
