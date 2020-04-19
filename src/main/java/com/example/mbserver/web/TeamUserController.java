package com.example.mbserver.web;

import com.example.mbserver.dao.TeamUserPageRepository;
import com.example.mbserver.dao.UserPageRepository;
import com.example.mbserver.entity.TeamUser;
import com.example.mbserver.entity.User;
import com.example.mbserver.pojo.MBPageRequest;
import com.example.mbserver.security.MBUserDetails;
import com.example.mbserver.service.TeamUserService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("api/team/user")
public class TeamUserController {

    @Resource
    private TeamUserPageRepository teamUserPageRepository;
    @Resource
    private UserPageRepository userPageRepository;
    @Resource
    private TeamUserService teamUserService;

//    @RequestMapping("passwordEdit")
//    public void passwordEdit(@RequestBody User sendUser, @AuthenticationPrincipal MBUserDetails userDetails) {
//        User user = userPageRepository.findUserByUsername(userDetails.getUsername());
//        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        user.setPassword(passwordEncoder.encode(sendUser.getPassword()));
//        userPageRepository.save(user);
//    }

    @RequestMapping("list")
    public Page<TeamUser> list(@RequestBody MBPageRequest pageR) {
        return teamUserPageRepository.findAll(pageR.pageable());
//        return teamUserPageRepository.findAllByRolesIn(Collections.singleton("ROLE_USER"), pageR.pageable());
    }

    @RequestMapping("save")
    public void save(@RequestBody TeamUser teamUser, Principal principal) throws Exception {
        teamUserService.save(teamUser, principal);
    }

    @RequestMapping("delete")
    public void delete(@RequestBody TeamUser teamUser) {
        teamUserPageRepository.deleteById(teamUser.getId());
    }


}
