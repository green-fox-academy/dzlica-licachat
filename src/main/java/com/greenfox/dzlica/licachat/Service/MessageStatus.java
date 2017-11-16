package com.greenfox.dzlica.licachat.Service;

import com.greenfox.dzlica.licachat.model.ChatMessage;
import com.greenfox.dzlica.licachat.model.Recive;
import com.greenfox.dzlica.licachat.model.Response;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageStatus {

    public void sendMessage(Recive recive){
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Recive> httpent = new HttpEntity<>(recive);
        System.out.println(recive);
        Response response = restTemplate.postForObject(System.getenv("CHAT_APP_PEER_ADDRESS"),httpent, Response.class);
 //       Response response = restTemplate.postForObject("http://localhost:8080/api/message/receive",httpent, Response.class);
    }
}
