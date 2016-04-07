package com.khiemtran.euro2016;

import android.os.Bundle;

import com.khiemtran.euro2016.base.BaseActivity;
import com.khiemtran.euro2016.management.MatchManagement;
import com.khiemtran.euro2016.management.TeamManagement;

/**
 * Created by khiem.tran on 05/04/2016.
 */
public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TeamManagement.getInstance().loadData(this);
        MatchManagement.getInstance().loadData(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }
}

