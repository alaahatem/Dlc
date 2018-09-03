package com.dlc.hr_module.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dlc.hr_module.Constants.Constants;
import com.dlc.hr_module.Models.Leaderboard;
import com.dlc.hr_module.Models.Positions;
import com.dlc.hr_module.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by hp on 03/09/2018.
 */

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.ViewHolder> {
    Context ctx;
    List<Leaderboard> Points;

    public LeaderboardAdapter(Context ctx, List<Leaderboard> points) {
        this.ctx = ctx;
        Points = points;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leader_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Toast.makeText(ctx,String.valueOf(position),Toast.LENGTH_SHORT).show();

        for (int i = 0; i <Constants.AllUsers.size() ; i++) {

            if(Points.get(position).getId()==Constants.AllUsers.get(i).getUser_id()){

                Toast.makeText(ctx, Constants.AllUsers.get(i).getName(), Toast.LENGTH_SHORT).show();
                if(!Constants.AllUsers.get(i).getUser_image().isEmpty())


                    Picasso.get().load(Constants.AllUsers.get(i).getUser_image()).fit().into(holder.imageView);
                    else
                        Picasso.get().load(R.drawable.user).fit().into(holder.imageView);

                    holder.userName.setText(Constants.AllUsers.get(i).getName());
                    holder.userTeam.setText(Constants.AllUsers.get(i).getTeam());
                    holder.userPoints.setText(String.valueOf(Points.get(position).getPoints()));
//                    holder.userNumber.setText(String.valueOf(position+1));
            }
        }

    }

    @Override
    public int getItemCount() {
       if(Points.isEmpty()){
           return 0;
       }
       else
           return Points.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView userName,userNumber,userTeam,userPoints;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            userName = itemView.findViewById(R.id.nametv);
            userNumber = itemView.findViewById(R.id.numbertv);
            userTeam = itemView.findViewById(R.id.teamtv);
            userPoints = itemView.findViewById(R.id.UserPoints);
        }
    }
}
