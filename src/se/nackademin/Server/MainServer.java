package se.nackademin.Server;

import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import se.nackademin.Shared.*;

public class MainServer implements Runnable {


    static int playersPerGame = 1;
    static int questionsPerRound = 1;
    static int rounds = 1;
    static int port = 54321;

    public MainServer() {
        new Thread(this).start();
    }


    @Override
    public void run() {
        try  {
            InputStream propInp = new FileInputStream("config.properties");
            Properties prop = new Properties();
            prop.load(propInp);
            playersPerGame = Integer.parseInt(prop.getProperty("players_per_game"));
            rounds = Integer.parseInt(prop.getProperty("num_rounds"));
            questionsPerRound = Integer.parseInt(prop.getProperty("questions_per_round"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } ;



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
