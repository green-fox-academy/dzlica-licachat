package com.greenfox.dzlica.licachat.repositories.model;

import com.greenfox.dzlica.licachat.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {

}
