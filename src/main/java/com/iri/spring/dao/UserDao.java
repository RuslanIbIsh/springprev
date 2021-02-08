package com.iri.spring.dao;

import com.iri.spring.model.User;
import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
