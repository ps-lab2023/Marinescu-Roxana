package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    public void updateUser(User user);
    public void createUser(User user);
    public void deleteUser(User user);
}
