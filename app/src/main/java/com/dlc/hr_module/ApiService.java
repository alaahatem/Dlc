package com.dlc.hr_module;

import com.dlc.hr_module.Models.Company;
import com.dlc.hr_module.Models.Criteria;
import com.dlc.hr_module.Models.Level;
import com.dlc.hr_module.Models.UserRequest;
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
    @POST("signup/config/")

    Call<Company> addcompany(@Body Company company);
    @POST("signup/personal/")

    Call<UserRequest>signup(@Body UserRequest user);

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
