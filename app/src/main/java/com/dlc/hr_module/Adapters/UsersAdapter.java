package com.dlc.hr_module.Adapters;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.dlc.hr_module.Users.PersonalInfoFragment;
import com.dlc.hr_module.Users.UserProfilesFragment;
import com.dlc.hr_module.Users.UsersFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by hp on 26/08/2018.
 */

public class UsersAdapter extends BaseAdapter{
    private Context context;
    private String searchText;
    List<User>allUsers;
    ApiService api;
    FragmentManager fm ;


    public UsersAdapter(Context context, List<User>allUser,FragmentManager fm) {
        this.context = context;
        this.allUsers = allUser;
        this.fm = fm;
    }

    @Override
    public int getCount() {
        return Constants.AllUsers.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;

        if(convertView==null){
            gridView = new View(context);


            gridView = inflater.inflate(R.layout.user_row,null);
            ImageView imageView = gridView.findViewById(R.id.UserImage);

            TextView userName= gridView.findViewById(R.id.UserName);
            TextView userTeam = gridView.findViewById(R.id.UserTeam);
            TextView userPosition = gridView.findViewById(R.id.UserPosition);

            userName.setText(allUsers.get(position).getName());
               userTeam.setText(allUsers.get(position).getTeam());
          userPosition.setText(allUsers.get(position).getPosition());
          if(allUsers.get(position).getUser_image().isEmpty()){
              Picasso.get().load(R.drawable.user).fit().into(imageView);
          }else{
              Picasso.get().load(allUsers.get(position).getUser_image()).fit().into(imageView);
          }
        gridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          fm.beginTransaction().replace(R.id.userfragment,new UsersFragment()).commit();
            }
        });

        }
        else
        {
            gridView = convertView;

        }
return gridView;
    }
}
