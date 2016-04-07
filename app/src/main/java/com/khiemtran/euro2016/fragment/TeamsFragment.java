package com.khiemtran.euro2016.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import com.khiemtran.euro2016.R;
import com.khiemtran.euro2016.Utils.General;
import com.khiemtran.euro2016.adapter.ListTeamAdapter;
import com.khiemtran.euro2016.base.BaseFragment;
import com.khiemtran.euro2016.listener.RecyclerItemClickListener;

/**
 * Created by khiem.tran on 05/04/2016.
 */
public class TeamsFragment extends BaseFragment {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_teams;
    }

    @Override
    public void initView(View rootView) {
        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list_teams);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        ListTeamAdapter mAdapter = new ListTeamAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }
        });

        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        General.Log("asdasdasdasdasdasd"+position);
                        view.setClickable(true);
                    }
                }
                ));

    }
}
