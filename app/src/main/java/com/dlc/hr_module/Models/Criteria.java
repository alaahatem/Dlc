package com.dlc.hr_module.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hp on 02/08/2018.
 */

public class Criteria {
    @SerializedName("criteria_name")
    @Expose
    private String name ;
    @SerializedName("criteria_weight")
    @Expose
    private float weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
