package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitlib.InvokedError;
import com.example.retrofitlib.ListenCallback;
import com.example.retrofitlib.RetrofitHttp;
import com.example.retrofitlib.model.TestResult2Entity;
import com.example.retrofitlib.model.TestResultEntity;

public class MainActivity extends AppCompatActivity {

    private TextView tv1, tv2;
    private ApiHelper apiHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitHttp.init();

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        apiHelper = new ApiHelper();

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData1();
            }
        });


        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData2();
            }
        });
    }


    private void getData1() {
        apiHelper.getConfig(new ListenCallback<TestResultEntity>() {
            @Override
            public void onFailure(InvokedError error) {

            }

            @Override
            public void onSuccess(TestResultEntity response) {
                Toast.makeText(MainActivity.this,"请求成功",Toast.LENGTH_LONG).show();
            }
        });
    }


    private void getData2() {
        apiHelper.getInfo(new ListenCallback<TestResult2Entity>() {
            @Override
            public void onFailure(InvokedError error) {

            }

            @Override
            public void onSuccess(TestResult2Entity response) {

                Toast.makeText(MainActivity.this,response.getVersion_flag(),Toast.LENGTH_LONG).show();


            }
        });
    }
}
