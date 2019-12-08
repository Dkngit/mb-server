package com.example.mbserver.dao;

import com.example.mbserver.entity.Team;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @since 2019/12/8
 */
public interface TeamPageRepository extends PagingAndSortingRepository<Team, Long> {

}
