package com.example.tesis.controller;

import com.example.tesis.model.User;
import com.example.tesis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(user);

    }

    @GetMapping("/getEmail")
    public User getUserByEmail(@RequestParam String email){
        return userService.getUserByEmail(email);
    }

}
