package com.Accenture.fitnessTracker.repositories;

import org.apache.catalina.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, String> {
    Mono<User> findUserByUsername(String username);
    Mono<User> findUserByEmail(String email);
}
