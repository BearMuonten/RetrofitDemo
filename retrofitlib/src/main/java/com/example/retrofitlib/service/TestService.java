package com.example.retrofitlib.service;

import com.example.retrofitlib.model.BaseResultEntity;
import com.example.retrofitlib.model.TestResult2Entity;
import com.example.retrofitlib.model.TestResultEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TestService {


    //测试接口1
    @GET("common/upgrade")
    Call<BaseResultEntity<TestResultEntity>> getConfig();


    //测试接口2
    @GET("common/regions")
    Call<BaseResultEntity<TestResult2Entity>> getInfo();


}
