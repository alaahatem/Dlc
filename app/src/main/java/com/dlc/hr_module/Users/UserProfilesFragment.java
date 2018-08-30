package com.dlc.hr_module.Users;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dlc.hr_module.R;
import com.dlc.hr_module.Signup.ConfigFragment;

public class UserProfilesFragment extends Fragment {
CardView personalInfo;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


                View view =inflater.inflate(R.layout.fragment_user_profiles, container, false);
                personalInfo = view.findViewById(R.id.personalInfoCard);
                personalInfo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PersonalInfoFragment frag = new PersonalInfoFragment();
                        android.support.v4.app.FragmentManager fm = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction =fm.beginTransaction();
                        fragmentTransaction.setCustomAnimations(R.anim.slideup,R.anim.slidedown);
                        fragmentTransaction.replace(R.id.thefragments,frag);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                });

                return view;
    }

}
