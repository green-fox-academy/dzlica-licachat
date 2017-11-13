package com.greenfox.dzlica.licachat.model;

import jdk.nashorn.internal.ir.RuntimeNode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    LocalDateTime createdAt;
    String endpoint;
    String data;
    String method;
    String loglevel;

    public Log(String loglevel, HttpServletRequest httpServletRequest) {
        this.createdAt = LocalDateTime.now();
        this.loglevel = loglevel;
        this.method = httpServletRequest.getMethod();
        this.data = httpServletRequest.getQueryString();
        this.endpoint = httpServletRequest.getPathInfo();

        this.write();
    }
    //The log should look like this: 2017-05-16 21:47:19.040 INFO Request /message POST text=apple

    public void write() {
        String systemLoglevel = System.getenv("CHAT_APP_LOGLEVEL");
        if (systemLoglevel != null && systemLoglevel.equals("ERROR") && !this.loglevel.equals("ERROR")) {
            return;
        }
        System.err.println(this.toString());
    }

    @Override
    public String toString() {
        return createdAt.toString() + " " + endpoint + " " + loglevel + " " + method + " " + data;
    }

    public Log() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getLoglevel() {
        return loglevel;
    }

    public void setLoglevel(String loglevel) {
        this.loglevel = loglevel;
    }



}
