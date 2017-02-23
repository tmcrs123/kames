package Server.Chat;

import Server.Chat.Chat;

import java.io.*;
import java.net.Socket;

/**
 * Created by tiagoRodrigues on 18/02/2017.
 */
public class ClientHandler implements Runnable {

    /**
     * Client.Client Handler Responsabilities
     *
     * Same shit we did before
     */

    private Chat chatServer;                        // Chat serve
    private Socket clientSocket;
    private BufferedWriter out = null;
    private BufferedReader in = null;
    private String nickname;
    private String parterNickname;

    public ClientHandler (Socket socket , Chat chatServer) throws IOException {
        this.clientSocket = socket;
        this.chatServer = chatServer;

        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    @Override
    public void run() {

        System.out.println("Thread " + Thread.currentThread().getName() + " has started.");

        try {

            while(!clientSocket.isClosed()) {
                ;
                // Waits for client messages
                String message = in.readLine();

                if(message == null) {
                    // There is message.
                    continue;

                } else if (!message.isEmpty()) {

                    if(message.startsWith("/")) {
                        chatServer.runGameCommand(nickname, message);
                        return;
                    }

                    chatServer.broadcast(nickname, message);

//                    // TODO: Isto será durante o início do jogo.
//                    chatServer.sendMessageToPartner(nickname, message);
//
//                    // TODO: Isto será durante o jogo.
//                    chatServer.broadcast(nickname, message);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the OutputStream from client handler.
     * @return
     */
    public BufferedWriter getOutputStream () {
        return out;
    }

    // TODO: A chamar para a primeira mensagem recebida.
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    // TODO: A chamar para quando o partner é definido.
    public void setParterNickname(String nickname) {
        this.parterNickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    // TODO: Envia a mensagem para o cliente.
    public void sendMsgToSelf(String nickname, String message) {

        try {

            out.write(nickname + ": " + message);
            out.newLine();
            out.flush();

        } catch(IOException ex) {
            System.out.println("Error sending message to Client: " + nickname);
        }
    }

    public void sendMsgToPartner(String message) {

        chatServer.sendMessageToPartner(parterNickname, nickname, message);
    }
}
