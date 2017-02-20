/**
 * Created by tiagoRodrigues on 18/02/2017.
 */
public class Game {

    /**
     * Server Responsabilities:
     *
     * Chat:
     * Start the chat
     *
     *
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
     *
     */


    private Chat chat;
    private Cards cards;


    public void updateTable(){
        throw new UnsupportedOperationException();
    }

    public void changePlayerCard(){
        throw new UnsupportedOperationException();
    }

    public boolean isTurnOver(){
        throw new UnsupportedOperationException();
    }

    public boolean gameEnded(){
        throw new UnsupportedOperationException();
    }

    class Player{
        private String name;
        private String Team;
        private Cards[] playerCards = new Cards[4];

        public Player(String name, String team, Cards[] playerCards) {
            this.name = name;
            Team = team;
            this.playerCards = playerCards;
        }
    }
}
