package com.felipe.spring_di.app.springboot_di.services;

import com.felipe.spring_di.app.springboot_di.models.Product;
import com.felipe.spring_di.app.springboot_di.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private Environment environment;

    @Value("${config.price.tax}")
    private Double tax;
    @Autowired
    @Qualifier("productRepositoryJson")
    private ProductRepository repository;

//    public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public List<Product> findAll() {
        return repository.findAll().stream().map(p -> {
//            Double priceTax = p.getPrice() * environment.getProperty("config.price.tax", Double.class);
            Double priceTax = p.getPrice() * tax;
            //Product newProduct = new Product(p.getId(),p.getName(),priceTax.longValue())
//            p.setPrice(priceTax.longValue());

            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceTax.longValue());
            return newProduct;

//            p.setPrice(priceTax.longValue());
//            return p;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

}
