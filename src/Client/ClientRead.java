package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by tiagoRodrigues on 20/02/2017.
 */
public class ClientRead implements Runnable {

    private Socket socket;
    private BufferedReader breader;


    //pass client socket here and streams!

    public ClientRead (Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run () {

        try {

            breader = new BufferedReader(new InputStreamReader(socket.getInputStream()));



        } catch(IOException e){
            e.printStackTrace();
        }
    }


}
