package Client;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by tiagoRodrigues on 18/02/2017.
 */
public class Client {

    /**
     * write messages to output stream
     * read messages from input stream and print them to screen
     * be able to distinguish between messages from another players and messages from the Server.Game
     * Know when to print a message to Server.Chat sys out or to Server.Game sys out
     */


    private Socket mySocket;

    String host = "localhost";
    int portNumber = 8080;


    public void clientConnect() {

        mySocket = null;

        try {
            //establish connection to the server
            mySocket = new Socket(host, portNumber);


            //start read and write threads

            Thread read = new Thread(new ClientRead(mySocket));
            read.start();

            Thread write = new Thread(new ClientWrite(mySocket));
            write.start();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
