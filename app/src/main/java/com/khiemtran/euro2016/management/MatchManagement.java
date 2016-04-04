package com.khiemtran.euro2016.management;

import android.content.Context;

import com.khiemtran.euro2016.R;
import com.khiemtran.euro2016.Utils.General;
import com.khiemtran.euro2016.models.GroupModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by khiem.tran on 04/04/2016.
 */
public class MatchManagement {

    private static MatchManagement instance;
    private Context mContex;
    private int[] lstGroupId = {R.string.group_id_A,R.string.group_id_B,R.string.group_id_C,
            R.string.group_id_D,R.string.group_id_E,R.string.group_id_F};
    private ArrayList<GroupModel> lstGroup = new ArrayList<>();

    public static MatchManagement getInstance(){
        if(instance == null){
            instance = new MatchManagement();
        }
        return instance;
    }

    public void loadData(Context mContext){
        this.mContex = mContext;
        String strData = General.readJsonFromRaw(mContext, R.raw.match_list);
        try {
            JSONObject jsonObject = new JSONObject(strData);
            for (int i = 0; i < jsonObject.length(); i++) {
                GroupModel group = new GroupModel(jsonObject.getJSONArray(mContext.getString(lstGroupId[i])));
                group.setGroupID(mContext.getString(lstGroupId[i]));
                group.setGroupName(mContext.getString(General.getGroupNameFromID(lstGroupId[i])));
                lstGroup.add(group);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
