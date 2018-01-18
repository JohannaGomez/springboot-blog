package com.codeup.springbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostsController {

    @RequestMapping("/posts")
    public String allThePost() {
        // Inside the method that shows all the posts, create a new array list and add two post objects to it,
        // then pass that list to the view.
        ArrayList<String> posts = new ArrayList<>();
        posts.add("post1");
        posts.add("post2");

        return "/posts/index";
    }


    @RequestMapping("/posts/{id}")
    public String showIndividualPost(@PathVariable String id) {
        // Inside the method that shows an individual post, create a new post object and pass it to the view.
        Post post = new Post();
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
