package Client;

import Server.GameLogic.Hand;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by tiagoRodrigues on 18/02/2017.
 */
public class Client {

    /**
     * write messages to output stream
     * read messages from input stream and print them to screen
     * be able to distinguish between messages from another players and messages from the Server.GameLogic.Game
     * Know when to print a message to Server.Chat.Chat sys out or to Server.GameLogic.Game sys out
     */


    private Socket mySocket;
    private Hand hand;

    private String host = "192.168.0.119";
    private int portNumber = 8080;


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

    public Hand getHand(){
        return hand;
    }


}
