package com.codeup.springbootblog.controllers;

import com.codeup.springbootblog.models.Ad;
import com.codeup.springbootblog.services.AdService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Page to search posts
// 1. Create a form in the navigation bar
//    - Find the fragment and add a new one for the search form
// 2. Create a controller action to perform the search
//    - Create a SearchController
//    - Method to search by a term (GetMapping /search)
// 3. Write code to query the DB using the term sent by the user
///   - SearchService, will have a method search(term) -> select from posts where title like %term%
//    - probably start with an empty list, then query the DB
// 4 Create/reuse a template to loop over the result of the search
//    public String search(@PathVariable String term) {
//     return 'post/index';  // instead of 'posts/search-result'
//    }


@Controller
public class AdController {

    // Auto-wiring
    private AdService adService;

    // Dependency injection makes explicit.  Constructor and setter injection.
    public AdController(AdService service) {
        this.adService = service;
    }

    @GetMapping("/ads")
    public String allTheAds(Model viewModel) {
        List<Ad> ads = adService.findAll();
        viewModel.addAttribute("ads", ads);
        return "/ads/index";
    }

    @GetMapping("/ads/{id}")
    public String showIndividualAd(@PathVariable int id, Model viewModel) {
        Ad ad = adService.findOne(id);
        viewModel.addAttribute("ad", ad);
        return "ads/show";
    }

    @GetMapping("ads/new")
    // to catch the form
    public String showCreateAdForm(Model viewModel){
        //using the empty constructor I just created in the Ad class
        Ad ad = new Ad();
        viewModel.addAttribute("ad", ad);
        return "ads/new";
    }

    @PostMapping("ads/create")
    @ResponseBody
    // we are not using pathvariable here because is comming from a form
    public String saveAd(@RequestParam("title") String title, @RequestParam("description") String description){
        Ad ad = new Ad(title, description);
        adService.save(ad);
        return ad.getTitle() + " " + ad.getDescription();
    }






}
