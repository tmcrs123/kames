import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by tiagoRodrigues on 18/02/2017.
 */
public class ClientHandler implements Runnable {

    /**
     * Client Handler Responsabilities
     *
     * Same shit we did before
     */

    private Chat chatServer;
    private Socket clientSocket;
    private DataOutputStream out;
    private String nickname;

    public ClientHandler (Socket socket , Chat chatServer) {
        this.clientSocket = socket;
        this.chatServer = chatServer;

    }

    public DataOutputStream getOutputStream () {
        return out;
    }

    @Override
    public void run() {

        try {
            out = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader in = null;
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
