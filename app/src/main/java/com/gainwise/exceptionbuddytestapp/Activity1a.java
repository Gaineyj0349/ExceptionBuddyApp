package com.gainwise.exceptionbuddytestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gainwise.exceptionbuddy.ExceptionBuddy;

import java.math.BigDecimal;

public class Activity1a extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1a);

        ExceptionBuddy exceptionBuddy = new ExceptionBuddy.Builder(this)
                                                .automaticallyInvokePostExceptionActivity(true)
                                                .setPostExceptionActivity(MyPostExceptionActivity.class)
                                                .withExceptionDirective(new Activity1aDirective())
                                                .build();



    }

    public void activity1a_bt1_click(View v){
        BigDecimal bd1 = new BigDecimal("23dd");
        BigDecimal bd2 = new BigDecimal(0);
        TextView tv = findViewById(R.id.activity1a_tv1);

        tv.setText(bd1.divide(bd2).toString());

    }
}
