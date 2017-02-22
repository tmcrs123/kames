package Server.GameLogic;

import java.util.LinkedList;

/**
 * Created by tiagoRodrigues on 20/02/2017.
 */
public class Deck {

    private LinkedList<Card> cards = new LinkedList();


    public void showLastCard() {
        throw new UnsupportedOperationException();
    }

    public void getRandomCard() {
        throw new UnsupportedOperationException();
    }

    public void addCard() {
        throw new UnsupportedOperationException();
    }

    public void removeCard() {
        throw new UnsupportedOperationException();
    }


    public void give4CardsTo(Hand hand) {

        for (int cardsnb = 0; cardsnb < 4; cardsnb++) {
            hand.takeCard(cards.poll());
        }
    }



}
