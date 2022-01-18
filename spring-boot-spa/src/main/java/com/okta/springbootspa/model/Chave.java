package com.okta.springbootspa.model;

import java.io.Serializable;
import java.util.Objects;

public class Chave implements Serializable {
    private User user;

    private Long id;


    public Chave(String accountNumber, String accountType) {
        this.user = user;
        this.id = id;
    }
    public Chave(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chave)) return false;
        Chave chave = (Chave) o;
        return user.equals(chave.user) && id.equals(chave.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, id);
    }
}
