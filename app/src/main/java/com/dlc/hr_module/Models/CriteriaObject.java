package com.dlc.hr_module.Models;

import android.widget.EditText;

/**
 * Created by hp on 12/08/2018.
 */

public class CriteriaObject {
    EditText criteria_name;
    EditText criteria_number;

    public CriteriaObject(EditText criteria_name, EditText criteria_number) {
        this.criteria_name = criteria_name;
        this.criteria_number = criteria_number;
    }

    public EditText getCriteria_name() {
        return criteria_name;
    }

    public void setCriteria_name(EditText criteria_name) {
        this.criteria_name = criteria_name;
    }

    public EditText getCriteria_number() {
        return criteria_number;
    }

    public void setCriteria_number(EditText criteria_number) {
        this.criteria_number = criteria_number;
    }
}
