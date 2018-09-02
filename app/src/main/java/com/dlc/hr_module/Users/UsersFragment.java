package com.dlc.hr_module.Users;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.dlc.hr_module.Adapters.UsersAdapter;
import com.dlc.hr_module.ApiService;
import com.dlc.hr_module.Constants.Constants;
import com.dlc.hr_module.Models.User;
import com.dlc.hr_module.Models.UserSearch;
import com.dlc.hr_module.R;
import com.dlc.hr_module.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UsersFragment extends Fragment {
    ImageView search;
    EditText searchet;
    UsersAdapter adapter;
    List<UserSearch> AllUsers;
    List<UserSearch> filteredUsers;
    ApiService api;
    GridView usersGrid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.RecyclerView);
        int numberOfColumns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(),numberOfColumns));
        UsersAdapter adapter = new UsersAdapter(getContext(),Constants.AllUsers);
        recyclerView.setAdapter(adapter);
        filteredUsers = new ArrayList<>();
        AllUsers = new ArrayList<>();
        search = view.findViewById(R.id.searchIcon);
        searchet = view.findViewById(R.id.searchet);
        api = RetrofitClient.getClient().create(ApiService.class);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        searchet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Toast.makeText(getContext(), "before call", Toast.LENGTH_SHORT).show();
                Call<List<UserSearch>> userSearchCall = api.getAllUsers();
                userSearchCall.enqueue(new Callback<List<UserSearch>>() {
                    @Override
                    public void onResponse(Call<List<UserSearch>> call, Response<List<UserSearch>> response) {
                        Toast.makeText(getActivity(), call.request().url().toString(), Toast.LENGTH_LONG).show();

                        if (response.isSuccessful()) {
                            Toast.makeText(getActivity(), response.body().get(0).getName(), Toast.LENGTH_LONG).show();
                            AllUsers = response.body();

//                            UsersAdapter adapter = new UsersAdapter(getActivity(), Constants.AllUsers);
//                            usersGrid.setAdapter(adapter);
                            usersGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    Toast.makeText(getContext(), "Clicked", Toast.LENGTH_LONG).show();
                                }
                            });
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserSearch>> call, Throwable t) {

                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
        return view;
    }


    public List<UserSearch> filter(String text, List<UserSearch> user) {
        filteredUsers = new ArrayList<>();


        for (UserSearch item : user) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredUsers.add(item);


            }

        }
        return filteredUsers;
    }


}
