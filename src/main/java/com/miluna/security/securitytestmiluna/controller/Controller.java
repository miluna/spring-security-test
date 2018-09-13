package com.miluna.security.securitytestmiluna.controller;

import com.miluna.security.securitytestmiluna.model.User;
import com.miluna.security.securitytestmiluna.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    SecurityRepository repository;

    @PostMapping("/authentication")
    public ResponseEntity<HttpStatus> login(User user){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        User found = repository.getUserByName(user.getName());

        if (encoder.matches(user.getPassword(), found.getPassword())){
            return ResponseEntity.ok(HttpStatus.OK);
        }

        return ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User u = new User(
                user.getId(),
                user.getName(),
                encoder.encode(user.getPassword())
                );

        User result = repository.save(u);
        return ResponseEntity.ok(result);
    }
}
