package se.nackademin.Client;

import se.nackademin.Shared.Answer;
import se.nackademin.Shared.Chat;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUI extends JFrame {
    JPanel mainPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();
    JPanel chatPanel = new JPanel();
    JButton[] buttons = new JButton[4];
    JTextField chatInput = new JTextField();
    JTextArea chatBox = new JTextArea();
    JLabel questionText = new JLabel();
    JButton ans1 = new JButton();
    JButton ans2 = new JButton();
    JButton ans3 = new JButton();
    JButton ans4 = new JButton();

    Client client;

    GUI (Client client) {

        this.client = client;
        setSize(500,400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(mainPanel);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(questionText, BorderLayout.NORTH);
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        mainPanel.add(chatPanel, BorderLayout.SOUTH);
        buttonsPanel.setLayout(new GridLayout(2,2));
        chatPanel.setLayout(new BorderLayout());
        chatBox.setEditable(false);
        chatBox.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(chatBox);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        chatPanel.add(scrollPane, BorderLayout.NORTH);
        chatBox.setRows(10);
        chatBox.setColumns(60);


        chatPanel.add(chatInput, BorderLayout.SOUTH);
        chatInput.setMaximumSize(new Dimension(500,15));
        chatInput.setSize(300,30);
        chatInput.addActionListener(e -> {
            try {
                if(chatInput.getText().length() > 0) {
                    client.sendToServer(new Chat(client.playerName, chatInput.getText()));
                    chatInput.setText("");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }


        });

        setTitle("miniQuiz - " + client.playerName);
        questionText.setPreferredSize(new Dimension(450,200));
        questionText.setHorizontalAlignment(SwingConstants.CENTER);
        questionText.setFont(new Font("Serif", Font.PLAIN, 15));
        questionText.setText("Waiting for players");

        buttons[0] = ans1;
        buttons[1] = ans2;
        buttons[2] = ans3;
        buttons[3] = ans4;


        for(JButton button: buttons) {
            button.setPreferredSize(new Dimension(100,120));
            buttonsPanel.add(button);
            JButton finalButton = button;
            button.addActionListener(e -> {
                try {
                    client.sendToServer(new Answer(finalButton.getText()));
                    button.setBackground(Color.PINK);
                    repaint();
                    disableButtons();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            });
        }

        pack();


    }

    public static void main() {

    }

    public void disableButtons () {
        for (JButton button: buttons) {
            button.setEnabled(false);
        }
    }

}
