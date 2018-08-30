package com.dlc.hr_module.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dlc.hr_module.MainActivity;
import com.dlc.hr_module.Models.Level;
import com.dlc.hr_module.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 09/08/2018.
 */

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.ViewHolder> {
    List<Level>  levels = new ArrayList<>();
    Context ctx;
    public LevelAdapter(List<Level> levels , Context ctx){
        this.ctx=ctx;
        this.levels = levels;
    }

    @NonNull
    @Override
    public LevelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.levels_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LevelAdapter.ViewHolder holder, int position) {
                holder.name.setText(levels.get(position).getLevel_name());

    }

    @Override
    public int getItemCount() {
        if(levels!=null)
            return  levels.size();
        else
            return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        FrameLayout frameLayout ;
        TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            frameLayout = itemView.findViewById(R.id.frame_layout);
        }
    }
}

