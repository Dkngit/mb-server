package com.example.mbserver.dao;

import com.example.mbserver.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByUsername(String username);

}
