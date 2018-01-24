package com.codeup.springbootblog.models;

import javax.persistence.*;


@Entity
@Table(name = "posts")
public class Post {


    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String body;

    //2.- In your User and Post classes, define the post - user relationship.
    // Log in to the mysql server and verify that the generated table structure matches what you are expecting.
    // Manually insert a user record in the database.

    @OneToOne(cascade = CascadeType.ALL)
    private User user;



    public Post() {
    }

    public Post(String title, String body, User owner) {
        this.title = title;
        this.body = body;
        this.user = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
