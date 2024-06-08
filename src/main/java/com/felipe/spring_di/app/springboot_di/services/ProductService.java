package com.felipe.spring_di.app.springboot_di.services;

import com.felipe.spring_di.app.springboot_di.models.Product;
import com.felipe.spring_di.app.springboot_di.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private ProductRepository repository = new ProductRepository();
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceTax = p.getPrice() * 1.25d;
            p.setPrice(priceTax.longValue());
            return p;
        }).collect(Collectors.toList());
    }
}
