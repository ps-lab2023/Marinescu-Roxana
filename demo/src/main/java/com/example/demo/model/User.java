package com.example.demo.model;

import com.example.demo.enums.Auth;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.impl.CategoryServiceImpl;
import com.example.demo.service.impl.ProductServiceImpl;
import com.example.demo.service.impl.UserServiceImpl;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String mail;
    private String password;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Cart cart;
    private Auth auth;

    public void deleteCateg(CategoryRepo categoryRepo,Category category){
        if(verifyAuth()){
            CategoryServiceImpl cs = new CategoryServiceImpl(categoryRepo);
            cs.deleteCategory(category);
        }
    }
    public void deleteProd(ProductRepo productRepo, Product product){
        if(verifyAuth()){
            ProductServiceImpl ps = new ProductServiceImpl(productRepo);
            ps.deleteProd(product);
        }
    }

    public void deleteUser(UserRepo userRepo, User user){
        if(verifyAuth()){
            UserServiceImpl us = new UserServiceImpl(userRepo);
            us.deleteUser(user);
        }
    }

    public void updateUser(UserRepo userRepo, User user){
        if(verifyAuth()){
            UserServiceImpl us = new UserServiceImpl(userRepo);
            us.updateUser(user);
        }
    }

    public void createUser(UserRepo userRepo, User user){
        if(verifyAuth()){
            UserServiceImpl us = new UserServiceImpl(userRepo);
            us.createUser(user);
        }
    }

    public void createProd(ProductRepo productRepo, Product product){
        if(verifyAuth()){
            ProductServiceImpl ps = new ProductServiceImpl(productRepo);
            ps.createProd(product);
        }
    }
    public void createCateg(CategoryRepo categoryRepo,Category category){
        if(verifyAuth()){
            CategoryServiceImpl cs = new CategoryServiceImpl(categoryRepo);
            cs.createCategory(category);
        }
    }
    public void updateCateg(CategoryRepo categoryRepo,Category category){
        if(verifyAuth()){
            CategoryServiceImpl cs = new CategoryServiceImpl(categoryRepo);
            cs.updateCategory(category);
        }
    }
    public void updateProd(ProductRepo productRepo, Product product){
        if(verifyAuth()){
            ProductServiceImpl ps = new ProductServiceImpl(productRepo);
            ps.updateProd(product);
        }
    }
    public boolean verifyAuth(){
        if(this.auth == Auth.ADMIN){
            return true;
        }
        return false;
    }

}
