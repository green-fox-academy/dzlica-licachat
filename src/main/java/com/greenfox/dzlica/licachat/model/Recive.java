package com.greenfox.dzlica.licachat.model;

public class Recive {

    private ChatMessage message;
    private Client client;

    public Recive(ChatMessage message, Client client) {
        this.message = message;
        this.client = client;
    }

    public Recive() {
    }

    public ChatMessage getMessage() {
        return message;
    }

    public void setMessage(ChatMessage message) {
        this.message = message;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Recive{" +
                "message=" + message +
                ", client=" + client +
                '}';
    }


}
