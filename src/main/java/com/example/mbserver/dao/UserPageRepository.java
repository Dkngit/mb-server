package com.example.mbserver.dao;

import com.example.mbserver.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPageRepository extends PagingAndSortingRepository<User, Long> {

}
