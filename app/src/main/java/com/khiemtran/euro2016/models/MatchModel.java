package com.khiemtran.euro2016.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by khiem.tran on 04/04/2016.
 */
public class MatchModel {

    private String date;
    private String timeUTC;
    private String matchId;
    private String homeTeamId;
    private String homeTeamName;
    private String awayTeamId;
    private String awayTeamName;
    private String stadiumId;
    private String stadiumName;
    private String stadiumImage;

    public MatchModel(JSONObject matchJson){
        try {
            date = matchJson.getString("date");
            timeUTC = matchJson.getString("date_time_utc");
            matchId = matchJson.getString("match_id");
            homeTeamId = matchJson.getString("hometeam_id");
            homeTeamName = matchJson.getString("hometeam_n");
            awayTeamId = matchJson.getString("awayteam_id");
            awayTeamName = matchJson.getString("awayteam_n");
            stadiumId = matchJson.getString("stadium_id");
            stadiumName = matchJson.getString("stadium_n");
            stadiumImage = matchJson.getString("stadium_thumb");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getDate() {
        return date;
    }

    public String getTimeUTC() {
        return timeUTC;
    }

    public String getMatchId() {
        return matchId;
    }

    public String getHomeTeamId() {
        return homeTeamId;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamId() {
        return awayTeamId;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public String getStadiumId() {
        return stadiumId;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public String getStadiumImage() {
        return stadiumImage;
    }
}
