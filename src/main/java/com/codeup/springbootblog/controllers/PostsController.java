package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.models.Ad;
import com.codeup.springbootblog.models.Post;
import com.codeup.springbootblog.services.PostService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// Dependency injection
// 1.- Constructor injection (preferred) --> required dependencies
// 2.- Setter injection --> optional dependencies

@Controller
public class PostsController {

    //    1.- Create an instance variable with your dependency.

    private final PostService postService;

    //    2.- Inject the dependency through the constructor and assign it to your instance variable

    public PostsController(PostService service) {
        this.postService = service;  // This is the 1st time we assign something to postService.  When using final, we can not
        // assign it anything else.
    }

    @GetMapping("/posts")
    public String allThePosts(Model viewModel) {
        Post post = new Post();
        List<Post> posts = postService.findAll();
        viewModel.addAttribute("posts", posts);
        viewModel.addAttribute("post", post);
//        return "/posts/index";      -- This is my old index --
        return "/blog_template/index";    // -- This is the bootstrap template //
    }




    @GetMapping("/posts/{id}")
    public String showIndividualPost(@PathVariable int id, Model viewModel) {
        Post post =  postService.findOne(id);
        viewModel.addAttribute("post", post);
//        return "/posts/show";
        return "/blog_template/show";
    }


    @GetMapping("posts/new")
    // to catch the form
    public String showCreatePostForm(Model viewModel){
        Post post = new Post();
        viewModel.addAttribute("post", post);
        return "/blog_template/new";
    }

    @PostMapping("posts/create")
    @ResponseBody
    // we are not using pathvariable here because is comming from a form
    public String savePost(@ModelAttribute Post post){
        postService.save(post);
        return post.getTitle() + " " + post.getBody();
    }

    @GetMapping("posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model viewModel){
        Post post = postService.findOne(id);
        viewModel.addAttribute("post", post);
        return "/blog_template/edit";
    }

    @PostMapping("posts/edit")
    public String updatePost(@ModelAttribute Post post){
        postService.update(post);
        return "redirect:/posts";
    }
}
