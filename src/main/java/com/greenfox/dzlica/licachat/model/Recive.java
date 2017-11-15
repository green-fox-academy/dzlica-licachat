package com.greenfox.dzlica.licachat.model;

public class Recive {

    private ChatMessage chatMessage;
    private Client client;

    public Recive(ChatMessage chatMessage, Client client) {
        this.chatMessage = chatMessage;
        this.client = client;
    }

    public Recive() {
    }

    public ChatMessage getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(ChatMessage chatMessage) {
        this.chatMessage = chatMessage;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
