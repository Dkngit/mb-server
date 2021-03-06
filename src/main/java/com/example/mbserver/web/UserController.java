package com.example.mbserver.web;

import com.example.mbserver.dao.UserPageRepository;
import com.example.mbserver.entity.User;
import com.example.mbserver.pojo.MBPageRequest;
import com.example.mbserver.security.MBUserDetails;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Collections;
import java.util.Date;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Resource
    private UserPageRepository userPageRepository;


    @RequestMapping("login")
    public User login(@AuthenticationPrincipal MBUserDetails userDetails) {
//        Authentication authentication = (Authentication) principal;
//        authentication.getPrincipal();

        User user = userDetails.getUser();
        user.setPassword(null);

        return user;
    }

    @RequestMapping("passwordEdit")
    public void passwordEdit(@RequestBody User sendUser, @AuthenticationPrincipal MBUserDetails userDetails) {
        User user = userPageRepository.findUserByUsername(userDetails.getUsername());
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(passwordEncoder.encode(sendUser.getPassword()));
        userPageRepository.save(user);
    }

    @RequestMapping("list")
    public Page<User> list(@RequestBody MBPageRequest pageR) {
        return userPageRepository.findAllByRolesIn(Collections.singleton("ROLE_USER"), pageR.pageable());
    }

    @RequestMapping("save")
    public void save(@RequestBody User user, Principal principal) {
        Date now = new Date();
        String name = principal.getName();
        if (user.getId() == 0) {
            user.setCreateOn(now);
            user.setCreateBy(name);

//            Set<String> roles = user.getRoles();
//            roles.add("ROLE_USER");
            user.setRoles(Collections.singleton("ROLE_USER"));

            user.setEnabled(true);
        } else {
            user.setModifyOn(now);
            user.setModifyBy(name);
        }

        if (StringUtils.hasText(user.getNewPassword())) {
            PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            user.setPassword(passwordEncoder.encode(user.getNewPassword()));
        }

        userPageRepository.save(user);
    }

    @RequestMapping("delete")
    public void delete(@RequestBody User user) {
        userPageRepository.deleteById(user.getId());
    }


}
