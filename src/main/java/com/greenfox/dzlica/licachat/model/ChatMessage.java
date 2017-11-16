package com.greenfox.dzlica.licachat.model;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

@Entity
public class ChatMessage {

    @Id
    Long id;
    String text;
    String username;
    Timestamp timestamp;

    public ChatMessage() {

    }

    public ChatMessage(Long id, String text, Timestamp timestamp) {
        this.id = randomId();
        this.text = text;
        this.timestamp = timestamp;
    }

    public ChatMessage(String text) {
        this.id = randomId();
    }

    public Long randomId() {
        Long id = ThreadLocalRandom.current().nextLong(1000000,9999999);
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
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

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", username='" + username + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
