package com.example.mbserver.security;

import com.example.mbserver.dao.UserPageRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MBUserDetailsService implements UserDetailsService {

    @Resource
    private UserPageRepository userPageRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MBUserDetails(userPageRepository.findUserByUsername(username));
    }
}
