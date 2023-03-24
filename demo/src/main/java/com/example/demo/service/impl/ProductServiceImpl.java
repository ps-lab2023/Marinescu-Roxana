package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.repository.ProductRepo;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    @Override
    public void updateProd(Product product) {
        Product updateProd = productRepo.findById(product.getId()).get();
        updateProd.setName(product.getName());
        updateProd.setDescription(product.getDescription());
        updateProd.setPrice(product.getPrice());
        productRepo.save(updateProd);
    }

    @Override
    public void deleteProd(Product product) {
        Product deleteProd = productRepo.findById(product.getId()).get();
        productRepo.delete(deleteProd);
    }

    @Override
    public void createProd(Product product) {
        productRepo.save(product);
    }
}
