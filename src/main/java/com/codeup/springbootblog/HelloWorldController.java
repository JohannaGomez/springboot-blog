package com.codeup.springbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @GetMapping("/say/{greeting}/to/{name}")
    @ResponseBody
    public String greet(@PathVariable String greeting, @PathVariable String name){
        return greeting + " " + name + "!";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld () {
        return "hello, World!";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "hello, " + name + "!";
    }
}
