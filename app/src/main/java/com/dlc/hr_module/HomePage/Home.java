package com.dlc.hr_module.HomePage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.dlc.hr_module.GeneralInsights.GeneralInsActivity;
import com.dlc.hr_module.R;
import com.dlc.hr_module.Users.UsersActivity;

public class Home extends AppCompatActivity {
    CardView generalInsights;
    CardView usersCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        generalInsights = findViewById(R.id.GeneralInsights);
        usersCard = findViewById(R.id.users_cards);
        generalInsights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent GeneralIns  = new Intent(Home.this, GeneralInsActivity.class);
                startActivity(GeneralIns);

            }
        });
        usersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UsersActivity.class);
                startActivity(intent);
            }
        });
    }

}
