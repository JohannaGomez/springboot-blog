package com.codeup.springbootblog.services;

import com.codeup.springbootblog.models.Post;
import org.springframework.stereotype.Service;

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
        // create some ad objects and add them to the ads list
        // with the save method
        save(new Post("post a", "post  a"));
        save(new Post("post B", "post  b"));
        save(new Post("post C", "post  c"));
    }
}
