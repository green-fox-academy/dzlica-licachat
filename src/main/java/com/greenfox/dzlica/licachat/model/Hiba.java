package com.greenfox.dzlica.licachat.model;

public class Hiba {

    String error;

    public Hiba(String error) {
        this.error = "Missing fields: ";
    }

    public Hiba() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
