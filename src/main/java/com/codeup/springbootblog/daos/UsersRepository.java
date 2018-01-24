package com.codeup.springbootblog.daos;

import com.codeup.springbootblog.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//3 .- Create a UsersRepository class and inject it into the PostsController.

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
    //    "Long" is the type of the primary key.

}
