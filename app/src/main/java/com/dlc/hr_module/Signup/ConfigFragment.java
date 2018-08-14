package com.dlc.hr_module.Signup;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.dlc.hr_module.Adapters.LevelAdapter;
import com.dlc.hr_module.Models.Criteria;
import com.dlc.hr_module.Models.CriteriaObject;
import com.dlc.hr_module.Models.Level;
import com.dlc.hr_module.Models.LevelObject;
import com.dlc.hr_module.R;

import java.util.ArrayList;


public class ConfigFragment extends Fragment {
        public static final String CEO = "CEO";
        public static final String managers = " Managers";
        public static final String member = "Team Member";

ImageView comname,pinkish,purple,green;
    ArrayList<EditText> editTexts;
    ArrayList<EditText> scores;
        private LevelAdapter levelAdapter;
        private   ArrayList<Level> levels = new ArrayList<>();
        private  ArrayList<Criteria> criteriaFactors = new ArrayList<>();
    private LinearLayout linearLayout;
    private  ArrayList<LevelObject> levelObjects ;
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
        if(criteriaFactors!=null) {
            criteriaFactors.add(new Criteria(criteriaFactors.size() + 1,CEO));
            criteriaFactors.add(new Criteria(criteriaFactors.size() + 1,managers));
            criteriaFactors.add(new Criteria(criteriaFactors.size() + 1,member));

        }
        pinkish =view.findViewById(R.id.pinkish);
        green =view.findViewById(R.id.green);
        purple =view.findViewById(R.id.purple);
        comname =view.findViewById(R.id.imagecomname);
        vacation_card = view.findViewById(R.id.vacation_card);
        company_details = view.findViewById(R.id.companytv);
        compname_tv = view.findViewById(R.id.compname_tv);
        companyLevel_card =view.findViewById(R.id.levelcv);
        complevel_tv = view.findViewById(R.id.complevel_tv);
        editTexts = new ArrayList<>();
        scores = new ArrayList<>();
        criteria_card = view.findViewById(R.id.criteria_card);
        ranking_criteria = view.findViewById(R.id.ranking_criteria);
//        add_user = view.findViewById(R.id.add_user);
        create_company= view.findViewById(R.id.create_company);
        vac_days = view.findViewById(R.id.vac_days);
        Typeface typeface =Typeface.createFromAsset(getActivity().getAssets(),"fonts/futura.ttf");
        company_details.setTypeface(typeface);
        compname_tv.setTypeface(typeface);
        complevel_tv.setTypeface(typeface);
        ranking_criteria.setTypeface(typeface);
//        add_user.setTypeface(typeface);
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
    final EditText companyet;

    Button done ;

    myDialog.setContentView(R.layout.popup_companyname);
    myDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
    myDialog.getWindow().setBackgroundDrawable(null);

    comp_rel = myDialog.findViewById(R.id.rel_comp);

    company_name = myDialog.findViewById(R.id.popuptv_name);
    companyet = myDialog.findViewById(R.id.popupet_name);
    done = myDialog.findViewById(R.id.Done);

//    comp_rel.setBackgroundColor(Color.TRANSPARENT);

    done.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            comname.setAlpha(100);
            compname_tv.setText(companyet.getText().toString());
            myDialog.dismiss();
        }
    });
    myDialog.show();
    }

    public void showPopupCompanyLevels(){


    final LinearLayout addview;
        levelObjects = new ArrayList<>();
    Button Done ;
    ImageButton  add;
    EditText level_name;


    myDialog.setContentView(R.layout.popup_companylevels);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        level_name = myDialog.findViewById(R.id.edittext_level);
    linearlevel = myDialog.findViewById(R.id.linear_level);
    add  = myDialog.findViewById(R.id.add_edit);
   addview = myDialog.findViewById(R.id.linear_newlevel);
    Done = myDialog.findViewById(R.id.done_level);

     final Button dropdown ;
    level_name=myDialog.findViewById(R.id.edittext_level);
    dropdown = myDialog.findViewById(R.id.dropdown);
    dropdown.setId(View.generateViewId());

    dropdown.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {



            PopupMenu popupMenu = new PopupMenu(myDialog.getContext(),dropdown);
            popupMenu.getMenuInflater().inflate(R.menu.popupmenu,popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                   

                return true;

                }
            });
         popupMenu.show();
        }
    });

    LevelObject levelObject = new LevelObject(level_name,dropdown);
    levelObjects.add(levelObject);
    add.setOnClickListener(new View.OnClickListener() {


        @Override
        public void onClick(View v) {
            View inflatedView = View.inflate(myDialog.getContext(),R.layout.addlevel,addview);
            if(inflatedView.getParent()!=null){
                ((ViewGroup)inflatedView.getParent()).removeView(inflatedView);

            }
            final Button drop = inflatedView.findViewById(R.id.drop);
            drop.setId(View.generateViewId());

            EditText level = inflatedView.findViewById(R.id.leveledit);

            drop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),Integer.toString(drop.getId()),Toast.LENGTH_SHORT).show();
                    PopupMenu popupMenu = new PopupMenu(myDialog.getContext(),drop);
                    popupMenu.getMenuInflater().inflate(R.menu.popupmenu,popupMenu.getMenu());
                    popupMenu.show();
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            drop.setText(item.getTitle());
                            for (int i = 0; i <levelObjects.size() ; i++) {
                                if(drop.getId()==levelObjects.get(i).getLevel_no().getId()){
                                    levelObjects.get(i).getLevel_no().setText(item.getTitle());
                                }
                            }
                            return true;
                        }
                    });

                }
            });

            linearlevel.addView(inflatedView);

            final LevelObject levelObject = new LevelObject(level,drop);
            levelObjects.add(levelObject);
        }
    });

    Done.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            for (int i = 0; i <levelObjects.size() ; i++) {
                Toast.makeText(getContext(),levelObjects.get(i).getLevel_name().getText().toString()+" "+levelObjects.get(i).getLevel_no().getText().toString(),Toast.LENGTH_SHORT).show();
//                levels.add(new Level(Integer.parseInt(levelObjects.get(i).getLevel_name().getText().toString()),levelObjects.get(i).getLevel_name().getText().toString()));

            }
            pinkish.setAlpha(100);
            myDialog.dismiss();
        }
    });
            myDialog.show();

}
    public void showPopupVacationDays(){

    Button done;
    final Button editvac,edit2,edit3;
    final TextView textViewvac,home_tv,sick_days;
    final EditText editvacation,editsick,edithome;
       final ViewSwitcher viewSwitcher;
       final ViewSwitcher viewSwitchersick;
       final ViewSwitcher viewSwitcherHome;
        myDialog.setContentView(R.layout.popup_vacation);
        viewSwitcher = myDialog.findViewById(R.id.vac_num);
        viewSwitchersick =myDialog.findViewById(R.id.sick_num);
        viewSwitcherHome=myDialog.findViewById(R.id.workhome_num);
        textViewvac = myDialog.findViewById(R.id.textview_vac);
        home_tv = myDialog.findViewById(R.id.hometv);
        sick_days = myDialog.findViewById(R.id.sick_days);
        edithome = myDialog.findViewById(R.id.edithome);
        editvacation = myDialog.findViewById(R.id.editvacation);
        editsick = myDialog.findViewById(R.id.editsick);
        edit3 = myDialog.findViewById(R.id.edit3);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    editvac = myDialog.findViewById(R.id.editvac);

    edit2 = myDialog.findViewById(R.id.edit2);
    edit3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(edit3.getText().equals("Edit")){
                viewSwitcherHome.showNext();
                edit3.setText("Done");
            }
            else {
                home_tv.setText(edithome.getText().toString());
                edit3.setText("Edit");
                viewSwitcherHome.showPrevious();
            }
        }
    });
    edit2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(edit2.getText().equals("Edit")){
                viewSwitchersick.showNext();
                edit2.setText("Done");

            }
            else {
                sick_days.setText(editsick.getText().toString());
                edit2.setText("Edit");
                viewSwitchersick.showPrevious();
            }
        }
    });
    editvac.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(editvac.getText().equals("Edit")){
                viewSwitcher.showNext();
                editvac.setText("Done");
            }
            else {
                textViewvac.setText(editvacation.getText().toString());
                editvac.setText("Edit");
                viewSwitcher.showPrevious();
            }



        }
    });
        done = myDialog.findViewById(R.id.done_vac);

    done.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            green.setAlpha(100);
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
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
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
                    Toast.makeText(getContext(),criteriaObjects.get(i).getCriteria_name().getText().toString(),Toast.LENGTH_LONG).show();
                   Criteria criteria = new Criteria(Integer.parseInt(criteriaObjects.get(i).getCriteria_number().getText().toString()),criteriaObjects.get(i).getCriteria_name().getText().toString());
                    criteriaFactors.add(criteria);
                }
                purple.setAlpha(100);
                myDialog.dismiss();
            }
        });
    myDialog.show();
    }
}
