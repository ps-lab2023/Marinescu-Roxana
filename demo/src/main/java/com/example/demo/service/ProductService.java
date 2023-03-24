package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import org.springframework.stereotype.Component;

@Component
public interface ProductService {
    public void updateProd(Product product);
    public void deleteProd(Product product);
    public void createProd(Product product);
}
