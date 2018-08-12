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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.dlc.hr_module.Adapters.LevelAdapter;
import com.dlc.hr_module.Models.Criteria;
import com.dlc.hr_module.Models.CriteriaObject;
import com.dlc.hr_module.Models.Level;
import com.dlc.hr_module.R;

import java.util.ArrayList;


public class ConfigFragment extends Fragment {
        public static final String CEO = "CEO";
        public static final String managers = " Managers";
        public static final String member = "Team Member";
    ArrayList<EditText> editTexts;
    ArrayList<EditText> scores;
        private LevelAdapter levelAdapter;
        private   ArrayList<Level> levels = new ArrayList<>();
    private LinearLayout linearLayout;

    private LinearLayout linearlevel;
    public EditText new_item;
    CardView company_name;
        CardView vacation_card;
        CardView companyLevel_card;
        CardView criteria_card;
        Dialog  myDialog;
        RelativeLayout comp_rel;
        TextView company_details,compname_tv,complevel_tv,ranking_criteria,add_user,create_company,vac_days;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_config, container, false);
        if(levels!=null) {
            levels.add(new Level(levels.size() + 1,CEO));
            levels.add(new Level(levels.size() + 1,managers));
            levels.add(new Level(levels.size() + 1,member));

        }
        vacation_card = view.findViewById(R.id.vacation_card);
        company_details = view.findViewById(R.id.companytv);
        compname_tv = view.findViewById(R.id.compname_tv);
        companyLevel_card =view.findViewById(R.id.levelcv);
        complevel_tv = view.findViewById(R.id.complevel_tv);
        editTexts = new ArrayList<>();
        scores = new ArrayList<>();
        criteria_card = view.findViewById(R.id.criteria_card);
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
        criteria_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupCriteria();
            }
        });
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
    final LinearLayout addview;

    Button Done ;
    ImageButton  add;
    myDialog.setContentView(R.layout.popup_companylevels);
    linearlevel = myDialog.findViewById(R.id.linear_level);
    add = myDialog.findViewById(R.id.add_edit);
   addview = myDialog.findViewById(R.id.linear_newlevel);
    Done = myDialog.findViewById(R.id.done_level);
    add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            View inflatedView = View.inflate(myDialog.getContext(),R.layout.addlevel,addview);
            if(inflatedView.getParent()!=null){
                ((ViewGroup)inflatedView.getParent()).removeView(inflatedView);
            }
            linearlevel.addView(inflatedView);
        }
    });

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

    public void showPopupCriteria(){
        Button done ;
        final LinearLayout addview;
        final EditText edit_criteria ,editscore;
        final ArrayList<Level> criteriaLevels;
        final ArrayList<CriteriaObject> criteriaObjects;
        ImageButton add;
        criteriaLevels = new ArrayList<>();
        criteriaObjects = new ArrayList<>();
        myDialog.setContentView(R.layout.popup_criteria);
        addview= myDialog.findViewById(R.id.linearView);
        done = myDialog.findViewById(R.id.done_criteria);
        linearLayout = myDialog.findViewById(R.id.linear_criteria);
        edit_criteria = myDialog.findViewById(R.id.edittext_criteria);

        editscore = myDialog.findViewById(R.id.editscore);
        add = myDialog.findViewById(R.id.add_edit);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View inflatedView = View.inflate(myDialog.getContext(),R.layout.addview,addview);
                linearLayout.addView(inflatedView);
                EditText editText = inflatedView.findViewById(R.id.edittext_criteria);
                EditText score = inflatedView.findViewById(R.id.edittext_score);


                CriteriaObject criteriaObject = new CriteriaObject(editText,score);
                CriteriaObject criteriaObject1 = new CriteriaObject(edit_criteria,editscore);
                criteriaObjects.add(criteriaObject1);
                criteriaObjects.add(criteriaObject);


                  }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i <criteriaObjects.size() ; i++) {
                   Level level = new Level(Integer.parseInt(criteriaObjects.get(i).getCriteria_number().getText().toString()),criteriaObjects.get(i).getCriteria_name().getText().toString());
                    levels.add(level);
                }
                myDialog.dismiss();
            }
        });
    myDialog.show();
    }
}
