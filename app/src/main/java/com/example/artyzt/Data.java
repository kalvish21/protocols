package com.example.artyzt;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Data {

    public JSONObject retrieveProfile(Context context) {
        JSONObject json = loadJSONFile(context);
        try {
            JSONObject obj = json.getJSONObject("profile");
            return obj;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONArray retrieveFavorites(Context context) {
        JSONObject json = loadJSONFile(context);
        JSONArray array = new JSONArray();
        try {
            JSONArray all = json.getJSONArray("artists");
            for (int i = 0; i < all.length(); ++i) {
                if (all.getJSONObject(i).getBoolean("favorite")) {
                    array.put(all.getJSONObject(i));
                }
            }
            return array;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONArray retrieveEvents(Context context) {
        JSONObject json = loadJSONFile(context);
        try {
            JSONArray all = json.getJSONArray("events");
            return all;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONArray retrieveAll(Context context) {
        JSONObject json = loadJSONFile(context);
        try {
            return json.getJSONArray("artists");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private JSONObject loadJSONFile(Context context) {
        JSONObject json = null;
        try {
            InputStream inputStream = context.getAssets().open("artyztdata.json");
            int size = inputStream.available();
            byte[] byteArray = new byte[size];
            inputStream.read(byteArray);
            inputStream.close();
            json = new JSONObject(new String(byteArray, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
}
