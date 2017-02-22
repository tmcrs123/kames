package Server.GameLogic;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by tiagoRodrigues on 20/02/2017.
 */
public class Deck {

    public static final String[] POSSIBLE_CARD_VALUES = {"A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    private LinkedList<Card> cards;

    public Deck() {
        cards = new LinkedList<>();
        initCards();
    }



    private void initCards() {

        //CREATES 4 CARDS OF EACH VALUE
        for (String iValue : POSSIBLE_CARD_VALUES) {
            for (int i = 0; i < 4; i++) {
                cards.add(new Card(iValue));
            }
        }
        Collections.shuffle(cards);
    }



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
