package se.nackademin.Shared;

import java.io.Serializable;

public class PlayAgain implements Serializable {
    public boolean playAgain;
    static final long serialVersionUID = 1L;

    public PlayAgain (boolean playAgain) {
        this.playAgain = playAgain;
    }
}
