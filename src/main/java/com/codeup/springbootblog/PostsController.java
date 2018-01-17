package com.codeup.springbootblog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

public class PostsController {

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public int division(@PathVariable int num1, @PathVariable int num2){
        return num1 / num2;
    }
}
