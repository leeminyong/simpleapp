package com.aiden.andmodule.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.aiden.andmodule.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class SharedDataActivity extends BaseActivity {

    String TAG = "SharedDataActivity";

    private static final String SETTINGS_PLAYER_JSON = "settings_item_json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedata);
    }

    public void onPutData(View view) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.add("121212");
        setStringArrayPref(SETTINGS_PLAYER_JSON, list);
        Log.e(TAG, "Put json");
    }

    public void onGetData(View view) {
        ArrayList<String> list = getStringArrayPref(SETTINGS_PLAYER_JSON);
        if (list != null) {
            for (String value : list) {
                Log.e(TAG, "Get json : " + value);
            }
        }
    }

    private void setStringArrayPref(String key, ArrayList<String> values) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        JSONArray a = new JSONArray();
        Log.e(TAG,"count of values.size()---->"+values.size());
        for (int i = 0; i < values.size(); i++) {
            a.put(values.get(i));
        }
        if (!values.isEmpty()) {
            editor.putString(key, a.toString());
        } else {
            editor.putString(key, null);
        }
        editor.apply();
    }

    private ArrayList<String> getStringArrayPref(String key) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String json = prefs.getString(key, null);
        ArrayList<String> urls = new ArrayList<String>();
        if (json != null) {
            try {
                JSONArray a = new JSONArray(json);
                for (int i = 0; i < a.length(); i++) {
                    String url = a.optString(i);
                    urls.add(url);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return urls;
    }
}
