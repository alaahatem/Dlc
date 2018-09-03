package com.dlc.hr_module.Leaderboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dlc.hr_module.R;
import com.dlc.hr_module.Signup.Sign_up;

public class LeaderboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_leader,new LeaderboardFragment()).commit();
    }
}
