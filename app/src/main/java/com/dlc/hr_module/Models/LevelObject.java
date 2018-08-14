package com.dlc.hr_module.Models;

import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

/**
 * Created by hp on 13/08/2018.
 */

public class LevelObject {

    EditText level_name;
    Button level_no;

    public LevelObject(EditText level_name, Button level_no) {
        this.level_name = level_name;
        this.level_no = level_no;
    }

    public EditText getLevel_name() {
        return level_name;
    }

    public void setLevel_name(EditText level_name) {
        this.level_name = level_name;
    }

    public Button getLevel_no() {
        return level_no;
    }

    public void setLevel_no(Button level_no) {
        this.level_no = level_no;
    }
}
