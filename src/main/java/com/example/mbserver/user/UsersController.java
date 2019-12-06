package com.example.mbserver.user;

import com.example.mbserver.security.MBUserDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/user")
public class UsersController {

    @Resource
    private UserPageRepository userPageRepository;
    @Resource
    private UserRepository userRepository;


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
        User user = userRepository.findUserByUsername(userDetails.getUsername());
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(passwordEncoder.encode(sendUser.getPassword()));
        userRepository.save(user);
    }

    @RequestMapping("list")
    public Page<User> list(int pageIndex, int pageSize) {
        System.out.println(pageIndex);
        System.out.println(pageSize);
        return userPageRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }


}
