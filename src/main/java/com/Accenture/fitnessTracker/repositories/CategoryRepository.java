package com.Accenture.fitnessTracker.repositories;

import com.Accenture.fitnessTracker.model.Category;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends ReactiveCrudRepository<Category, String> {
}
