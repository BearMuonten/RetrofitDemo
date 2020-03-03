package com.example.retrofitlib;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;


public class CookieManager implements CookieJar {

    private static final String TAG = "CookieManager";

    CookieJar cookieJar;

    public CookieManager(CookieJar cookieJar) {
        this.cookieJar = cookieJar;
    }

    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        cookieJar.saveFromResponse(url,cookies);
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        return cookieJar.loadForRequest(url);
    }
}
