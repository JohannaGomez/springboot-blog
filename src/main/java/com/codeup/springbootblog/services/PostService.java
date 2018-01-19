package com.codeup.springbootblog.services;

import com.codeup.springbootblog.models.Post;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> posts;


    public PostService() {
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post save(Post post) {
        // Generates a consecutive number
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post findOne(long id) {
        return posts.get((int)(id - 1));
    }

    private void createPosts() {
        // create some post objects and add them to the posts list
        // with the save method
        save(new Post("How To Write A Blog Post: Your 5-Point Checklist To Rock A Perfect Post", "Creating the perfect blog post sounds like a tall order, and maybe laying claim to it sounds a bit pretentious.\n" +
                "\n" +
                "Is there even such a thing as a “perfect” blog post?\n" +
                "\n" +
                "Perfection looks a bit different for each person. What is perfect for your blog post isn’t for mine.\n" +
                "\n" +
                "But there are qualities to that perfect post that apply to every blogger, no matter what the final outcome looks like."));
        save(new Post("Labour MP Pat McFadden is trying to get to the bottom of how Carillion lurched into liquidation on Monday morning.", "He’s asked business secretary Greg Clark to answer 10 questions -- including how much the crisis will cost the taxpayer, and what discussions went on behind the scenes in recent weeks as Carillion tried to stay afloat."));
        save(new Post("Lorem Ipsum Generator", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Eget arcu dictum varius duis at. Pulvinar proin gravida hendrerit lectus a. Mattis ullamcorper velit sed ullamcorper morbi. Enim tortor at auctor urna. Consequat mauris nunc congue nisi vitae suscipit tellus mauris. Augue mauris augue neque gravida in fermentum et sollicitudin ac. Amet nisl purus in mollis nunc sed id semper risus. Scelerisque fermentum dui faucibus in. Pellentesque pulvinar pellentesque habitant morbi tristique."));
    }

    @GetMapping("posts/new")
    public String showCreatePostForm(){
        return "posts/new";

    }
}
