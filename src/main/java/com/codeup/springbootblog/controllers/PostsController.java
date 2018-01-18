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

    @RequestMapping("/posts")
    public String allThePosts(Model viewModel) {
        // Inside the method that shows all the posts, create a new array list and add two post objects to it,
        // then pass that list to the view.
        List<Post> posts = service.findAll();
        viewModel.addAttribute("posts", posts);
        return "/posts/index";
    }




    @RequestMapping("/posts/{id}")
    public String showIndividualPost(@PathVariable int id, Model viewModel) {
        // Inside the method that shows an individual post, create a new post object and pass it to the view.
        Post post = new Post("my first post", "xxxxxxxxxxxyyyyyyyyyyyyy11111111111");
        viewModel.addAttribute("post", post);
        return "/posts/show";
    }


    @RequestMapping("/posts/create")
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
