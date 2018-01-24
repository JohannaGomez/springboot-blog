package com.codeup.springbootblog.models;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    //1.- Create a User class, with (at least) fields for id, username, email, and password.
    @Id  @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String password;

    //2.- In your User and Post classes, define the post - user relationship.
    // Log in to the mysql server and verify that the generated table structure matches what you are expecting.
    // Manually insert a user record in the database.

//    @OneToOne(cascade = CascadeType.ALL)
//    private User owner;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ad")
//    private List<AdImage> images;


}
