package com.example.retrofitlib;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;

import android.util.Log;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;


class AuthorizationInterceptor implements Interceptor {


    private static final Charset UTF8 = Charset.forName("UTF-8");

    public AuthorizationInterceptor() {

    }


    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType RAW = MediaType.parse("application/raw; charset=utf-8");


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();



        if (BuildConfig.DEBUG) {
            Log.e("TagXiong", "请求参数" + request.url());
        }
        Response response = chain.proceed(request);
        if(response.isSuccessful()){

            ResponseBody body=response.body();
            BufferedSource source = body.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();
            try {

                long contentLength = body.contentLength();
                Charset charset = UTF8;


                MediaType contentType = body.contentType();
                if (contentType != null) {
                    try {
                        charset = contentType.charset(UTF8);
                    } catch (UnsupportedCharsetException e) {
                        return response;
                    }
                }

                Buffer clone = buffer.clone();
                String str = clone.readString(charset);
                clone.close();

                if (contentLength != 0) {
                    if (BuildConfig.DEBUG) {
                        Log.e("TagXiong", "返回结果" + str);
                    }
                }

            } catch (Throwable t) {
            }

        }

        return response;
    }


    private String bodyToString(final RequestBody request){
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if(copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        }
        catch (final IOException e) {
            return "did not work";
        }
    }
}
