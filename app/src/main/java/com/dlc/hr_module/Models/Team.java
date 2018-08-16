package com.dlc.hr_module.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hp on 16/08/2018.
 */

public class Team {
    @SerializedName("teams")
    @Expose
    String team_name;

    public Team(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }
}
