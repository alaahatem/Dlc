package com.dlc.hr_module.Leaderboard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dlc.hr_module.Adapters.LeaderboardAdapter;
import com.dlc.hr_module.Constants.Constants;
import com.dlc.hr_module.Models.Leaderboard;
import com.dlc.hr_module.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeaderboardFragment extends Fragment {
    RecyclerView recyclerView;
    TextView LeaderName;
    TextView LeaderPoints;
    TextView LeaderRank;
    ImageView myImage;
    Button CurrentLeaderboard, SprintLeaderboard,MonthLeaderboard,QuarterLeaderboard,YearLeaderboard;
    List<Leaderboard> SortedPoints;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leaderboard, container, false);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        SortedPoints = new ArrayList<>();
        recyclerView = view.findViewById(R.id.UserRecycler);
        CurrentLeaderboard = view.findViewById(R.id.CurrentLeaderboard);
        SprintLeaderboard = view.findViewById(R.id.SprintLeaderboard);
        MonthLeaderboard = view.findViewById(R.id.MonthLeaderboard);
        YearLeaderboard = view.findViewById(R.id.YearLeaderboard);
        LeaderName = view.findViewById(R.id.MyNameLeader);
        LeaderPoints = view.findViewById(R.id.MyPointsLeader);
        LeaderRank = view.findViewById(R.id.MyRankLeader);
        myImage = view.findViewById(R.id.MyImageLeader);
        LeaderName.setText(Constants.user.getName());
        Picasso.get().load(Constants.user.getUser_image()).fit().into(myImage);
        SortedPoints = Constants.WeekPoints;

        CurrentLeaderboard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Collections.sort(SortedPoints, new Comparator<Leaderboard>() {
                    public int compare(Leaderboard b1, Leaderboard b2) {
                        return Long.compare(b2.getPoints(),b1.getPoints());
                    }
                });

                for (int i = 0; i <SortedPoints.size() ; i++) {
                    if(Constants.user.getUser_id()==SortedPoints.get(i).getId()){
                        LeaderPoints.setText(String.valueOf(SortedPoints.get(i).getPoints()));
                    }
                }
                LeaderboardAdapter adapter = new LeaderboardAdapter(getContext(),Constants.WeekPoints);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
                for (int i = 0; i <Constants.WeekPoints.size() ; i++) {

                    if(Constants.user.getUser_id()==Constants.WeekPoints.get(i).getId()){
                        LeaderPoints.setText(String.valueOf(Constants.WeekPoints.get(i).getPoints()));
                        LeaderRank.setText(String.valueOf(i+1));
                    }

                }

            }
        });
        MonthLeaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(Constants.MonthPoints, new Comparator<Leaderboard>() {
                    public int compare(Leaderboard b1, Leaderboard b2) {
                        return Long.compare(b2.getPoints(),b1.getPoints());
                    }
                });
                for (int i = 0; i <Constants.MonthPoints.size() ; i++) {

                    if(Constants.user.getUser_id()==Constants.MonthPoints.get(i).getId()){
                        LeaderPoints.setText(String.valueOf(Constants.MonthPoints.get(i).getPoints()));
                        LeaderRank.setText(String.valueOf(i+1));
                    }

                }
                LeaderboardAdapter adapter = new LeaderboardAdapter(getContext(),Constants.MonthPoints);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);

            }
        });
        return view;
    }


}
