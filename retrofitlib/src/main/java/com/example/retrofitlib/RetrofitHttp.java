package com.example.retrofitlib;

import android.content.Context;
import android.util.Log;


import com.example.retrofitlib.service.TestService;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitHttp {

    public static final String BASE_URL="http://api.dev.koibone.com/v1/";

    public static String API_URL = "";
    private static GsonConverterFactory gsonConverterFactory;
    private static AuthorizationInterceptor authorizationInterceptor;
    private static MemoryCookieJar dbCookieStore;
    private static CookieJar cookieJar;

    public static TestService testService;



    public static String getApiUrl() {
        return API_URL;
    }

    public static void setApiUrl(String apiUrl) {
        API_URL = apiUrl;
    }



    public static void init() {
        dbCookieStore = new MemoryCookieJar();
        cookieJar = new CookieManager(dbCookieStore);//cookie相关manager 不使用cookie可以忽略
        gsonConverterFactory = GsonConverterFactory.create(GsonHolder.getGson());//gson解析
        authorizationInterceptor = new AuthorizationInterceptor();//拦截器

        setApiUrl(BASE_URL);

        initApi();
    }


    /**
     * 清除cookie
     */
    public static void clearAllCookie() {
        if (dbCookieStore != null) {
            dbCookieStore.removeAllCookie();
        }
        if (authorizationInterceptor != null) {

        }
    }

    /**
     * 获取cookie
     */
    public static String getLastCookie() {

        if (dbCookieStore != null) {
            List<Cookie> allCookie = dbCookieStore.getAllCookie();
            if (allCookie != null && allCookie.size() != 0) {
                return allCookie.get(0).toString();
            }
        }
        return null;
    }


    private static void initApi() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(authorizationInterceptor)
                .cookieJar(cookieJar)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(API_URL)
                .addConverterFactory(gsonConverterFactory)

                .build();


        testService = retrofit.create(TestService.class);

    }


}
