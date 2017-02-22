package Server.Chat;

import Server.GameLogic.Game;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
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
    private static final String HOST = "localhost";                // Host = 127.0.0.1, runs on localhost

    private Game game;                                             // Game object that will have all logic
    private List<ClientHandler> clients;                           // List of Client threads
    private boolean gameStarted;                                   // If game has started = true
    private static final int PLAYER_LIMIT = 4;                     // Limit number of players
    private int numOfConnections;                                  // Number of players


    public void start(){
        try {

            System.out.println("Starting server at port: " + PORT_NUMBER + ", please wait...");
            ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
            System.out.println("Server started: " + serverSocket);

            while(numOfConnections < PLAYER_LIMIT) {

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

                } catch(IOException ex) {
                    System.out.println("Error receiving the client connection: " + ex.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Unable to start port at: " + PORT_NUMBER);
        }
    }

    /**
     * Checks the message for commands, if it is a command it will
     * start with a "/". If not it will send a chat message.
     * @param message
     */
    public void validateMessage(String nickname, String message){

        if(message.startsWith("/")) {
            runGameCommand(nickname, message);

        } else if(gameStarted) {
            broadcast(nickname, message);

        } else {
            sendMessageToPartner(nickname, message);
        }
    }

    public void runGameCommand(String nickname, String message){
        throw new UnsupportedOperationException();
    }

    public void sendMessageToPartner(String nickname, String message){
        throw new UnsupportedOperationException();
    }

    public void broadcast(String nickname, String message){

        synchronized (clients) {

            Iterator<ClientHandler> it = clients.iterator();

            while(it.hasNext()) {
                it.next().send(nickname, message);
            }
        }
    }


}
