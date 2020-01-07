package com.example.mbserver.dao;

import com.example.mbserver.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPageRepository extends PagingAndSortingRepository<User, Long> {

    User findUserByUsername(String username);

    Page<User> findAllByRolesContains(String role, Pageable pageable);
}
