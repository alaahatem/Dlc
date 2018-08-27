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
    ApiService api;

    public UsersAdapter(Context context, String searchText) {
        this.context = context;
        this.searchText = searchText;
    }

    @Override
    public int getCount() {
        return 0;
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
        final TextView UserNametv;
        final TextView UserTeamtv;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;

        if(convertView==null){
            gridView = new View(context);

            gridView = inflater.inflate(R.layout.user_row,null);
            ImageView imageView = gridView.findViewById(R.id.UserImage);
            UserNametv = gridView.findViewById(R.id.UserName);
            UserTeamtv = gridView.findViewById(R.id.UserTeam);
            final TextView UserPositiontv= gridView.findViewById(R.id.UserPosition);
            api = RetrofitClient.getClient().create(ApiService.class);
            Call<List<UserSearch>> userSearchCall = api.getAllUsers();
            userSearchCall.enqueue(new Callback<List<UserSearch>>() {
                @Override
                public void onResponse(Call<List<UserSearch>> call, Response<List<UserSearch>> response) {
                    if(response.isSuccessful()){
                      List<UserSearch> userSearches = response.body();
                      UserNametv.setText(userSearches.get(position).getName());
                      UserTeamtv.setText(userSearches.get(position).getTeam());
                      UserPositiontv.setText(userSearches.get(position).getPosition());
                    }
                }

                @Override
                public void onFailure(Call<List<UserSearch>> call, Throwable t) {

                    Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG).show();
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
