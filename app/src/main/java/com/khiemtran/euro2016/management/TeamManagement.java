package com.khiemtran.euro2016.management;

import android.content.Context;

import com.khiemtran.euro2016.R;
import com.khiemtran.euro2016.Utils.General;
import com.khiemtran.euro2016.models.TeamModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by khiem.tran on 04/04/2016.
 */
public class TeamManagement {

    private static TeamManagement instance;
    private Context mContex;
    private ArrayList<TeamModel> lstTeam = new ArrayList<>();

    public static TeamManagement getInstance(){
        if(instance == null){
            instance = new TeamManagement();
        }
        return instance;
    }

    public void loadData(Context mContext){
        this.mContex = mContext;
        String strData = General.readJsonFromRaw(mContext, R.raw.team_list);
        try {
            JSONObject jsonObject = new JSONObject(strData);
            JSONArray jsonArray = jsonObject.getJSONArray("teamInfoItems");
            for (int i = 0; i < jsonArray.length(); i++) {
                TeamModel group = new TeamModel(jsonArray.getJSONObject(i));
                lstTeam.add(group);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<TeamModel> getLstTeam(){return lstTeam;}
}
