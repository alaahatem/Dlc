package com.dlc.hr_module.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hp on 16/08/2018.
 */

public class Positions {
    @SerializedName("positions")
    @Expose
    String pos_name;

    public Positions(String pos_name) {
        this.pos_name = pos_name;
    }

    public String getPos_name() {
        return pos_name;
    }

    public void setPos_name(String pos_name) {
        this.pos_name = pos_name;
    }
}
