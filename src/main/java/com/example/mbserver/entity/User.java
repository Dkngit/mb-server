package com.example.mbserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    /**
     * 用户名
     */
    private String username;
    private String nickname;
    private String email;
    private String phone;
    private String password;
    @Transient
    private String newPassword;
    private boolean enabled;
    private boolean tokenExpired;
//    private Date createDate;
//    private Date modifyDate;

    //    @JsonManagedReference(value = "user-teamUser")
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<TeamUser> teamUsers;

    public Set<TeamUser> getTeamUsers() {
        return teamUsers;
    }

    public void setTeamUsers(Set<TeamUser> teamUsers) {
        this.teamUsers = teamUsers;
    }

//    @ManyToMany(fetch = FetchType.EAGER)
////    @JoinTable
//    private Set<Team> team;
//
//    public Set<Team> getTeam() {
//        return team;
//    }
//
//    public void setTeam(Set<Team> team) {
//        this.team = team;
//    }

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isTokenExpired() {
        return tokenExpired;
    }

    public void setTokenExpired(boolean tokenExpired) {
        this.tokenExpired = tokenExpired;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
