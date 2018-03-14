package com.codeup.springbootblog.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "posts")
public class Post {


    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String subtitle;

    @Column(columnDefinition = "TEXT")
    private String body;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

//    @UpdateTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "modify_date")
//    private Date modifyDate;

    @ManyToOne
    @JoinColumn(name="user_id")  //This line is not necessary bc User hast the mapping to user in the one to many
    private User user;



    public Post() {
    }

    public Post(String title, String subtitle, String body, User user) {
        this.title = title;
        this.subtitle = subtitle;
        this.body = body;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

//    public Date getModifyDate() {
//        return modifyDate;
//    }
//
//    public void setModifyDate(Date modifyDate) {
//        this.modifyDate = modifyDate;
//    }
}
