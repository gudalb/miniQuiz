package se.nackademin.Shared;

import java.io.Serializable;

public class Chat implements Serializable {
    String message;
    String fromPlayer;
    static final long serialVersionUID = 1L;

    public Chat (String fromPlayer, String message) {
        this.message = message;
        this.fromPlayer = fromPlayer;
    }

    @Override
    public String toString() {
        return fromPlayer + ": " + message;
    }
}
