package com.codeup.springbootblog.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    //1.- Create a User class, with (at least) fields for id, username, email, and password.
    @Id  @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Username can't be empty")
    @Size(min = 8, message = "Username must be at least 8 characters.")
    private String username;


    @Column(nullable = false, unique = true)
    @NotBlank(message = "email can't be empty")
    @Size(min = 8, message = "email must be valid.")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "password can't be empty")
    @Size(min = 8, message = "Password must be at least 8 characters.")
    private String password;

    @Column
    private String profile_pic;


    // one user can have a few posts.  User is the main character.  Cascade all means is not going to allow
    // to have empty users for a post.
    // Data type list for the posts and the name of the instance in plural.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;


    public User() {

    }

    // It is cloning the user (for security measures):
    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
        profile_pic = copy.profile_pic;
    }

    public User(String username, String email, String password, String profile_pic) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profile_pic = profile_pic;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    // Getters and setters for List<Post> for when is time to ask f
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }



}
