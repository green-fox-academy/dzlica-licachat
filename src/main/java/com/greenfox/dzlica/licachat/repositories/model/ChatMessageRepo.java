package com.greenfox.dzlica.licachat.repositories.model;

import com.greenfox.dzlica.licachat.model.ChatMessage;
import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepo extends CrudRepository<ChatMessage, Long> {

}
