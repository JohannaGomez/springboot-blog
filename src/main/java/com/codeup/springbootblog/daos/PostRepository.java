package com.codeup.springbootblog.daos;

import com.codeup.springbootblog.models.Post;
import org.springframework.data.repository.CrudRepository;

//=============================================================
//4.-Create an interface for posts that extends CrudRepository=
//=============================================================


public interface PostRepository  extends CrudRepository<Post, Long>{
    //Abstract interface
}
