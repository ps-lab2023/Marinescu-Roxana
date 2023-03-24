package com.example.demo;

import com.example.demo.enums.Auth;
import com.example.demo.model.*;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	CommandLineRunner init(CategoryRepo categoryRepo, UserRepo userRepo, ProductRepo productRepo, CategoryService categoryService,
						   UserService userService, ProductService productService){
		return args -> {
			Category category = new Category();
			category.setName("Haine");
			Product product = new Product();
			Product product1 = new Product();
			product1.setName("Pantofi");
			product.setName("Pantaloni");
			product.setPrice(300.5f);
			product.setCategory(category);
			List<Product> prod = new ArrayList<Product>();
			prod.add(product);
			category.setProducts(prod);
			User user = new User();
			user.setName("Alex");
			user.setMail("alex1@gmail.com");
			user.setPassword("12345");
			user.setAuth(Auth.USER);
			user.setCart(new Cart());
			user.getCart().setUser(user);
			User user1 = new User();
			user1.setName("Rox");
			user1.setAuth(Auth.ADMIN);
			user1.createProd(productRepo,product1);
			userRepo.save(user);
			userRepo.save(user1);
			categoryRepo.save(category);
			productRepo.save(product);
			productService.deleteProd(product1);
		};

	}

}
