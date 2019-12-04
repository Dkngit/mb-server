package com.example.mbserver.web;

import com.example.mbserver.dao.UserPageRepository;
import com.example.mbserver.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;

@RestController
@RequestMapping("api/user")
public class UsersController {

    @Resource
    private UserPageRepository userPageRepository;

    @RequestMapping("own")
    public char own(Principal principal) {
//        principal.
        return 's';
    }

    @RequestMapping("list")
    public Page<User> list(int pageIndex, int pageSize) {
        System.out.println(pageIndex);
        System.out.println(pageSize);
        return userPageRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }


}
