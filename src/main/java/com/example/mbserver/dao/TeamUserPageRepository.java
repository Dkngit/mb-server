package com.example.mbserver.dao;

import com.example.mbserver.entity.TeamUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TeamUserPageRepository extends PagingAndSortingRepository<TeamUser, Long> {

//    TeamUser findUserByUsername(String username);

//    Page<TeamUser> findAllByRolesIn(Set<String> role, Pageable pageable);

}
