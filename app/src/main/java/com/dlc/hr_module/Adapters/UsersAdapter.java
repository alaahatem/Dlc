package com.dlc.hr_module.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dlc.hr_module.ApiService;
import com.dlc.hr_module.Models.User;
import com.dlc.hr_module.Models.UserSearch;
import com.dlc.hr_module.R;
import com.dlc.hr_module.RetrofitClient;

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
    List<UserSearch>allUsers;
    ApiService api;

    public UsersAdapter(Context context, List<UserSearch>allUsers) {
        this.context = context;
        this.allUsers = allUsers;
    }

    @Override
    public int getCount() {
        return allUsers.size();
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


        }
        else
        {
            gridView = convertView;

        }
return gridView;
    }
}
