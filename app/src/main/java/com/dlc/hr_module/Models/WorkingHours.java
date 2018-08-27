package com.dlc.hr_module.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hp on 27/08/2018.
 */

public class WorkingHours {
    @SerializedName("day")
    @Expose
    public String Date;
    @SerializedName("working_hours")
    @Expose
    public float working_hours;

    public WorkingHours(String date, float working_hours) {
        Date = date;
        this.working_hours = working_hours;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public float getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(float working_hours) {
        this.working_hours = working_hours;
    }
}
