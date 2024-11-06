package com.example.tesis.service;

import com.example.tesis.model.User;
import com.example.tesis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User registerUser(User user){
        if(userRepository.findByEmail(user.getEmail())!= null){
            throw new IllegalStateException("Email ya en la base de datos");
        }
        return userRepository.save(user);
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }




}
