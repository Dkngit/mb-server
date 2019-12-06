package com.example.mbserver;

import com.example.mbserver.user.User;
import com.example.mbserver.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.Collections;

@SpringBootApplication
public class MbServerApplication {

    @Resource
    private UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(MbServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MbServerApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        System.out.println("hello world, I have just started up");
//        log.info("hello world, I have just started up");
        User admin = userRepository.findUserByUsername("admin");
        if (admin == null) {
            admin = new User();
            admin.setEnabled(true);
            PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setUsername("admin");

            admin.setRoles(Collections.singleton("ROLE_ADMIN"));

            userRepository.save(admin);
//			System.out.println("new admin User, username:admin, password:admin");
            log.info("new admin User, username:admin, password:admin");
        }
    }

}
