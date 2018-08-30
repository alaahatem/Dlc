package com.dlc.hr_module.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hp on 27/08/2018.
 */

public class UserSearch {
    @SerializedName("name")
    @Expose
    public String name ;
    public String email;
    public String title;


    @SerializedName("team")
    @Expose
    public String team;
    @SerializedName("position")
    @Expose
    public String position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public UserSearch(String name, String email,String team, String position , String title) {
        this.name = name;
        this.team = team;
        this.position = position;
        this.email = email;
        this.title = title;
    }
}
