package com.Accenture.fitnessTracker.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Builder
@Document
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private Double calories;

    @DBRef
    private List<Category> categories = new ArrayList<>();

    public Product(){

    }

    public Product(String id, String name, String description, Double calories, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.calories = calories;
        this.categories = categories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
