package com.example.mbserver.service;

import com.example.mbserver.entity.TeamUser;

import java.security.Principal;

public interface TeamUserService {

    void save(TeamUser teamUser, Principal principal) throws Exception;
}
