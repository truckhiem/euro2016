package com.khiemtran.euro2016.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.khiemtran.euro2016.R;
import com.khiemtran.euro2016.Utils.General;
import com.khiemtran.euro2016.application.EuroApplication;
import com.khiemtran.euro2016.management.TeamManagement;
import com.khiemtran.euro2016.models.TeamModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by khiem.tran on 05/04/2016.
 */
public class ListTeamAdapter extends RecyclerView.Adapter<ListTeamAdapter.ViewHolder> {
    private ArrayList<TeamModel> lstTeam;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        // each data item is just a string in this case
        private SparseBooleanArray selectedItems;
        public TextView mTxtTeamName;
        public ImageView mImgFlag;
        public ViewHolder(View v) {
            super(v);
            mTxtTeamName = (TextView) v.findViewById(R.id.txt_team_name);
            mImgFlag = (ImageView) v.findViewById(R.id.img_team_flag);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            General.Log("asdasdasdasdasdasd");
//            if (selectedItems.get(getAdapterPosition(), false)) {
//                selectedItems.delete(pos);
//                myBackground.setSelected(false);
//            }
//            else {
//                selectedItems.put(getAdapterPosition(), true);
//                myBackground.setSelected(true);
//            }
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListTeamAdapter() {
        lstTeam = TeamManagement.getInstance().getLstTeam();
        mContext = EuroApplication.getAppContext();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ListTeamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTxtTeamName.setText(lstTeam.get(position).getTeamName());
        int id = mContext.getResources().getIdentifier(lstTeam.get(position).getTeamFlag().toLowerCase(), "drawable", mContext.getPackageName());
        holder.mImgFlag.setImageResource(id);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return lstTeam.size();
    }
}
