package com.example.mbserver.service.impl;

import com.example.mbserver.dao.TeamUserPageRepository;
import com.example.mbserver.dao.UserPageRepository;
import com.example.mbserver.entity.TeamUser;
import com.example.mbserver.entity.User;
import com.example.mbserver.service.TeamUserService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Collections;
import java.util.Date;

@Service
public class TeamUserServiceImpl implements TeamUserService {

    @Resource
    private TeamUserPageRepository teamUserPageRepository;
    @Resource
    private UserPageRepository userPageRepository;

    public void save(TeamUser teamUser, Principal principal) {
        Date now = new Date();
        String name = principal.getName();
        if (teamUser.getId() == 0) {
            teamUser.setCreateOn(now);
            teamUser.setCreateBy(name);
//            teamUser.setRoles(Collections.singleton("ROLE_USER"));
//            Set<String> roles = user.getRoles();
//            roles.add("ROLE_USER");

            User user = teamUser.getUser();

            if (StringUtils.hasText(user.getNewPassword())) {
                PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
                user.setPassword(passwordEncoder.encode(user.getNewPassword()));
            }

            user.setRoles(Collections.singleton("ROLE_USER"));
            userPageRepository.save(user);

//            teamUser.setUser(user);
        } else {
            teamUser.setModifyOn(now);
            teamUser.setModifyBy(name);
        }


        teamUserPageRepository.save(teamUser);
    }
}
