package com.Accenture.fitnessTracker.bootstrap;

import com.Accenture.fitnessTracker.model.Category;
import com.Accenture.fitnessTracker.model.Product;
import com.Accenture.fitnessTracker.repositories.CategoryRepository;
import com.Accenture.fitnessTracker.repositories.ProductRepository;
import com.Accenture.fitnessTracker.repositories.UserRepository;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Builder
public class Bootstrap implements CommandLineRunner {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;

    public Bootstrap(ProductRepository productRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll().block();
        categoryRepository.deleteAll().block();
        //userRepository.deleteAll().block();

        productRepository.save(Product.builder().name("products").calories(250.0).description("A Great Product").build()).block();

        categoryRepository.save(Category.builder().name("Category1").description("Spicy").build()).block();

    }
}
