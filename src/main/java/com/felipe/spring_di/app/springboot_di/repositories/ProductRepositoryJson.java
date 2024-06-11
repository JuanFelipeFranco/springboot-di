package com.felipe.spring_di.app.springboot_di.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.felipe.spring_di.app.springboot_di.models.Product;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryJson implements ProductRepository{
    List<Product> list;
    public ProductRepositoryJson() {
        ClassPathResource resource = new ClassPathResource("json/product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getFile(),Product[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }
}