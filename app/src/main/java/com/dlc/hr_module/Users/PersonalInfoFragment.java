package com.dlc.hr_module.Users;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dlc.hr_module.R;

public class PersonalInfoFragment extends Fragment {
    TextView personalEmail,personalMajor,personalPhone,personalBirthdate,personalUniversity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_personal_info, container, false);
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/futura.ttf");
        personalEmail = view.findViewById(R.id.personalEmail);
        personalBirthdate = view.findViewById(R.id.personalBirthdate);
        personalMajor = view.findViewById(R.id.personalMajor);
        personalPhone = view.findViewById(R.id.personalPhone);
        personalUniversity = view.findViewById(R.id.personalUniversity);
        personalEmail.setTypeface(typeface);
        personalBirthdate.setTypeface(typeface);
        personalMajor.setTypeface(typeface);
        personalPhone.setTypeface(typeface);
        personalUniversity.setTypeface(typeface);

        Bundle bundle = this.getArguments();
        if(bundle!=null) {
            if (bundle.getString("userEmail") != null && !bundle.getString("userEmail").isEmpty())
                personalEmail.setText(bundle.getString("userEmail"));
            if (bundle.getString("userBirthdate") != null && !bundle.getString("userBirthdate").isEmpty())
                personalBirthdate.setText(bundle.getString("userBirthdate"));
            if(bundle.getString("userMajor")!=null && !bundle.getString("userMajor").isEmpty())
                personalMajor.setText(bundle.getString("userMajor"));
            if(bundle.getString("userPhone")!=null && !bundle.getString("userPhone").isEmpty())
                personalPhone.setText(bundle.getString("userPhone"));
            if(bundle.getString("userCollege")!=null && !bundle.getString("userCollege").isEmpty())
                personalUniversity.setText(bundle.getString("userCollege"));
        }
        return view;
    }

}
