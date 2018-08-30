package com.dlc.hr_module.Constants;

import com.dlc.hr_module.Models.User;
import com.dlc.hr_module.Models.UserSearch;
import com.dlc.hr_module.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hp on 28/08/2018.
 */

public class Constants {
    public static User user = new User("Alaa Kurdi", "alaakurdi@deemalab.com", "1234","Android","Android Developer","Intern","1-2-1997","MET","GUC", "https://image.ibb.co/mYOosp/myimage.jpg");


    public static User user1 = new User("Ali Waleed", "aluwilliams@deemalab.com", "1234","Frontend","Frontend Developer","Part-time","26-1-1997","MET","GUC","");

    public static User user2 = new User("Ahmed kamal", "dodo@deemalab.com", "1234","Frontend","Frontend Developer","Part-time","26-1-1997","MET","GUC","");

   public static List<User> AllUsers = new ArrayList<User>(Arrays.asList(new User[]{user1, user,user2}));

}
