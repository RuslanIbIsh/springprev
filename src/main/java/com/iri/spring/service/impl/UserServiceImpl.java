package com.iri.spring.service.impl;

import com.iri.spring.dao.UserDao;
import com.iri.spring.model.User;
import com.iri.spring.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User get(Long id) {
        return userDao.get(id)
                .orElseThrow(() -> new RuntimeException("Empty optional user"));
    }
}
