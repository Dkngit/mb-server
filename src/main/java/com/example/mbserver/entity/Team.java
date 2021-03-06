package com.example.mbserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

/**
 * @since 2019/12/7
 */
@Entity
//@Table(name = "team")
public class Team extends BaseEntity {

    private String name;

    //    @JsonIgnore
    @OneToMany(mappedBy = "team")
    private Set<TeamServer> servers;

    //    @JsonManagedReference(value = "team-teamUser")
    @JsonIgnore
    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private Set<TeamUser> teamUser;

    public Set<TeamUser> getTeamUser() {
        return teamUser;
    }

    public void setTeamUser(Set<TeamUser> teamUser) {
        this.teamUser = teamUser;
    }

//    @ManyToMany(mappedBy = "team")
//    private Set<User> user;

//    public Set<User> getUser() {
//        return user;
//    }
//
//    public void setUser(Set<User> user) {
//        this.user = user;
//    }

    public Set<TeamServer> getServers() {
        return servers;
    }

    public void setServers(Set<TeamServer> servers) {
        this.servers = servers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
