package com.greenfox.dzlica.licachat;

import com.greenfox.dzlica.licachat.repositories.model.ChatMessageRepo;
import com.greenfox.dzlica.licachat.repositories.model.LogRepo;
import com.greenfox.dzlica.licachat.repositories.model.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LicachatApplication implements CommandLineRunner {

	@Autowired
    UserRepo userRepo;

	@Autowired
    LogRepo logRepo;

	@Autowired
	ChatMessageRepo chatMessageRepo;

    public static String CHAT_APP_LOGLEVEL = System.getenv("CHAT_APP_LOGLEVEL");
    public static String CHAT_APP_UNIQUE_ID = System.getenv("CHAT_APP_UNIQUE_ID");
 //   public static String CHAT_APP_PEER_ADDRESS = System.getenv("CHAT_APP_PEER_ADDRESS");

	public static void main(String[] args) {
		SpringApplication.run(LicachatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
