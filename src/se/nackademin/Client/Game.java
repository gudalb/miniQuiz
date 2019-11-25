package se.nackademin.Client;
import se.nackademin.Shared.*;

import javax.swing.*;
import java.io.IOException;

public class Game {

    static Client client;

    static final String html = "<html><body style='width: %1spx'>%1s";

    public Game (Client client) {
        this.client = client;
    }

    public static synchronized void processObj (Object object) throws IOException {
        if(object instanceof Chat) {
            System.out.println(object.toString());
            client.appendGUIText(object.toString() + "\n");
            client.gui.chatBox.setCaretPosition(client.gui.chatBox.getDocument().getLength());
        }

        if(object instanceof Continue) {
            int opt = JOptionPane.showConfirmDialog(client.gui.mainPanel, "Play again?", "Continue?", JOptionPane.YES_NO_OPTION);
            if (opt == 0) {
                sendToServer(client, new PlayAgain(true));
            } else
                sendToServer(client, new PlayAgain(false));
        }

        if(object instanceof Question) {

            System.out.println("mottagit question");
            client.gui.questionText.setText(((Question) object).getQuestion());
            String[] Answers = ((Question) object).getAnswers();

            client.gui.ans1.setText(Answers[0]);
            client.gui.ans2.setText(Answers[1]);
            client.gui.ans3.setText(Answers[2]);
            client.gui.ans4.setText(Answers[3]);
            client.gui.ans1.setEnabled(true);
            client.gui.ans2.setEnabled(true);
            client.gui.ans3.setEnabled(true);
            client.gui.ans4.setEnabled(true);
            client.gui.repaint();

        }
    }

    public static synchronized void sendToServer (Client client, Object toServer) throws IOException {
        client.toServer.writeObject(toServer);
    }



}
