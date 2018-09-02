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
  ;
    public static List<String> Vacation_days = new ArrayList<String>(Arrays.asList("13-2-2018","14-2-2018","12-3-2012", "22-1-2018"));
    public static List<String> Sick_leaves = new ArrayList<String>(Arrays.asList("15-4-2018","16-7-2018"));
    public static List<String> WorkFromHome = new ArrayList<String>(Arrays.asList("02-5-2018","03-5-2018"));
    public static User user = new User("Alaa Kurdi", "alaakurdi@deemalab.com", "1234","Android","Android Developer","Intern","1-2-1997","MET","GUC", "https://image.ibb.co/mYOosp/myimage.jpg",Vacation_days,Sick_leaves,WorkFromHome);


    public static User user1 = new User("Ali Waleed", "aluwilliams@deemalab.com", "1234","Frontend","Frontend Developer","Part-time","26-1-1997","MET","GUC","",Vacation_days,Sick_leaves,WorkFromHome);

    public static User user2 = new User("Ahmed kamal", "dodo@deemalab.com", "1234","Frontend","Frontend Developer","Part-time","26-1-1997","MET","GUC","",Vacation_days,Sick_leaves,WorkFromHome);

   public static List<User> AllUsers = new ArrayList<User>(Arrays.asList(new User[]{user1, user,user2}));


}
