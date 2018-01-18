package com.codeup.springbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.title;

@Controller
public class PostsController {

    @RequestMapping("/posts")
    public String allThePosts(Model viewModel) {
        // Inside the method that shows all the posts, create a new array list and add two post objects to it,
        // then pass that list to the view.
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post("my first post", "xxxxxxxxxxxyyyyyyyyyyyyy11111111111"));
        posts.add(new Post("my second post", "xxxxxxxxxxxyyyyyyyyyyyyy222222222222222"));
        viewModel.addAttribute("posts", posts);
        return "/posts/index";
    }




    @RequestMapping("/posts/{id}")
    public String showIndividualPost(@PathVariable int id, Model viewModel) {
        // Inside the method that shows an individual post, create a new post object and pass it to the view.
        Post post = new Post("my first post", "xxxxxxxxxxxyyyyyyyyyyyyy11111111111");
//        post.getTitle();
//        post.getBody();
        viewModel.addAttribute("post", post);
//        viewModel.addAttribute("title", title);
//        viewModel.addAttribute("body", body);
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
