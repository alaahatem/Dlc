package com.dlc.hr_module.Signup;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.dlc.hr_module.Adapters.LevelAdapter;
import com.dlc.hr_module.ApiService;
import com.dlc.hr_module.HomePage.Home;
import com.dlc.hr_module.Models.Company;
import com.dlc.hr_module.Models.Criteria;
import com.dlc.hr_module.Models.CriteriaObject;
import com.dlc.hr_module.Models.Level;
import com.dlc.hr_module.Models.LevelObject;
import com.dlc.hr_module.R;
import com.dlc.hr_module.RetrofitClient;
import com.dlc.hr_module.Users.UsersActivity;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Request;
import okio.Buffer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ConfigFragment extends Fragment {
        public static String TAG ="request_body";
     TextView textViewvac,home_tv,sick_days;
    EditText editvacation,editsick,edithome;
    String companyName;
     Button editvac,edit2,edit3;
    ApiService api;
        int max_vac= 21;
        int max_sick = 9;
        int max_home=21;

ImageView comname,pinkish,purple,green;
    ArrayList<EditText> editTexts;
    ArrayList<EditText> scores;
        private LevelAdapter levelAdapter;
        private   ArrayList<Level> levels = new ArrayList<>();
        private  ArrayList<Criteria> criteriaFactors = new ArrayList<>();
    private LinearLayout linearLayout;
    private  ArrayList<LevelObject> levelObjects ;
    private LinearLayout linearlevel;
    private ArrayList<CriteriaObject> criteriaObjects;
    public EditText new_item;
    CardView company_name;
        CardView vacation_card;
        CardView companyLevel_card;
        CardView criteria_card;
        CardView createCompany;
        Dialog  myDialog;
        RelativeLayout comp_rel;
        TextView company_details,compname_tv,complevel_tv,ranking_criteria,add_user,create_company,vac_days;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_config, container, false);

        pinkish =view.findViewById(R.id.pinkish);
        green =view.findViewById(R.id.green);
        purple =view.findViewById(R.id.purple);
        comname =view.findViewById(R.id.imagecomname);
        vacation_card = view.findViewById(R.id.vacation_card);
        company_details = view.findViewById(R.id.companytv);
        compname_tv = view.findViewById(R.id.compname_tv);
        companyLevel_card =view.findViewById(R.id.levelcv);
        createCompany =view.findViewById(R.id.create_card);
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
        createCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                api = RetrofitClient.getClient().create(ApiService.class);
                Company company = new Company(companyName,max_sick,max_vac,max_home,levels,criteriaFactors);
                Call<Company>companyCall = api.addcompany(company);
//                Toast.makeText(getContext(),companyName+" "+String.valueOf(max_sick)+" "+String.valueOf(max_vac)+" "+String.valueOf(max_home),Toast.LENGTH_LONG).show();
//                for (int i = 0; i <levels.size() ; i++) {
//                    Toast.makeText(getContext(),levels.get(i).getLevel_name()+" "+levels.get(i).getLevel_number(),Toast.LENGTH_LONG).show();
//
//                }
//                for (int i = 0; i <criteriaFactors.size() ; i++) {
//                    Toast.makeText(getContext(),criteriaFactors.get(i).getName()+" "+criteriaFactors.get(i).getWeight(),Toast.LENGTH_LONG).show();
//
//                }
                //
 companyCall.enqueue(new Callback<Company>() {
                    @Override
                    public void onResponse(Call<Company> call, Response<Company> response) {
//                        Toast.makeText(getContext(),"Message "+bodyToString(call.request())+ " error: "+response.errorBody().toString(),Toast.LENGTH_LONG).show();
                        Log.d(TAG, bodyToString(call.request()));
                        if(response.isSuccessful()){
                            Intent intent = new Intent(getContext(),Home.class);
                            startActivity(intent);
                        }


                    }

                    @Override
                    public void onFailure(Call<Company> call, Throwable t) {
                            t.getMessage();

                    }
                });

            }
        });
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
    final TextView company_name ;
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
            companyName =companyet.getText().toString();
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
                Level level = new Level(levelObjects.get(i).getLevel_name().getText().toString(),Integer.parseInt(levelObjects.get(i).getLevel_no().getText().toString()));
               levels.add(level);

            }
            pinkish.setAlpha(100);
            myDialog.dismiss();
        }
    });
            myDialog.show();

}
    public void showPopupVacationDays(){

    Button done;



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
        done = myDialog.findViewById(R.id.done_vac);

      textViewvac.setText(String.valueOf(max_vac));
      sick_days.setText(String.valueOf(max_sick));
      home_tv.setText(String.valueOf(max_home));
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
                max_home = Integer.parseInt(edithome.getText().toString());

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
                max_sick = Integer.parseInt(editsick.getText().toString());
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
                max_vac = Integer.parseInt(editvacation.getText().toString());
                viewSwitcher.showPrevious();
            }



        }
    });


    done.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
              textViewvac.setText(String.valueOf(max_vac));
              sick_days.setText(String.valueOf(max_sick));
              home_tv.setText(String.valueOf(max_home));

              //Todo Max_vac is the maximum number of vacation,max_sick is the maximum number of sick leaves,max_home..
//                String home = home_tv.getText().toString().replace("^\"|\"$", "");
//                String sick = sick_days.getText().toString().replace("^\"|\"$", "");
//                String vac = textViewvac.getText().toString().replace("^\"|\"$", "");

//           max_home = Integer.valueOf(home_tv.getText().toString());
//          max_sick = Integer.valueOf(sick_days.getText().toString());
//         max_vac = Integer.valueOf(textViewvac.getText().toString());

//                Toast.makeText(getContext(),String.valueOf(home.length())+" "+String.valueOf(sick.length())+" " +String.valueOf(vac.length()),Toast.LENGTH_LONG).show();
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
                Toast.makeText(getContext(),"dd",Toast.LENGTH_LONG).show();

                for (int i = 0; i <criteriaObjects.size() ; i++) {
                   Criteria criteria = new Criteria(criteriaObjects.get(i).getCriteria_name().getText().toString(),"Homos",Float.valueOf(criteriaObjects.get(i).getCriteria_number().getText().toString()));
                    criteriaFactors.add(criteria);
                    for (int j = 0; j <criteriaFactors.size() ; j++) {
                        Toast.makeText(getContext(),criteriaFactors.get(i).getName(),Toast.LENGTH_LONG).show();

                    }
                        validateScore(criteriaFactors);
                    }
                purple.setAlpha(100);
                myDialog.dismiss();
            }
        });
    myDialog.show();
    }
public boolean validateScore(ArrayList<Criteria> criteriaFactors){
    double sumScore =0;
    for (int j = 0; j <criteriaFactors.size() ; j++) {
        sumScore += criteriaFactors.get(j).getWeight();
    }
        if(sumScore>1){
        return false;
        }
return true;
    }
    private static String bodyToString(final Request request){

        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }


}
