package com.dlc.hr_module.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hp on 02/08/2018.
 */

    public class Level {
    @SerializedName("level_number")
    @Expose
    private Integer level_number;

    @SerializedName("level_name")
    @Expose
    private String level_name;

    public Level(Integer level_number, String level_name) {
        this.level_number = level_number;
        this.level_name = level_name;
    }

    public Integer getLevel_number() {
        return level_number;
    }

    public void setLevel_number(Integer level_number) {
        this.level_number = level_number;
    }

    public String getLevel_name() {
        return level_name;
    }

    public void setLevel_name(String level_name) {
        this.level_name = level_name;
    }
}
