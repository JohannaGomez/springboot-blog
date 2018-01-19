package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.models.Post;
import com.codeup.springbootblog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostsController {

    private PostService service;

    public PostsController(PostService service) {
        this.service = service;
    }

    @GetMapping("/posts")
    public String allThePosts(Model viewModel) {
        List<Post> posts = service.findAll();
        viewModel.addAttribute("posts", posts);
//        return "/posts/index";
        return "/blog_template/index";
    }




    @GetMapping("/posts/{id}")
    public String showIndividualPost(@PathVariable int id, Model viewModel) {
        Post post =  service.findOne(id);
        viewModel.addAttribute("post", post);
        return "/posts/show";
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
