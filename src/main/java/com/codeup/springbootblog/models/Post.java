package com.codeup.springbootblog.models;

import javax.persistence.*;

//======================================================================
//1.- Create a new database and database user for your application.    =
//3.- Add the appropriate JPA annotations to your Post class.          =
//======================================================================

//@Entity is applied to the class which is going to be a table in the database:
@Entity
@Table(name = "posts")
public class Post {

    // @Id --> telling spring that this is going to be a primary key which is applied to one of my variables
    // @GeneratedValue --> how the Id is going to be generated (automatic)
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String body;

    public Post() {
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
