package com.dlc.hr_module.Users;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dlc.hr_module.R;


public class UsersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        getSupportFragmentManager().beginTransaction().replace(R.id.userfragment,new UserProfilesFragment()).commit();
    }
    

}
