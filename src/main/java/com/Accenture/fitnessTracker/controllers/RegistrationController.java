package com.Accenture.fitnessTracker.controllers;

import com.Accenture.fitnessTracker.model.User;
import com.Accenture.fitnessTracker.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/new")
    public String signUp(Model model){
        model.addAttribute("user", new User());

        return "registration.html";
    }

    @PostMapping("/user/save")
    public String registerUser(@ModelAttribute User user){
        userService.saveNewUser(user);

        return "redirect:/profile";
    }

}
