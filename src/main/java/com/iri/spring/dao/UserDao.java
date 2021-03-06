package com.iri.spring.dao;

import com.iri.spring.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    Optional<User> get(Long id);
}
