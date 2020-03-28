package com.example.mbserver.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * @since 2019/12/7
 */
@Entity
//@Table(name = "team")
public class Team extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "team")
    private Set<TeamServer> servers;

    @ManyToMany(mappedBy = "team")
    private Set<User> user;

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

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
