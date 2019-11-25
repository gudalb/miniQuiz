package se.nackademin.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import se.nackademin.Shared.*;

public class MainServer implements Runnable {

    static int playersPerGame = 2;
    static int questionsPerRound = 2;
    static int rounds = 2;
    static int port = 54321;

    public MainServer() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        while(true) {
            try {
                ServerSocket listen = new ServerSocket(port);
                System.out.println("Server started");

                Game game = new Game();

                for (int i = 0; i < playersPerGame; i++) {
                    String playerName = "Player" + (i + 1);
                    PlayerServer playerServer = new PlayerServer(listen.accept(), game, playerName);
                    System.out.println(playerName + " joins.");
                    Thread thread = new Thread(playerServer);
                    thread.start();
                    playerServer.sendToClient(new Chat("server", "Welcome!"));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
