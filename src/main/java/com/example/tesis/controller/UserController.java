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
    public ResponseEntity<?> registerUser(@RequestBody User user){
        try {
            User registeredUser = userService.registerUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el registro de usuario");
        }
    }

    @GetMapping("/getEmail")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email){
        User user = userService.getUserByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
