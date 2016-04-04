package com.khiemtran.euro2016.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by khiem.tran on 04/04/2016.
 */
public class TeamModel {
    private String teamId;
    private String teamName;
    private String teamFlag;

    public TeamModel(JSONObject teamJson){
        try {
            teamId = teamJson.getString("idTeam");
            teamName  = teamJson.getString("officialName");
            teamFlag  = teamJson.getString("teamCode");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamFlag() {
        return teamFlag;
    }
}
