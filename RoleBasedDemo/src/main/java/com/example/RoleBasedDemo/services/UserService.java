package com.example.RoleBasedDemo.services;

import com.example.RoleBasedDemo.entities.User;
import com.example.RoleBasedDemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository  userRepository;

    public String getUser(String email,String password) {
        User user = userRepository.findByEmail(email);
        if(user == null){
            return "Invalid credintials";
        }else{
            if(user.getPassword().equals(password)){
                return user.getRole();
            }
        }
        return "Invalid credentials";
    }
}
