package com.iri.spring.service;

import com.iri.spring.model.User;
import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
