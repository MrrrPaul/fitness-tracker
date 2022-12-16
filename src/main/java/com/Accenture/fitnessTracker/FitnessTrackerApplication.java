package com.Accenture.fitnessTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FitnessTrackerApplication {
    public static void main(String[] args) {

        SpringApplication.run(FitnessTrackerApplication.class, args);


//        ConnectionString connString = new ConnectionString(
//                "mongodb+srv://PauliusDB:team4@pauliusdb.w1oqpy3.mongodb.net/?retryWrites=true&w=majority"
//        );
//        MongoClientSettings settings = MongoClientSettings.builder()
//                .applyConnectionString(connString)
//                .retryWrites(true)
//                .build();
//        MongoClient mongoClient = MongoClients.create(settings);
//        MongoDatabase database = mongoClient.getDatabase("test");
    }
}
