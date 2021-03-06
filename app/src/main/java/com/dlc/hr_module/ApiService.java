package com.dlc.hr_module;

import com.dlc.hr_module.Models.Company;
import com.dlc.hr_module.Models.Criteria;
import com.dlc.hr_module.Models.Level;
import com.dlc.hr_module.Models.User;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by hp on 02/08/2018.
 */

public interface ApiService {
    @POST("signup/config/{company_name}")

    Call<Company> addcompany(@Field("company_name") String title,
                           @Field("level")ArrayList<Level> levels,
                           @Field("max_sick") int max_sick,
                           @Field("max_vac")int max_vac,
                           @Field("max_home")int max_home,
                           @Field("criteria")ArrayList<Criteria> criteria);
    @POST("signup/personal/")

    Call<User>signup(@Body User user);

    @PUT("signup/personal/{user_id}")
    @FormUrlEncoded
    Call<User>editProfile(
                    @Field("user_id") Integer id,
                    @Field("name") String name,
                     @Field("email")String email,
                     @Field("birthdate") Date birthdate,
                     @Field("college")String college,
                     @Field("major")String major,
                     @Field("criteria")URI image);

}
