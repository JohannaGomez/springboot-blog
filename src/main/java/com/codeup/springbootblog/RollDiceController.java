package com.codeup.springbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String landing(){
        return "roll-dice";
    }


    @GetMapping("/roll-dice/{num1}")
    public String rollDice(@PathVariable int num1, Model viewModel) {
        // random number:
        int random = (int)(Math.random() * 6) + 1;

        // the above if/else can be re-written as:
        // var message = (success) ? "Operation was successful." : "Oops, something went wrong.";

        boolean winner = (random == num1) ? true : false;


        viewModel.addAttribute("num1", num1);
        viewModel.addAttribute("random", random);
        viewModel.addAttribute("winner", winner);
        return "roll-dice";

    }

}


//    public static int randomWithRange(int min, int max)
//    {
//        int range = (max - min) + 1;
//        return (int)(Math.random() * range) + min;
//    }
//
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