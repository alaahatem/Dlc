package com.dlc.hr_module.Constants;

import com.dlc.hr_module.Models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hp on 28/08/2018.
 */

public class Constants {
    public static User user = new User("Alaa Kurdi", "alaakurdi@deemalab.com", "1234");


    public static User user1 = new User("Alaa Kurdi", "alaakurdi@deemalab.com", "1234");
    public static User user2 = new User("Alaa Kurdi", "alaakurdi@deemalab.com", "1234");
    public static User user3 = new User("Alaa Kurdi", "alaakurdi@deemalab.com", "1234");
    public static User user4 = new User("Alaa Kurdi", "alaakurdi@deemalab.com", "1234");
    List<User> AllUsers = new ArrayList<User>(Arrays.asList(new User[]{user1, user, user3, user4}));

}
