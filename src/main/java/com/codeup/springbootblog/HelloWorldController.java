package com.codeup.springbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @GetMapping("/say/{greeting}/to/{name}")
    @ResponseBody
    public String greet(@PathVariable String greeting, @PathVariable String name){
        return greeting + " " + name + "!";
    }

    @GetMapping("/hello")
    public String helloWorld () {
        return "hello";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model viewModel) {
        viewModel.addAttribute("name", name);
        return "hello";
    }


//    public static int randomWithRange(int min, int max) {
//        int range = (max - min) + 1;
//        return (int)(Math.random() * range) + min;
//    }

    @GetMapping("/roll-dice/{num1}")
    public String rollDice(@PathVariable int num1, Model viewModel) {
        viewModel.addAttribute("num1", num1);
        return "roll-dice";

    }
}



//    public static void rollDiceGame(Scanner sc) {
//        String userChoice;
//        System.out.print("Please enter the number of sides for the dice: ");
//        int nSides = getInteger(1, 20);
//        do {
//            System.out.println("You have rolled a " + randomWithRange(1, nSides) + " and a " + randomWithRange(1, nSides));
//            do {
//                System.out.println("Would you like to roll again? [y/n]");
//                userChoice = sc.next().trim();
//            } while (!userChoice.equalsIgnoreCase("y") & !userChoice.equalsIgnoreCase("n"));
//
//        } while (!userChoice.equals("n"));
//    }

