package com.dlc.hr_module.Signup;

import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dlc.hr_module.ApiService;
import com.dlc.hr_module.Models.User;
import com.dlc.hr_module.Models.UserRequest;
import com.dlc.hr_module.R;
import com.dlc.hr_module.RetrofitClient;
import com.dlc.hr_module.TinyDB;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sign_up extends Fragment {
    TextView nametv, emailtv, passtv, verifypasstv, signuptv;
    EditText nameet, emailet, passet, verifypasset;
    Button next;
    ApiService api;
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        nametv = view.findViewById(R.id.nametv);
        emailtv = view.findViewById(R.id.emailtv);
        passtv = view.findViewById(R.id.passtv);
        verifypasstv = view.findViewById(R.id.vpasstv);
        signuptv = view.findViewById(R.id.signuptv);
        next = view.findViewById(R.id.next);
        nameet = view.findViewById(R.id.nameet);
        emailet = view.findViewById(R.id.emailet);
        passet = view.findViewById(R.id.passet);
        verifypasset = view.findViewById(R.id.vpasset);
        progressBar = view.findViewById(R.id.progress_loader);
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/futura.ttf");
        nametv.setTypeface(typeface);
        emailtv.setTypeface(typeface);
        passtv.setTypeface(typeface);
        verifypasstv.setTypeface(typeface);
        next.setTypeface(typeface);
        signuptv.setTypeface(typeface);
        nameet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if (nameet.getText().toString().length() < 3)
                    nametv.setTextColor(Color.RED);
                else {
                    nametv.setTextColor(getResources().getColor(R.color.signup));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        emailet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!isValidEmail(emailet.getText().toString()))
                    emailtv.setTextColor(Color.RED);
                else
                    emailtv.setTextColor(getResources().getColor(R.color.signup));
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        passet.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (passet.getText().toString().isEmpty()) {
                    passtv.setTextColor(Color.RED);
                } else if (passet.getText().toString().length() > 0 && passet.getText().toString().length() < 5) {
                    passtv.setTextColor(Color.YELLOW);
                } else if (passet.getText().toString().length() > 4 && passet.getText().toString().length() < 9)
                    passtv.setTextColor(getResources().getColor(R.color.light_green));
                else
                    passtv.setTextColor(getResources().getColor(R.color.dark_green));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        verifypasset.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!verifypasset.getText().toString().equals(passet.getText().toString())) {
                    verifypasstv.setTextColor(Color.RED);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(nameet.getText().toString(), emailet.getText().toString(), passet.getText().toString());
                UserRequest userRequest = new UserRequest(user);
                progressBar.setVisibility(View.VISIBLE);
                SendNetworkRequest(userRequest);


            }
        });


        return view;


    }

    public void SendNetworkRequest(UserRequest user) {
        api = RetrofitClient.getClient().create(ApiService.class);
        Call<UserRequest> userCall = api.signup(user);

        userCall.enqueue(new Callback<UserRequest>() {
            @Override
            public void onResponse(Call<UserRequest> call, Response<UserRequest> response) {
                if (response.isSuccessful()) {

                    TinyDB tinyDB = new TinyDB(getContext());
                    if (response.body().getToken() != null)
                        tinyDB.putString("token", response.body().getToken());
                    progressBar.setVisibility(View.GONE);
                    ConfigFragment frag = new ConfigFragment();
                    android.support.v4.app.FragmentManager fm = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_pos, frag);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    Toast.makeText(getContext(), response.message() + " " + response.body(), Toast.LENGTH_LONG).show();
                } else {
                    try {
                        Log.i("signup_error", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Toast.makeText(getContext(), response.message() + " " + response.body(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<UserRequest> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                next.setEnabled(true);
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

}
