package com.dlc.hr_module.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dlc.hr_module.Models.User;
import com.dlc.hr_module.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 02/09/2018.
 */

public class VacationsAdapter extends RecyclerView.Adapter<VacationsAdapter.ViewHolder> {
    List<User> users;
    Context ctx;
    public VacationsAdapter(List<User> users, Context ctx) {
        this.users = users;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public VacationsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_row,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VacationsAdapter.ViewHolder holder, int position) {
        holder.dates.setText(users.get(position).getVacation_days().get(position));
    }

    @Override
    public int getItemCount() {
        if(users.isEmpty()){
            return  0;
        }else{
            return  users.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dates;
        public ViewHolder(View itemView) {
            super(itemView);
            dates = itemView.findViewById(R.id.Dates);
        }
    }
}
