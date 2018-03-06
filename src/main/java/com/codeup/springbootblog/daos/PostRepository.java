package com.codeup.springbootblog.daos;

import com.codeup.springbootblog.models.Post;
import com.codeup.springbootblog.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//=============================================================
//4.-Create an interface for posts that extends CrudRepository=
//=============================================================


public interface PostRepository  extends CrudRepository<Post, Long>{
    //Abstract interface
    List<Post> findByUser(User user);
}
