package com.iri.spring.controller;

import com.iri.spring.dto.UserResponseDto;
import com.iri.spring.model.User;
import com.iri.spring.service.UserService;
import com.iri.spring.service.mapper.UserMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/inject")
    public void addUsers() {
        User userOne = new User("John", "Smith", "john@mail.com");
        User userTwo = new User("Sally", "Smith", "sally@mail.com");
        User userThree = new User("Matt", "Vachvsky", "mat@mail.com");
        User userFour = new User("Sofy", "Vachovsky", "sofy@mail.com");
        userService.add(userOne);
        userService.add(userTwo);
        userService.add(userThree);
        userService.add(userFour);
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        return userMapper.convertToDto(userService.get(userId));
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.listUsers().stream()
                .map(user -> userMapper.convertToDto(user))
                .collect(Collectors.toList());
    }
}
