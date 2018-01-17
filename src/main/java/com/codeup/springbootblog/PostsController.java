package com.codeup.springbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostsController {

    @RequestMapping("/posts")
    @ResponseBody
    public String index() {
        return "post index page";
    }


    @RequestMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable String id) {
        return "view an individual post" + id;
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
