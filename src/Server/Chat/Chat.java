package Server.Chat;

import Server.GameLogic.Game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * Created by tiagoRodrigues on 18/02/2017.
 */
public class Chat {

    /**
     * Server.Chat.Chat Responsabilities
     *
     * Handle multiple clients (Client.Client Handlers)
     * Distinguish between a game command and a chat message
     * Inform gameServer if a player issued a game command
     * Broadcast messages to players
     *
     */


    private static final int PORT_NUMBER = 8080;
    private static final String HOST = "localhost";

    private Game game;
    private List<ClientHandler> clients;
    private boolean gameStarted;


    public void start(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
            Socket clientSocket = serverSocket.accept();

            //n meto o resto pk o Joaquim disse que queria ver a parte do server. Up to you



        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void runGameCommand(String message){
        throw new UnsupportedOperationException();
    }

    public void validateMessage(String message){
        throw new UnsupportedOperationException();
    }

    public void sendMessageToPartner(String message){
        throw new UnsupportedOperationException();
    }

    public void broadcast(String message){
        throw new UnsupportedOperationException();
    }


}
