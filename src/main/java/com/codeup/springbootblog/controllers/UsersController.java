package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.daos.UsersRepository;
import com.codeup.springbootblog.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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
    public String singUpNewUser (@Valid User user, Errors validation, Model viewModel) {
        String username = user.getUsername();
        User existingUsername = usersRepository.findByUsername(username);
        User existingEmail = usersRepository.findByEmail(user.getEmail());



        if (existingUsername != null) {

            validation.rejectValue("username", "user.username", "Duplicated username " + username);

        }

        if (existingEmail != null) {

            validation.rejectValue("email", "user.email", "Duplicated email " + user.getEmail());

        }

        if (validation.hasErrors()) {
            viewModel.addAttribute("errors", validation);
            viewModel.addAttribute("user", user);
            return "users/sign-up";
        }



        // we need to hash passwords (using security configuration), after changing in the configuration class, create
        // the passwordEncoder in this controller.
        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);
        usersRepository.save(user);

        return "redirect:/login";

    }




    // Show user profile:
    @GetMapping("/user/profile")
    public String showProfile(Model viewModel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        viewModel.addAttribute("user", user);
        return "/users/profile";
    }


    // Edit user profile (show the form):
    @GetMapping("/user/{id}/edit")
    public String showEditForm(@PathVariable long id, Model viewModel){
        User user = usersRepository.findOne(id);
        viewModel.addAttribute("user", user);
        return "/users/edit_parent_profile";
    }

    // Edit user profile (populate the form):
    @PostMapping("/user/edit")
    public String updateUser(@ModelAttribute User user){
        usersRepository.save(user);
        return "redirect:/login";
    }

}
