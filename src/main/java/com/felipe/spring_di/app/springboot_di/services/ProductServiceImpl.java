package com.felipe.spring_di.app.springboot_di.services;

import com.felipe.spring_di.app.springboot_di.models.Product;
import com.felipe.spring_di.app.springboot_di.repositories.ProductRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepositoryImpl repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            //Product newProduct = new Product(p.getId(),p.getName(),priceTax.longValue())
//            p.setPrice(priceTax.longValue());
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

}
