package com.greenfox.dzlica.licachat;

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

	public static void main(String[] args) {
		SpringApplication.run(LicachatApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
