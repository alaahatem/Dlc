package com.dlc.hr_module.Models;

/**
 * Created by hp on 03/09/2018.
 */

public class Leaderboard {
    private long id;
    private String username;
    private String team;
    private int points;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Leaderboard(long id , String username, String team, int points) {

        this.username = username;
        this.team = team;
        this.points = points;
        this.id = id;
    }
}
