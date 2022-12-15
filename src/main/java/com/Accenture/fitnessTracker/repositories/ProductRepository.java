package com.Accenture.fitnessTracker.repositories;

import com.Accenture.fitnessTracker.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, String> {
}
