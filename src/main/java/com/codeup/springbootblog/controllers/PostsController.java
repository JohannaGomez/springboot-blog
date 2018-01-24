package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.daos.PostRepository;
import com.codeup.springbootblog.daos.UsersRepository;
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

    private PostRepository postDao;

    private UsersRepository usersDao;

    public PostsController(PostService postService, PostRepository postDao, UsersRepository usersDao) {
        this.postService = postService;
        this.postDao = postDao;
        this.usersDao = usersDao;
    }

    @GetMapping("/posts")
    public String allThePosts(Model viewModel) {
        viewModel.addAttribute("posts", postDao.findAll());
        return "/blog_template/index";
    }




    @GetMapping("/posts/{id}")
    public String showIndividualPost(@PathVariable int id, Model viewModel) {
        Post post =  postService.findOne(id);
        viewModel.addAttribute("post", post);
        return "/blog_template/show";
    }


    @GetMapping("posts/new")
    // to catch the form
    // "/new" is to create a new post and "/create" is the one that is going to show that it was created.
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

    @GetMapping("posts/{id}/delete")
    public String deletePost(@PathVariable long id, Model viewModel){
        postService.delete(id);
        return "redirect:/posts";
    }


    @PostMapping("posts/edit")
    public String updatePost(@ModelAttribute Post post){
        postService.update(post);
        return "redirect:/posts";
    }





}
