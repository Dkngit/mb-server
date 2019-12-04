package com.example.mbserver.web;

import com.example.mbserver.dao.UserPageRepository;
import com.example.mbserver.domain.User;
import com.example.mbserver.security.MBUserDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/user")
public class UsersController {

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

    @RequestMapping("list")
    public Page<User> list(int pageIndex, int pageSize) {
        System.out.println(pageIndex);
        System.out.println(pageSize);
        return userPageRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }


}
