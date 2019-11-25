package se.nackademin.Shared;

import java.io.Serializable;

public class Answer implements Serializable {
    String answer;
    static final long serialVersionUID = 1L;

    public Answer (String answer) {
        this.answer = answer;
    }

    public String getAnswer () {
        return this.answer;
    }


}
