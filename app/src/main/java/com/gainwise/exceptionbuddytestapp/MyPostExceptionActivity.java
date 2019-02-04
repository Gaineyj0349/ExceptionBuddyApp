package com.gainwise.exceptionbuddytestapp;

import android.os.Bundle;

import com.gainwise.exceptionbuddy.PostExceptionActivity;

public class MyPostExceptionActivity extends PostExceptionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_post_exception);
        
    }
}
