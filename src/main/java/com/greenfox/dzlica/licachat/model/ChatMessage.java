package com.greenfox.dzlica.licachat.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ChatMessage {

    @Id
    @GeneratedValue
    Long id;
    String text;
    String username;
    Long timestamp;

    public ChatMessage() {

    }

    public ChatMessage(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public ChatMessage(String text) {
        this.id = Long.valueOf((int) (Math.random() * (9999999 - 1000000)) + 1000000);
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
