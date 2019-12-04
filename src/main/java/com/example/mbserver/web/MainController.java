package com.example.mbserver.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class MainController {

    @RequestMapping("/")
//    @CrossOrigin(origins="http://localhost:8090", maxAge=3600)
    public String index() {
        return "index";
    }

//    @RequestMapping("/user")
////    @CrossOrigin(origins = "http://localhost:8090", maxAge = 3600, allowedHeaders = {"authorization", "x-auth-token", "x-requested-with", "x-xsrf-token"})
//    public Principal user(Principal user) {
//        return user;
//    }


    @RequestMapping("/resource")
//    @CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = {"x-auth-token", "x-requested-with", "x-xsrf-token"})
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }
}
