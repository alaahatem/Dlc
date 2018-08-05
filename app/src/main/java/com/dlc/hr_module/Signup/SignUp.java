package com.dlc.hr_module.Signup;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.dlc.hr_module.R;

public class SignUp extends AppCompatActivity {
        TextView nametv ,emailtv,passtv,verifypasstv,signuptv;
        Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        nametv = findViewById(R.id.nametv);
        emailtv= findViewById(R.id.emailtv);
        passtv = findViewById(R.id.passtv);
        verifypasstv = findViewById(R.id.vpasstv);
        signuptv = findViewById(R.id.signuptv);
        next = findViewById(R.id.next);
        Typeface typeface =Typeface.createFromAsset(getAssets(),"fonts/futura.ttf");
        nametv.setTypeface(typeface);
        emailtv.setTypeface(typeface);
        passtv.setTypeface(typeface);
        verifypasstv.setTypeface(typeface);
        next.setTypeface(typeface);
        signuptv.setTypeface(typeface);
    }
}
