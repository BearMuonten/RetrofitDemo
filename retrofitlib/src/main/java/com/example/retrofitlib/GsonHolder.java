package com.example.retrofitlib;

import com.google.gson.Gson;


public class GsonHolder {


    private Gson gson = new Gson();

    private GsonHolder() {
    }

    static class SingleHolder {
        private static final GsonHolder INSTANCE = new GsonHolder();
    }

    private static GsonHolder getInstance() {
        return SingleHolder.INSTANCE;
    }

    public static Gson getGson() {
        return getInstance().gson;
    }
}
