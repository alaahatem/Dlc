package com.dlc.hr_module.Constants;

import com.dlc.hr_module.Models.Leaderboard;
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
  public static List<String> Vacation_days = new ArrayList<String>(Arrays.asList("13-2-2018", "14-2-2018", "12-3-2012", "22-1-2018"));
  public static List<String> Sick_leaves = new ArrayList<String>(Arrays.asList("15-4-2018", "16-7-2018"));
  public static List<String> WorkFromHome = new ArrayList<String>(Arrays.asList("02-5-2018", "03-5-2018"));
  public static User user = new User(1, "Alaa Kurdi", "alaakurdi@deemalab.com", "1234", "Android", "Android Developer", "Intern", "1-2-1997", "MET", "GUC", "https://image.ibb.co/mYOosp/myimage.jpg", Vacation_days, Sick_leaves, WorkFromHome,"01007687756","Off Premises");


  public static User user1 = new User(2, "Ali Waleed", "aluwilliams@deemalab.com", "1234", "Frontend", "Frontend Developer", "Part-time", "26-1-1997", "MET", "GUC", "", Vacation_days, Sick_leaves, WorkFromHome,"01002938849","Off Premises");

  public static User user2 = new User(3, "Ahmed kamal", "dodo@deemalab.com", "1234", "Frontend", "Frontend Developer", "Part-time", "26-1-1997", "MET", "GUC", "", Vacation_days, Sick_leaves, WorkFromHome,"","Off Premises");
  public static User user3 = new User(4, "Mohab Amr", "moha@deemalab.com", "1234", "Frontend", "Frontend Developer", "Part-time", "26-1-1997", "MET", "GUC", "", Vacation_days, Sick_leaves, WorkFromHome,"","Off Premises");

  public static List<User> AllUsers = new ArrayList<User>(Arrays.asList(new User[]{user1, user, user2,user3}));

  public static Leaderboard leaderboard = new Leaderboard(1, "Alaa Hatem Kurdi", "Android", 160);
  public static Leaderboard leaderboard1 = new Leaderboard(2,"Ali Waleed", "Frontend", 280);
  public static Leaderboard leaderboard2 = new Leaderboard(3, "Ahmed kamal", "Android", 200);
  public static Leaderboard leaderboard3 = new Leaderboard(4, "Mohab Amr", "Android", 170);
  public static List<Leaderboard> WeekPoints = new ArrayList<Leaderboard>(Arrays.asList(new Leaderboard[]{leaderboard, leaderboard1, leaderboard2,leaderboard3}));
  public static Leaderboard leaderboardM = new Leaderboard(1, "Alaa Hatem Kurdi", "Android", 1600);
  public static Leaderboard leaderboardM1 = new Leaderboard(2, "Ali Waleed", "Frontend", 1800);
  public static Leaderboard leaderboardM2 = new Leaderboard(3, "Ahmed kamal", "Android", 2000);
  public static Leaderboard leaderboardM3 = new Leaderboard(4, "Mohab Amr", "Android", 1700);
  public static List<Leaderboard> MonthPoints = new ArrayList<Leaderboard>(Arrays.asList(new Leaderboard[]{leaderboardM, leaderboardM1, leaderboardM2, leaderboardM3}));

}
