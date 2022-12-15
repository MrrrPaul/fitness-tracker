package com.Accenture.fitnessTracker.services;

import com.Accenture.fitnessTracker.model.User;
import com.Accenture.fitnessTracker.model.PasswordResetToken;

public interface PasswordService {

    PasswordResetToken generateToken(String email);
    User processToken(String token);

}
