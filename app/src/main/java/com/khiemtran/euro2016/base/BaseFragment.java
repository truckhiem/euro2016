package com.khiemtran.euro2016.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by khiem.tran on 05/04/2016.
 */
public abstract class BaseFragment extends Fragment {

    public BaseFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        initData();
        initView(rootView);
        return rootView;
    }

    public abstract int getLayoutId();

    public abstract void initView(View rootView);

    private void initData() {}

}
