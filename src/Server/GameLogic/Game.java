package Server.GameLogic;

import Client.Client;
import Server.Chat.Chat;

/**
 * Created by tiagoRodrigues on 18/02/2017.
 */
public class Game {


    private Chat chat;
    private Deck deck; //SHARED MUTABLE STATE
    private Client[] players;
    private Hand tableHand; //SHARED MUTABLE STATE


    public void init() {
        chat = new Chat();
        deck = new Deck();
        players = new Client[4];// INITS A 4 PLAYERS ARRAY
        tableHand = new Hand();
        chat.start(); //STARTS THE CHAT
        setTeams();
    }

    public void setTeams() {

    }

    public void start() {
        //showForbiddenCard();
        giveInitialCardsToPlayers();
        startNewTurn();
    }

    private void startNewTurn() {

        burnTableHand();
        drawTableCards();
        while (!isTurnOver()) {
            keepProcessingTrades();//este metodo pode ter um nome melhor! SERÁ AQUI UM DO PRROBS DO MULTITHREADING?
        }
        startNewTurn();
    }

    public void endGame() {
        throw new UnsupportedOperationException();
    }

    private void giveInitialCardsToPlayers() {
        for (Client iPlayer : players) {
            deck.give4CardsTo(iPlayer.getHand());
        }
    }

    private void drawTableCards() {
        deck.give4CardsTo(tableHand);
    }

    private void burnTableHand() {
        tableHand.clear();
    }


    private boolean isTurnOver() {
        throw new UnsupportedOperationException();
    }


    private void keepProcessingTrades() {
        throw new UnsupportedOperationException();
    }


    /**
     * Server Responsabilities:
     * <p>
     * Server.Chat.Chat:
     * Start the chat
     * <p>
     * <p>
     * CARDS:
     * Have a cards and pick cards randomly from it whenever needed
     * Know the cards on the table
     * Know the cards of each player
     * Interpret a player request to change cards
     * Check whether or not a player request to change cards is valid
     * Inform a player if the card switch was successful
     * Know the number of rounds played
     * Evaluate if a player won when "Kames / Corta Kames" is called
     * Manage how long each round lasts
     * When round ends, put new cards on the table
     */




}
