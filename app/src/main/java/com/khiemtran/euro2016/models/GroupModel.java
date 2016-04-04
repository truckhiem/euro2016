package com.khiemtran.euro2016.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by khiem.tran on 04/04/2016.
 */
public class GroupModel {
    private String groupID;
    private String groupName;
    private ArrayList<MatchModel> lstMatch = new ArrayList<>();

    public GroupModel(JSONArray groupJson){
        try {
            for (int i = 0; i < groupJson.length(); i++) {
                MatchModel match = new MatchModel(groupJson.getJSONObject(i));
                lstMatch.add(match);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
