package com.dlc.hr_module.GeneralInsights;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.dlc.hr_module.ApiService;
import com.dlc.hr_module.Models.WorkingHours;
import com.dlc.hr_module.R;
import com.dlc.hr_module.RetrofitClient;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GeneralInsActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    TextView dataview;
    ApiService api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_ins);
        Button dateButton = findViewById(R.id.datebutton);
         dataview= findViewById(R.id.dataview);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"Date Picker");

            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        int Dateyear = calendar.get(Calendar.YEAR);
        int Datemonth = calendar.get(Calendar.MONTH);
        int Dateday = calendar.get(Calendar.DAY_OF_MONTH);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateString = DateFormat.getDateInstance().format(format1.format(calendar.getTime()));
        dataview.setText(currentDateString);
        api = RetrofitClient.getAnalysisClient().create(ApiService.class);
        Call<WorkingHours>workingHoursCall = api.getWorkingHours("records",format1.toString());
        workingHoursCall.enqueue(new Callback<WorkingHours>() {
            @Override
            public void onResponse(Call<WorkingHours> call, Response<WorkingHours> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),response.body().toString(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<WorkingHours> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
