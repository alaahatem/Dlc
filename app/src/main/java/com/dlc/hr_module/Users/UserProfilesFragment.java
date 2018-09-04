package com.dlc.hr_module.Users;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dlc.hr_module.R;
import com.squareup.picasso.Picasso;

public class UserProfilesFragment extends Fragment {
    CardView personalInfoCV;
    CardView workingHoursCV;
    CardView VacationDaysCV;
    ImageView imageView;
    TextView textTeam;
    TextView textTitle;
    TextView textName;
    TextView textStatus;
    String Personalemail ,Personalphone,Personalbirthdate,Personaluniversity,Personalmajor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_user_profiles, container, false);
        imageView = view.findViewById(R.id.MyImage);
        textTeam = view.findViewById(R.id.textTeam);
        textTitle = view.findViewById(R.id.textTitle);
        textName = view.findViewById(R.id.textName);
        textStatus = view.findViewById(R.id.textStatus);
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/futura.ttf");
        textName.setTypeface(typeface);
        textTeam.setTypeface(typeface);
        textTitle.setTypeface(typeface);
        Bundle bundle;
        bundle = this.getArguments();
        if(bundle!=null) {
            if (bundle.getString("userName") != null && !bundle.getString("userName").isEmpty())
               textName.setText(bundle.getString("userName"));

            if (bundle.getString("userImage") != null && !bundle.getString("userImage").isEmpty())
                Picasso.get().load(bundle.getString("userImage")).fit().into(imageView);
            if (bundle.getString("userTitle") != null && !bundle.getString("userTitle").isEmpty())
                textTitle.setText(bundle.getString("userTitle"));
            if (bundle.getString("userStatus") != null && !bundle.getString("userStatus").isEmpty())
                textStatus.setText(bundle.getString("userStatus"));
            if (bundle.getString("userTeam") != null && !bundle.getString("userTeam").isEmpty())
                textTeam.setText(bundle.getString("userTeam"));
            if (bundle.getString("userEmail") != null && !bundle.getString("userEmail").isEmpty())
                Personalemail = bundle.getString("userEmail");
            if (bundle.getString("userPhone") != null && !bundle.getString("userPhone").isEmpty())
                Personalphone = bundle.getString("userPhone");
            if (bundle.getString("userBirthdate") != null && !bundle.getString("userBirthdate").isEmpty())
                Personalbirthdate = bundle.getString("userBirthdate");
            if (bundle.getString("userCollege") != null && !bundle.getString("userCollege").isEmpty())
                Personaluniversity = bundle.getString("userCollege");
            if (bundle.getString("userMajor") != null && !bundle.getString("userMajor").isEmpty())
                Personalmajor = bundle.getString("userMajor");

        }

        personalInfoCV = view.findViewById(R.id.personalInfoCard);
        workingHoursCV = view.findViewById(R.id.workingHoursCard);
        VacationDaysCV = view.findViewById(R.id.VacationDaysCV);

        VacationDaysCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VacationFragment frag = new VacationFragment();
                android.support.v4.app.FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slideup, R.anim.slidedown);
                fragmentTransaction.replace(R.id.thefragments, frag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        personalInfoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalInfoFragment frag = new PersonalInfoFragment();
                Bundle PersonalBundle = new Bundle();
                PersonalBundle.putString("userEmail",Personalemail);
                PersonalBundle.putString("userPhone",Personalphone);
                PersonalBundle.putString("userBirthdate",Personalbirthdate);
                PersonalBundle.putString("userCollege",Personaluniversity);
                PersonalBundle.putString("userMajor",Personalmajor);
                frag.setArguments(PersonalBundle);
                android.support.v4.app.FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slideup, R.anim.slidedown);
                fragmentTransaction.replace(R.id.thefragments, frag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        workingHoursCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CriteriaFragment frag = new CriteriaFragment();
                android.support.v4.app.FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.slideup, R.anim.slidedown);
                fragmentTransaction.replace(R.id.thefragments, frag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }

}
