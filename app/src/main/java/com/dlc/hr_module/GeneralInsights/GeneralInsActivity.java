package com.dlc.hr_module.GeneralInsights;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dlc.hr_module.ApiService;
import com.dlc.hr_module.Models.WorkingHours;
import com.dlc.hr_module.R;
import com.dlc.hr_module.RetrofitClient;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GeneralInsActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    float DayOfMonth;
    TextView dataview;
    ApiService api;
    String formatos;
    SimpleDateFormat format1;
    private LineChart lineChart;
    List<WorkingHours> workingHours;
    ArrayList<Entry> yValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_ins);
        ImageButton dateButton = findViewById(R.id.datebutton);


//         dataview= findViewById(R.id.dataview);
         lineChart =findViewById(R.id.line_chart);
//         lineChart.setOnChartGestureListener(GeneralInsActivity.this);
//         lineChart.setOnChartValueSelectedListener(GeneralInsActivity.this);
         lineChart.setDragEnabled(true);
         lineChart.setScaleEnabled(false);
         lineChart.setEnabled(true);



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
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        format1 = new SimpleDateFormat("yyyy-MM-dd");

         formatos = format1.format(calendar.getTime());

//        dataview.setText(formatos);

        api = RetrofitClient.getAnalysisClient().create(ApiService.class);
        Call<List<WorkingHours>>workingHoursCall = api.getWorkingHours("records",formatos);

        workingHoursCall.enqueue(new Callback<List<WorkingHours>>() {
            @Override
            public void onResponse(Call<List<WorkingHours>> call, Response<List<WorkingHours>> response) {
                yValues = new ArrayList<>();
                Toast.makeText(getApplicationContext(),call.request().url().toString(),Toast.LENGTH_LONG).show();
                workingHours = new ArrayList<>();
//                dataview.setText(call.request().url().toString());
                if(response.isSuccessful()){
                    Toast.makeText(getApplication(),"Success",Toast.LENGTH_LONG).show();
                    workingHours = response.body();

                    for (int i = 0; i <workingHours.size() ; i++) {
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            Date date = format.parse(workingHours.get(i).getDate());
                            DayOfMonth = date.getDay();

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                     yValues.add(new Entry(DayOfMonth,workingHours.get(i).getWorking_hours()));
                    }
                    LineDataSet set1 = new LineDataSet(yValues,"Data Set 1");
                    set1.setFillAlpha(110);
                    ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                    dataSets.add(set1);
                    LineData data = new LineData(dataSets);
                    
                    lineChart.setData(data);
                    lineChart.invalidate();
                }
            }

            @Override
            public void onFailure(Call<List<WorkingHours>> call, Throwable t) {

            }
        });
    }
}
