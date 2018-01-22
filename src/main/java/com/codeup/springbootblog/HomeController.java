package com.codeup.springbootblog;

import com.codeup.springbootblog.daos.PostRepository;
import com.codeup.springbootblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public int addition(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2;
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public int subtraction(@PathVariable int num1, @PathVariable int num2) {
        return num2 - num1;
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public int multiplication(@PathVariable int num1, @PathVariable int num2) {
        return num1 * num2;
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public int division(@PathVariable int num1, @PathVariable int num2) {
        return num1 / num2;
    }



//    private PostRepository postDao;
//
//    public HomeController(PostRepository postDao) {
//        this.postDao = postDao;
//    }
//
//    @GetMapping("/dao-test")
//    @ResponseBody
//    public String daoTest() {
//        Iterable<Post> posts = postDao.findAll();
//        for (Post post: posts){
//            System.out.println("-------");
//            System.out.println("#" + post.getId());
//            System.out.println("description: " + post.getBody());
//        }
//        return "check your console";
//    }


}