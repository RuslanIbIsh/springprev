package com.iri.spring;

import com.iri.spring.config.AppConfig;
import com.iri.spring.model.User;
import com.iri.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.add(new User("John", "Smith", "john@mail.com"));
        userService.add(new User("Sally", "Smith", "sally@mail.com"));
        userService.listUsers().forEach(System.out::println);
    }
}
