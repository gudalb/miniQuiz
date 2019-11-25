package se.nackademin.Shared;

import java.io.Serializable;

public class Username implements Serializable {
    static final long serialVersionUID = 1L;
    public String username;

    public Username (String username) {
        this.username = username;
    }


}
