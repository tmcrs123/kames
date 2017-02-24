package Server.Chat;

import Server.GameLogic.Game;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
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

    private static final int PORT_NUMBER = 8080;                   // Port to listen for connections

    private Game game;                                             // Game object that will have all logic
    private ArrayList<ClientHandler> clients;                           // List of Client threads
    private boolean gameStarted;                                   // If game has started = true
    private static final int PLAYER_LIMIT = 4;                     // Limit number of players
    private int numOfConnections;                                  // Number of players


    public void start() {

        clients = new ArrayList<>();

        try {

            System.out.println("Starting server at port: " + PORT_NUMBER + ", please wait...");
            ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
            System.out.println("Server started: " + serverSocket);

            while (numOfConnections < PLAYER_LIMIT) {

                try {

                    // Waits for client connections
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client connected: " + clientSocket.getInetAddress().getHostName());

                    // Creates a new ClientHandler
                    numOfConnections++;
                    String name = "Player-" + numOfConnections;
                    ClientHandler client = new ClientHandler(clientSocket, this);
                    clients.add(client);

                    // Serves the client connection with a new thread
                    Thread thread = new Thread(client);
                    thread.setName(name);
                    thread.start();

                } catch (IOException ex) {
                    System.out.println("Error receiving the client connection: " + ex.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Unable to start port at: " + PORT_NUMBER);
        }
    }

    public void runGameCommand(String nickname, String message){
        throw new UnsupportedOperationException();
    }

    public void sendMessageToPartner(String partnerNickname, String nickname, String message){

        for(ClientHandler client: clients) {

            if(client.getNickname().equals(partnerNickname)) {

                client.sendMsgToSelf(nickname, message);
            }
        }
    }

    public void broadcast(String nickname, String message){

        synchronized (clients) {

            System.out.println(nickname + ":" + message);

            Iterator<ClientHandler> it = clients.iterator();

            while(it.hasNext()) {
                it.next().sendMsgToSelf(nickname, message);
            }
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
