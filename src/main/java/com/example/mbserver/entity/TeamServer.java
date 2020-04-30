package com.example.mbserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

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

    @JsonIgnore
    @OneToMany(mappedBy = "teamServer", fetch = FetchType.LAZY)
    private Set<Activity> activities;

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

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
