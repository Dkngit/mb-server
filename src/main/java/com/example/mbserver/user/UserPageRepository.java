package com.example.mbserver.user;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPageRepository extends PagingAndSortingRepository<User, Long> {

}
