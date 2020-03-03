package com.example.retrofitlib;

import android.util.Log;


import com.example.retrofitlib.model.BaseResultEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public abstract class ListenCallback<T> implements Callback<BaseResultEntity<T>> {


    @Override
    public void onResponse(Call<BaseResultEntity<T>> call,Response<BaseResultEntity<T>> response ) {
        try {
           Log.e("TagXiong","请求地址"+response.raw().request().url());
            if(response.isSuccessful()) {
                if (response!=null) {
                    if(response.body().getCode()==200){
                        onSuccess(response.body().getData());
                    }else{
                        onFailure(new InvokedError(InvokedError.TYPE_ERROR_NET));
                    }

                }else{
                    onFailure(new InvokedError(InvokedError.TYPE_ERROR_GSON));
                }
            }else{
                onFailure(new InvokedError(InvokedError.TYPE_ERROR_GSON));
            }
        }catch (Exception e){
            onFailure(new InvokedError(InvokedError.TYPE_ERROR_GSON));
        }

    }



    @Override
    public void onFailure(Call<BaseResultEntity<T>> call, Throwable t) {
        InvokedError error = new InvokedError(InvokedError.TYPE_ERROR_NET);

        onFailure(error);
    }



    public abstract void onFailure(InvokedError error);

    public abstract void onSuccess(T response);

    public void onSuccessResponseBody(BaseResultEntity<T> response){

    }

    public void onSuccessGoResponseBody(String response){

    }



}
