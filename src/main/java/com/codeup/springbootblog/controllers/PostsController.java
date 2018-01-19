package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.models.Post;
import com.codeup.springbootblog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Page to search posts
//create a form in the navigation bar
//find the fragment and add a new one for the search form

// Dependency injection
// 1.- Constructor injection (preferred) --> required dependencies
// 2.- Setter injection --> optional dependencies

@Controller
public class PostsController {

    //    1.- Create an instance variable with your dependency.

    private final PostService service;

    //    2.- Inject the dependency through the constructor and assign it to your instance variable

    public PostsController(PostService service) {
        this.service = service;  // This is the 1st time we assign something to service.  When using final, we can not
        // assign it anything else.
    }

    @GetMapping("/posts")
    public String allThePosts(Model viewModel) {
        List<Post> posts = service.findAll();
        viewModel.addAttribute("posts", posts);
//        return "/posts/index";      -- This is my old index --
        return "/blog_template/index";    // -- This is the bootstrap template //
    }




    @GetMapping("/posts/{id}")
    public String showIndividualPost(@PathVariable int id, Model viewModel) {
        Post post =  service.findOne(id);
        viewModel.addAttribute("post", post);
        return "/posts/show";
//        return "/blog_template/show";
    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "view the form for creating a form";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "create a new post";
    }


}
