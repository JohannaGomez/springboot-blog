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

    private PostRepository postRepository;


    private UsersRepository usersDao;

    public PostsController(PostService postService, PostRepository postRepository, UsersRepository usersDao) {
        this.postService = postService;
        this.usersDao = usersDao;
        this.postRepository = postRepository;
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

    @PostMapping("/posts/search")
    public String search(@RequestParam(name = "term") String term, Model viewModel) {
        term = "%"+term+"%";
        viewModel.addAttribute("posts", postRepository.findByBodyIsLikeOrTitleIsLike(term, term));
        return "blog_template/results_of_search";
    }

    // Show all the posts by user:
    @GetMapping("/postsByUser")
    public String postByUser(Model viewModel) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        viewModel.addAttribute("posts", postRepository.findByUser(user));
        return "/users/posts_by_user";
    }





}
