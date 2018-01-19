package com.example.lenovo.androidcafe;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.SimpleTimeZone;
import java.util.concurrent.ExecutionException;

/**
 * Created by Lenovo on 16/01/2018.
 */

public class MenuData {
    private static String jsondata;

    public void setJsondata(String json ){
        jsondata = json;
        Log.i("data",jsondata);

    }

    public static ArrayList<Menu> getListMenu(){
        String response = null;
        Menu menu = null;

        //Baca data

        FetchMenuData conn = (FetchMenuData) new FetchMenuData();
        conn.execute();
        try {
            jsondata = conn.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //Masukkan ke Array
        ArrayList<Menu> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsondata);
            Gson gson = new Gson();
            int i = 0;
            while (i < jsonArray.length()){
                list.add(gson.fromJson(jsonArray.getJSONObject(i).toString(), Menu.class));
                i++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;

    }
}
