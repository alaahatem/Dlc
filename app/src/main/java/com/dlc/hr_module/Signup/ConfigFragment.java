package com.dlc.hr_module.Signup;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dlc.hr_module.R;


public class ConfigFragment extends Fragment {
        CardView company_name;
        CardView vacation_card;
        CardView companyLevel_card;
        Dialog  myDialog;
        RelativeLayout comp_rel;
        TextView company_details,compname_tv,complevel_tv,ranking_criteria,add_user,create_company,vac_days;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_config, container, false);
        vacation_card = view.findViewById(R.id.vacation_card);
        company_details = view.findViewById(R.id.companytv);
        compname_tv = view.findViewById(R.id.compname_tv);
        complevel_tv = view.findViewById(R.id.complevel_tv);
        ranking_criteria = view.findViewById(R.id.ranking_criteria);
        add_user = view.findViewById(R.id.add_user);
        create_company= view.findViewById(R.id.create_company);
        vac_days = view.findViewById(R.id.vac_days);
        Typeface typeface =Typeface.createFromAsset(getActivity().getAssets(),"fonts/futura.ttf");
        company_details.setTypeface(typeface);
        compname_tv.setTypeface(typeface);
        complevel_tv.setTypeface(typeface);
        ranking_criteria.setTypeface(typeface);
        add_user.setTypeface(typeface);
        create_company.setTypeface(typeface);
        vac_days.setTypeface(typeface);
        myDialog = new Dialog(getActivity());

        company_name = view.findViewById(R.id.companycv);
        companyLevel_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupCompanyLevels();
            }
        });

        vacation_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
    showPopupVacationDays();
            }
        });
        company_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Showed",Toast.LENGTH_SHORT).show();
                showPopupCompanyName();
            }
        });


        return view;


    }

public void showPopupCompanyName(){
    TextView company_name ;
    EditText companyet;
    Button done ;
    myDialog.setContentView(R.layout.popup_companyname);
    comp_rel = myDialog.findViewById(R.id.rel_comp);

    company_name = myDialog.findViewById(R.id.popuptv_name);
    companyet = myDialog.findViewById(R.id.popupet_name);
    done = myDialog.findViewById(R.id.Done);
    comp_rel.setBackgroundColor(Color.TRANSPARENT);

    done.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            myDialog.dismiss();
        }
    });
    myDialog.show();
    }

    public void showPopupCompanyLevels(){
    Button Done ;
    RecyclerView recyclerView;
    myDialog.setContentView(R.layout.popup_companylevels);
    recyclerView= myDialog.findViewById(R.id.recyclerview_level);
    Done = myDialog.findViewById(R.id.done_level);
    Done.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            myDialog.dismiss();
        }
    });
            myDialog.show();
}
    public void showPopupVacationDays(){
    Button done;
        myDialog.setContentView(R.layout.popup_vacation);
    done = myDialog.findViewById(R.id.done_vac);

    done.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            myDialog.dismiss();
        }
    });
myDialog.show();
}
}
