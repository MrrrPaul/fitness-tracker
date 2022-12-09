package com.Accenture.fitnessTracker.services.impl;

import com.Accenture.fitnessTracker.exceptions.BadRequestException;
import com.Accenture.fitnessTracker.model.PasswordResetToken;
import com.Accenture.fitnessTracker.model.User;
import com.Accenture.fitnessTracker.repositories.PasswordTokenRepository;
import com.Accenture.fitnessTracker.repositories.UserRepository;
import com.Accenture.fitnessTracker.services.MailService;
import com.Accenture.fitnessTracker.services.PasswordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Slf4j
@Service
public class PasswordServiceImpl implements PasswordService {

    private PasswordTokenRepository passwordTokenRepository;
    private UserRepository userRepository;
    private MailService mailService;

    public PasswordServiceImpl(PasswordTokenRepository passwordTokenRepository, UserRepository userRepository, MailService mailService) {
        this.passwordTokenRepository = passwordTokenRepository;
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    @Override
    public PasswordResetToken generateToken(String email) {
        Mono<org.apache.catalina.User> user = userRepository.findUserByEmail(email);

        if (user.block() == null){
            throw new BadRequestException("User does not exist with email: "+email);
        }

        PasswordResetToken token = new PasswordResetToken();
        token.setEmail(email);

        passwordTokenRepository.save(token).block();
        mailService.sendForgotPasswordMail(email, token);

        return token;
    }

    @Override
    public User processToken(String token) {

        Mono<PasswordResetToken> tokenToCheck = passwordTokenRepository.findByToken(token);

        if (tokenToCheck.block() == null){
            log.error("Token not found in database!");
            throw new BadRequestException("Token is not valid!");
        }

        if (tokenToCheck.block().getDateCreated().isBefore(LocalDate.now())){
            log.error("Token is not valid. Older than 24 hours! Deleting Token");
            passwordTokenRepository.delete(tokenToCheck.block()).block();
            throw new BadRequestException("Token is not valid!");
        }

        User user = (User) userRepository.findUserByEmail(tokenToCheck.block().getEmail()).block();

        passwordTokenRepository.delete(tokenToCheck.block()).block();

        return user;
    }
}
