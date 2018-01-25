package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.daos.UsersRepository;
import com.codeup.springbootblog.models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    private UsersRepository usersRepository;

    private PasswordEncoder encoder;

    public UsersController(UsersRepository usersRepository, PasswordEncoder encoder) {
        this.usersRepository = usersRepository;
        this.encoder = encoder;
    }

    @GetMapping("/user/sign-up")
    public String showSignUpForm(Model viewModel) {
        // new User to catch the form
        viewModel.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/user/sign-up")
    public String singUpNewUser (@ModelAttribute User user) {
        // we need to hash passwords (using security configuration), after changing in the configuration class, create
        // the passwordEncoder in this controller.
        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);
        usersRepository.save(user);

        return "redirect:/login";

    }

}