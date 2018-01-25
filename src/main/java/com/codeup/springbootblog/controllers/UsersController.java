package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    @GetMapping("/user/sign-up")
    public String showSignUpForm(Model viewModel) {
        viewModel.addAttribute("user", new User());
        return "blog_template/sign-up";
    }

//    private Users users;
//    private PasswordEncoder passwordEncoder;
//
//    public UsersController(Users users, PasswordEncoder passwordEncoder) {
//        this.users = users;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @GetMapping("/sign-up")
//    public String showSignupForm(Model model){
//        model.addAttribute("user", new User());
//        return "users/sign-up";
//    }
//
//    @PostMapping("/sign-up")
//    public String saveUser(@ModelAttribute User user){
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        users.save(user);
//        return "redirect:/login";
//    }


}
