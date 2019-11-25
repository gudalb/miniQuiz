package se.nackademin.Client;

import java.awt.*;
import java.io.IOException;
import se.nackademin.Shared.*;

import javax.swing.*;

public class Main {
    public static void main (String[] args) throws IOException {

        String inputName = "";
        while (inputName.length()<1) {
            try {
                inputName = JOptionPane.showInputDialog("Input name");
            } catch (HeadlessException e) {
                e.printStackTrace();
            }
        }

        try {
            Client client = new Client("127.0.0.1", 54321, inputName);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Server is not running.");
        }

    }
}
