package se.nackademin.Client;

import javax.sound.sampled.Port;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import se.nackademin.Shared.*;

public class Client implements Runnable {
    Socket serverSocket;
    ObjectOutputStream toServer;
    public String playerName;
    GUI gui;
    Game game;

    public Client(String serverAdr, int port, String playerName) throws IOException {
        this.serverSocket = new Socket(serverAdr, port);
        this.toServer = new ObjectOutputStream(serverSocket.getOutputStream());
        this.playerName = playerName;
        this.gui = new GUI(this);
        this.game = new Game(this);
        new Thread(this).start();
        toServer.writeObject(new Verify());
        toServer.writeObject(new Username(playerName));
    }


    public void recieve () {
        Thread thread = new Thread(() -> {
            try {
                ObjectInputStream input = new ObjectInputStream(serverSocket.getInputStream());
                Object fromServer;
                while ((fromServer = input.readObject()) != null) {
                    Game.processObj(fromServer);
                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    public void appendGUIText(String s){
        gui.chatBox.append(s);
    }

    public void sendToServer (Object object) throws IOException {
        toServer.writeObject(object);
    }
    @Override
    public void run() {
        recieve();
    }
}
