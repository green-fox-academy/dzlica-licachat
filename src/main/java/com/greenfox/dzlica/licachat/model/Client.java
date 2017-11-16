package com.greenfox.dzlica.licachat.model;

import static com.greenfox.dzlica.licachat.LicachatApplication.CHAT_APP_UNIQUE_ID;

public class Client {

    private String id;

    public Client(String id) {
        this.id = id;
    }

    public Client() {
        this.id = CHAT_APP_UNIQUE_ID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                '}';
    }
}
