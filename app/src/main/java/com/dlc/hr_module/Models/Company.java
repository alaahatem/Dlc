package com.dlc.hr_module.Models;

/**
 * Created by hp on 02/08/2018.
 */
import android.location.Criteria;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Company {
@SerializedName("company_name")
@Expose
private String company_name;
@SerializedName("id")
@Expose
private Integer id;

@SerializedName("levels")
@Expose
private ArrayList<Level> levels;

@SerializedName("max_sick")
 @Expose
    private int max_sick;
@SerializedName("max_vac")
    @Expose
    private int max_vac;
@SerializedName("max_work")
    @Expose
    private int max_home;
@SerializedName("criteria")
    @Expose
    private ArrayList<Criteria> criteria;


}
