package com.example.mbserver.entity;


import javax.persistence.*;

/**
 * @since 2020/3/31
 */
@Entity
public class TeamUser extends BaseEntity {

    private String name;
    private int experience;

//    @OneToOne(mappedBy = "teamUser")
    @ManyToOne
    @JoinColumn(nullable = false)
    private Team team;

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
