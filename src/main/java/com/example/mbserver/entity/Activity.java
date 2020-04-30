package com.example.mbserver.entity;

import javax.persistence.Entity;
import java.util.Date;

/**
 * @since 2020/4/30
 */
@Entity
public class Activity extends BaseEntity {

    private String name;
    private String captcha1;
    private String captcha2;
    private String captcha3;

    private int experience;

    private Date startTime;
    private Date endTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaptcha1() {
        return captcha1;
    }

    public void setCaptcha1(String captcha1) {
        this.captcha1 = captcha1;
    }

    public String getCaptcha2() {
        return captcha2;
    }

    public void setCaptcha2(String captcha2) {
        this.captcha2 = captcha2;
    }

    public String getCaptcha3() {
        return captcha3;
    }

    public void setCaptcha3(String captcha3) {
        this.captcha3 = captcha3;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
