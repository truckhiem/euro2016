package com.khiemtran.euro2016.Utils;

/**
 * Created by khiem.tran on 04/04/2016.
 */
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import android.content.Context;
import android.util.Log;

import com.khiemtran.euro2016.R;

public class General {

    public static void Log(String str){
        Log.d("Euro2016", str);
    }

    public static String readFileInRawFolder(Context mContext, int resource){
        InputStream is = mContext.getResources().openRawResource(resource);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            is.close();
            return writer.toString();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public static void writeStringToFile(String content, String filePath){
        try {
            FileOutputStream outputStream = new FileOutputStream(filePath);
            outputStream.write(content.getBytes());
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String readJsonFromRaw(Context context, int id){
        InputStream in = context.getResources().openRawResource(id);
        InputStream inputStream = context.getResources().openRawResource(id);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int ctr;
        try {
            ctr = inputStream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            Log("Read raw json fail: " + e.getMessage());
        }
        return byteArrayOutputStream.toString();
    }

    public static int getGroupNameFromID(int id){
        switch (id){
            case R.string.group_id_A: return R.string.group_name_A;
            case R.string.group_id_B: return R.string.group_name_B;
            case R.string.group_id_C: return R.string.group_name_C;
            case R.string.group_id_D: return R.string.group_name_D;
            case R.string.group_id_E: return R.string.group_name_E;
        }
        return R.string.group_name_F;
    }
}