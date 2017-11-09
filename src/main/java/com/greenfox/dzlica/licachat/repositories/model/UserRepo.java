package com.greenfox.dzlica.licachat.repositories.model;

import com.greenfox.dzlica.licachat.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
}
