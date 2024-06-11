package com.felipe.spring_di.app.springboot_di;

import com.felipe.spring_di.app.springboot_di.models.Product;
import com.felipe.spring_di.app.springboot_di.repositories.ProductRepository;
import com.felipe.spring_di.app.springboot_di.repositories.ProductRepositoryJson;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean
    ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    }


}
