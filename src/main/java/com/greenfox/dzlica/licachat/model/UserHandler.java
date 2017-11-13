package com.greenfox.dzlica.licachat.model;

import com.greenfox.dzlica.licachat.repositories.model.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserHandler {

    @Autowired
    UserRepo userRepo;

    User aktiveUser;

    public UserHandler(User aktiveUser) {
        this.aktiveUser = aktiveUser;
    }

    public User getAktiveUser() {
        return aktiveUser;
    }

    public void setAktiveUser(User aktiveUser) {
        this.aktiveUser = aktiveUser;
    }

    public UserHandler() {
    }



    public boolean userExist(String userName) {
        boolean exists = false;
        for (User user : userRepo.findAll()) {
            if (user.getName().equals(userName)) {
                exists = true;
            }
        }
        return exists;
    }
}
