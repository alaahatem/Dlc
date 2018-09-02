package com.dlc.hr_module.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hp on 02/08/2018.
 */

public class User {

   @SerializedName("name")
   @Expose
    private String name;
   private List<String> vacation_days;
   private List<String> Sick_leaves;
   private List<String> WorkFromHome;
    private  Integer company_id;
    private String user_image;
    private String birthdate;
    private String major;
    private String college;
    private String position;
    private String title;
    private String team;
    @SerializedName("email")
    @Expose
    private String email;
    private Integer manager_id;

    @SerializedName("password")
    @Expose
    private String password;

    public User(String name, String email, String password, String team, String title , String position , String birthdate, String major,String college, String ImageView, List<String>Vacation_days, List<String>Sick_leaves, List<String> WorkHome) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.team = team;
        this.title = title;
        this.position = position;
        this.birthdate = birthdate;
        this.major = major;
        this.college =college;
        this.user_image = ImageView;
        this.vacation_days = Vacation_days;
        this.Sick_leaves = Sick_leaves;
        this.WorkFromHome = WorkHome;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public List<String> getVacation_days() {
        return vacation_days;
    }

    public void setVacation_days(List<String> vacation_days) {
        this.vacation_days = vacation_days;
    }

    public List<String> getSick_leaves() {
        return Sick_leaves;
    }

    public void setSick_leaves(List<String> sick_leaves) {
        Sick_leaves = sick_leaves;
    }

    public List<String> getWorkFromHome() {
        return WorkFromHome;
    }

    public void setWorkFromHome(List<String> workFromHome) {
        WorkFromHome = workFromHome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getUser_image() {
        return user_image;
    }

    public void setUser_image(String user_image) {
        this.user_image = user_image;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String  birthdate) {
        this.birthdate = birthdate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }
}
