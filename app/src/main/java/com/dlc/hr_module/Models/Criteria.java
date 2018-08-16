package com.dlc.hr_module.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hp on 02/08/2018.
 */

public class Criteria {
    @SerializedName("crit_name")
    @Expose
    private String name ;
    @SerializedName("weight")
    @Expose
    private float weight;
    @SerializedName("descrip")
    @Expose
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Criteria(String name,  String description,float weight) {
        this.name = name;
        this.weight = weight;
        this.description = description;
    }


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
