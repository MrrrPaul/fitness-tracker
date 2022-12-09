package com.Accenture.fitnessTracker.services;

import com.Accenture.fitnessTracker.model.PasswordResetToken;
import com.Accenture.fitnessTracker.model.User;

public interface PasswordService {

    PasswordResetToken generateToken(String email);
    User processToken(String token);

}
