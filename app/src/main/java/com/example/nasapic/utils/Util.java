package com.example.nasapic.utils;

import android.content.Context;
import android.util.Log;

import com.example.nasapic.model.NasaPicModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    private static String getAssetJsonData(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        Log.e("data", json);
        return json;

    }
    public static List<NasaPicModel>  getNasaModel(Context context){
        List<NasaPicModel> nasaPicModels ;

        String jsonData = getAssetJsonData(context);
        Gson gson = new Gson();
        Type listType = new TypeToken<List<NasaPicModel>>(){}.getType();
        nasaPicModels = gson.fromJson(jsonData, listType);


        return nasaPicModels;

    }
}
