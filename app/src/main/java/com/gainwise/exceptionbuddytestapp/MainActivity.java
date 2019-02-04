package com.gainwise.exceptionbuddytestapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void main_act_bt1_click(View v){
       startActivity(new Intent(MainActivity.this, Case1Activity.class));
    }

    public void main_act_javadocs_click(View v){
        openWeb("https://www.gainwisetech.com/javadocs/ExceptionBuddy/");
    }

    public void main_act_lib_source_click(View v){
        openWeb("https://github.com/Gaineyj0349/ExceptionBuddy");
    }

    public void main_act_app_source_click(View v){
        openWeb("https://github.com/Gaineyj0349/ExceptionBuddyApp");
    }

    public void openWeb(String url){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

}
