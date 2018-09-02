package com.dlc.hr_module.Users;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dlc.hr_module.Adapters.VacationsAdapter;
import com.dlc.hr_module.Constants.Constants;
import com.dlc.hr_module.R;


public class VacationFragment extends Fragment {

RecyclerView VacationRV;
RecyclerView SickRV;
RecyclerView WorkHomeRV;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_vacation, container, false);
        VacationRV = view.findViewById(R.id.RecyclerVacation);
        SickRV = view.findViewById(R.id.RecyclerSick);
        WorkHomeRV = view.findViewById(R.id.RecyclerHome);
        int numberOfColumns = 3;
        VacationRV.setLayoutManager(new GridLayoutManager(this.getActivity(),numberOfColumns));
        VacationsAdapter adapter = new VacationsAdapter(Constants.AllUsers,getActivity());
        VacationRV.setAdapter(adapter);
        return  view;
    }

}
