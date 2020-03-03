package com.example.retrofitdemo;


import com.example.retrofitlib.InvokedError;
import com.example.retrofitlib.ListenCallback;
import com.example.retrofitlib.RetrofitHttp;
import com.example.retrofitlib.model.BaseResultEntity;
import com.example.retrofitlib.model.TestResult2Entity;
import com.example.retrofitlib.model.TestResultEntity;

import retrofit2.Call;

public class ApiHelper {

    public void getConfig(ListenCallback<TestResultEntity> listenCallback){
        Call<BaseResultEntity<TestResultEntity>> config = RetrofitHttp.testService.getConfig();
        config.enqueue(listenCallback);
    }


    public void getInfo(ListenCallback<TestResult2Entity> listenCallback){
        Call<BaseResultEntity<TestResult2Entity>> config = RetrofitHttp.testService.getInfo();
        config.enqueue(listenCallback);
    }
}
