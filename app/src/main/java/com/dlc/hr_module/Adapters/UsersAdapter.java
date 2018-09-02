package com.dlc.hr_module.Adapters;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dlc.hr_module.ApiService;
import com.dlc.hr_module.Constants.Constants;
import com.dlc.hr_module.Models.User;
import com.dlc.hr_module.Models.UserSearch;
import com.dlc.hr_module.R;
import com.dlc.hr_module.RetrofitClient;
import com.dlc.hr_module.Signup.ConfigFragment;
import com.dlc.hr_module.Users.PersonalInfoFragment;
import com.dlc.hr_module.Users.UserProfilesFragment;
import com.dlc.hr_module.Users.UsersActivity;
import com.dlc.hr_module.Users.UsersFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hp on 26/08/2018.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder>{
    private Context context;
    private String searchText;
    List<User>allUsers;
    ApiService api;



    public UsersAdapter(Context context, List<User>allUser) {
        this.context = context;
        this.allUsers = allUser;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row,parent,false);
        return  new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            if(allUsers.get(position).getUser_image().isEmpty()){
                Picasso.get().load(R.drawable.user).fit().into(holder.userImage);
            }
            else{
                Picasso.get().load(allUsers.get(position).getUser_image()).into(holder.userImage);
            }
            holder.userName.setText(allUsers.get(position).getName());
            holder.userTeam.setText(allUsers.get(position).getTeam());
            holder.userPosition.setText(allUsers.get(position).getPosition());
            holder.userImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UserProfilesFragment frag = new UserProfilesFragment();
                    android.support.v4.app.FragmentManager fm = ((UsersActivity)context).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.userfragment, frag);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });

    }

    @Override
    public int getItemCount() {
        if(allUsers!=null){
            return allUsers.size();
        }
        else{
            return 0;
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView userImage;
        TextView userName, userTeam, userPosition;
        public ViewHolder(View itemView) {
            super(itemView);
        userImage = itemView.findViewById(R.id.UserImage);
        userName = itemView.findViewById(R.id.UserName);
        userTeam = itemView.findViewById(R.id.UserTeam);
        userPosition = itemView.findViewById(R.id.UserPosition);

        }
    }
}
