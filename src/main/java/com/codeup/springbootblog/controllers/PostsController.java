package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.daos.PostRepository;
import com.codeup.springbootblog.daos.UsersRepository;
import com.codeup.springbootblog.models.Ad;
import com.codeup.springbootblog.models.Post;
import com.codeup.springbootblog.models.User;
import com.codeup.springbootblog.services.PostService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
public class PostsController {


    private final PostService postService;


    private UsersRepository usersDao;

    public PostsController(PostService postService, UsersRepository usersDao) {
        this.postService = postService;
        this.usersDao = usersDao;
    }

    @GetMapping("/")
    public String allThePosts(Model viewModel) {
        // to test if the authentication works, I need to sout it:
//        User user = usersDao.findByUsername("pao");
//        System.out.println(user.getEmail());

        viewModel.addAttribute("posts", postService.findAll());
        return "/blog_template/index";
    }




    @GetMapping("/posts/{id}")
    public String showIndividualPost(@PathVariable int id, Model viewModel) {
        Post post =  postService.findOne(id);
        User user = post.getUser();
        viewModel.addAttribute("user", user);
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
    // we are not using pathvariable here because is comming from a form
    public String savePost(@ModelAttribute Post post){
        // this is coming form the db, and UserWithRoles is not mapped.
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(usersDao.findOne(user.getId()));
        postService.save(post);
        return "redirect:/";
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
        return "redirect:/";
    }


    @PostMapping("posts/edit")
    public String updatePost(@ModelAttribute Post post){
        postService.update(post);
        return "redirect:/";
    }


    // feature:  ability a user has in my application (follow a friend, mass text, program an event)
    //


}
