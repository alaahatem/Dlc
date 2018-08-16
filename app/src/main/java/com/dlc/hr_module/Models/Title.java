package com.dlc.hr_module.Models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hp on 16/08/2018.
 */

public class Title {
    @SerializedName("")
    String title_name;

    public Title(String title_name) {
        this.title_name = title_name;
    }

    public String getTitle_name() {
        return title_name;
    }

    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }
}
