package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by tiagoRodrigues on 20/02/2017.
 */
public class ClientWrite implements Runnable {


    private Socket socket;
    private PrintWriter out;

    public ClientWrite (Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run () {

        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                out = new PrintWriter(socket.getOutputStream(), true);
                String message = scanner.nextLine();
                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
