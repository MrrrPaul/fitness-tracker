package com.Accenture.fitnessTracker.controllers;

import com.Accenture.fitnessTracker.model.PasswordResetToken;
import com.Accenture.fitnessTracker.model.User;
import com.Accenture.fitnessTracker.services.PasswordService;
import com.Accenture.fitnessTracker.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PasswordResetController {

    private PasswordService passwordService;
    private UserService userService;

    public PasswordResetController(PasswordService passwordService, UserService userService) {
        this.passwordService = passwordService;
        this.userService = userService;
    }

    @PostMapping("/forgot_password")
    public String forgotPassword(@ModelAttribute("PasswordResetToken") PasswordResetToken token) {
        passwordService.generateToken(token.getEmail());

        return "redirect:/home";
    }

    @GetMapping("/process/{token}")
    public String processForgotPassword(Model model, @PathVariable String token) {
        User user = passwordService.processToken(token);
        model.addAttribute("user", user);

        return "changepassword.html";
    }

    @PostMapping("/update_password")
    public String updatePassword(@ModelAttribute User user) {
        userService.updatePassword(user);

        return "redirect:/home";
    }

}
