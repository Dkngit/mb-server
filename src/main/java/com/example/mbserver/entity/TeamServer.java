package com.example.mbserver.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @since 2019/12/7
 */
@Entity
public class TeamServer extends BaseEntity {

    @ManyToOne
    @JoinColumn(nullable = false)
    private Team team;
    private String name;
    private String ip;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
