package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.daos.PostRepository;
import com.codeup.springbootblog.daos.UsersRepository;
import com.codeup.springbootblog.models.Post;
import com.codeup.springbootblog.models.User;
import com.codeup.springbootblog.services.PostService;
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
import java.time.LocalDate;
import java.util.Date;

@Controller
public class UsersController {

    private UsersRepository usersRepository;

    private PostRepository postRepository;

    private PostService postService;

    private PasswordEncoder encoder;

    public UsersController(UsersRepository usersRepository, PostRepository postRepository, PostService postService, PasswordEncoder encoder) {
        this.usersRepository = usersRepository;
        this.postRepository = postRepository;
        this.postService = postService;
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
        return "/users/edit_profile";
    }

    // Edit user profile (populate the form):
    @PostMapping("/user/edit")
    public String updateUser(@ModelAttribute User user){
        usersRepository.save(user);
        return "redirect:/login";
    }

    // Show all the posts by user:
    @GetMapping("/user/posts")
    public String postByUser(Model viewModel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        viewModel.addAttribute("posts", postRepository.findByUser(user));
        return "/users/posts_by_user";
    }

    // "/new" is to create a new post and "/create" is the one that is going to show that it was created.

    //  Create a new post (to catch the form):
    @GetMapping("/user/posts/new")
    public String showCreatePostForm(Model viewModel){
        Post post = new Post();
        viewModel.addAttribute("post", post);
        return "/blog_template/new";
    }

    // Create a new post (populate the form):
    @PostMapping("/user/posts/create")
    // we are not using path variable here because is comming from a form
    public String savePost(@ModelAttribute Post post){
        // this is coming form the db, and UserWithRoles is not mapped.
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(usersRepository.findOne(user.getId()));
        postRepository.save(post);
        return "redirect:/";
    }

    // Edit a post (show the form):
    @GetMapping("/user/posts/{id}/edit")
    public String showEditPostForm(@PathVariable long id, Model viewModel){
        Post post = postRepository.findOne(id);
        Date createdOn = post.getCreateDate();
        System.out.println(" +++++++++++++++  this is the date when the post was created: " + createdOn);
        postRepository.save(post);
        viewModel.addAttribute("post", post);
        return "/blog_template/edit";
    }

    // Edit a post (populate the form):
    @PostMapping("/user/posts/edit")
    public String updatePost(@ModelAttribute Post post){
        Post post2bUpdated = postRepository.findOne(post.getId());
        post2bUpdated.setTitle(post.getTitle());
        post2bUpdated.setSubtitle(post.getSubtitle());
        post2bUpdated.setCreateDate(post2bUpdated.getCreateDate());
        postService.update(post2bUpdated);
        return "redirect:/";
    }


    // Delete a post record:
    @GetMapping("/user/posts/{id}/delete")
    public String deletePost(@PathVariable long id, Model viewModel){
        postService.delete(id);
        return "redirect:/";
    }


}
