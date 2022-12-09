package com.Accenture.fitnessTracker.services;

import com.Accenture.fitnessTracker.model.PasswordResetToken;

public interface MailService {

    void sendForgotPasswordMail(String email, PasswordResetToken token);

}
