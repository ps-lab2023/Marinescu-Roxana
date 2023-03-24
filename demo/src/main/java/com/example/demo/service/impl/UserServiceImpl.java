package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public void updateUser(User user) {
        User updateUser = userRepo.findById(user.getId()).get();
        updateUser.setName(user.getName());
        updateUser.setAuth(user.getAuth());
        updateUser.setCart(user.getCart());
        userRepo.save(updateUser);
    }
    @Override
    public void createUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(User user) {
        User deleteUser = userRepo.findById(user.getId()).get();
        userRepo.delete(deleteUser);
    }

}
