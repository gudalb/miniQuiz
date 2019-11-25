package se.nackademin.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class PlayerServer implements Runnable {
    Socket clientSocket;
    Game game;
    String playerName;
    ObjectOutputStream toClient;
    public int score;
    boolean hasAnswered = false;

    public PlayerServer (Socket clientSocket, Game game, String playerName) throws IOException {
        this.clientSocket = clientSocket;
        this.game = game;
        this.playerName = playerName;
        this.toClient = new ObjectOutputStream(clientSocket.getOutputStream());
        game.addToPlayerList(this);
    }

    public void recieve () {
        Thread thread = new Thread(() -> {
            try {
                ObjectInputStream input = new ObjectInputStream(clientSocket.getInputStream());
                Object fromClient;
                while ((fromClient = input.readObject()) != null) {
                    game.processObj(this, fromClient);
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    public void sendToClient (Object object) throws IOException {
        toClient.writeObject(object);
    }

    @Override
    public void run() {
        recieve();
    }
}
