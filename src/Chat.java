import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by tiagoRodrigues on 18/02/2017.
 */
public class Chat {

    /**
     * Chat Responsabilities
     *
     * Handle multiple clients (Client Handlers)
     * Distinguish between a game command and a chat message
     * Inform gameServer if a player issued a game command
     * Broadcast messages to players
     *
     */


    private CopyOnWriteArrayList<ClientHandler> clients = new CopyOnWriteArrayList<>();
    boolean gameStarted;
    int portNumber = 8080;
    String host = "localhost";



    public void start(){
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
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
