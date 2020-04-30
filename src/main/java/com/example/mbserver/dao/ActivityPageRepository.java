package com.example.mbserver.dao;

import com.example.mbserver.entity.Activity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @since 2020/4/30
 */
public interface ActivityPageRepository extends PagingAndSortingRepository<Activity, Long> {

}
