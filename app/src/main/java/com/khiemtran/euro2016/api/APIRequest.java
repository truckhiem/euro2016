package com.khiemtran.euro2016.api;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.khiemtran.euro2016.Utils.General;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by khiem.tran on 04/04/2016.
 */
public class APIRequest {

    private Context mContext;
    public static final int RESPONSE_OK = 0;
    public static final int RESPONSE_FAIL = 1;

    public APIRequest(Context mContext){
        this.mContext = mContext;
    }

    public void requestGET(String url, final Handler mHandler){
        String fullUrl = url;//APIDefine.BASE_URL + url + APIDefine.API_KEY;
        RequestQueue queue = Volley.newRequestQueue(mContext);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, fullUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        General.Log("Response OK: ");
                        Message msg = new Message();
                        msg.what = RESPONSE_OK;
                        msg.obj = response;
                        mHandler.sendMessage(msg);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                General.Log("That didn't work!");
                Message msg = new Message();
                msg.what = RESPONSE_FAIL;
                mHandler.sendMessage(msg);
            }
        }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String>  params = new HashMap<String, String>();
                    params.put("Authorization", "SportDataLayer key=D05BD07B-8B07-414E-AF74-CF30B9926BE6");
                    return params;
                }
            };
        queue.add(stringRequest);
    }

}