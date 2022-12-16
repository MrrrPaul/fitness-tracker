package com.Accenture.fitnessTracker.repositories;

import com.Accenture.fitnessTracker.model.PasswordResetToken;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PasswordTokenRepository extends ReactiveCrudRepository<PasswordResetToken, String> {

    Mono<PasswordResetToken> findByToken(String token);
}
