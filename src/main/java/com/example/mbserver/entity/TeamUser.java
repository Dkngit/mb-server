package com.example.mbserver.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @since 2020/3/31
 */
@Entity
public class TeamUser extends BaseEntity {

    private String name;
    private int experience;

    //    @JsonBackReference(value = "team-teamUser")
    @ManyToOne
    @JoinColumn(nullable = false)
    private Team team;

    //    @JsonBackReference(value = "user-teamUser")
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
