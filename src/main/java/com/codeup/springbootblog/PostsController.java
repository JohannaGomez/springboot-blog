package com.codeup.springbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostsController {

    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "post index page";
    }


    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable String id) {
        return "view an individual post";
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
