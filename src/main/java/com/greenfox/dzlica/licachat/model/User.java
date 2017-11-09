package com.greenfox.dzlica.licachat.model;

import javax.persistence.*;

@Entity
@Table(name= "Usertable")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
