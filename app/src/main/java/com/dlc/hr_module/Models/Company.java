package com.dlc.hr_module.Models;

/**
 * Created by hp on 02/08/2018.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Company {
@SerializedName("comp_name")
@Expose
private String company_name;


@SerializedName("levels")
@Expose
private List<Level> levels;

@SerializedName("no_of_sick_days")
 @Expose
    private int max_sick;
@SerializedName("no_of_vac_days")
    @Expose
    private int max_vac;
@SerializedName("no_of_work_from_home_days")
    @Expose
    private int max_home;
@SerializedName("eval_crt")
    @Expose
    private List<Criteria> criteria;

    public Company(String company_name, int max_sick, int max_vac, int max_home,ArrayList<Level> levels, ArrayList<Criteria> criteria) {
        this.company_name = company_name;
        this.levels = levels;
        this.max_sick = max_sick;
        this.max_vac = max_vac;
        this.max_home = max_home;
        this.criteria = criteria;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }


    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public int getMax_sick() {
        return max_sick;
    }

    public void setMax_sick(int max_sick) {
        this.max_sick = max_sick;
    }

    public int getMax_vac() {
        return max_vac;
    }

    public void setMax_vac(int max_vac) {
        this.max_vac = max_vac;
    }

    public int getMax_home() {
        return max_home;
    }

    public void setMax_home(int max_home) {
        this.max_home = max_home;
    }

    public List<Criteria> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<Criteria> criteria) {
        this.criteria = criteria;
    }
}
