package com.gainwise.exceptionbuddytestapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gainwise.exceptionbuddy.ExceptionBuddy;

import java.math.BigDecimal;

public class Case1Activity extends AppCompatActivity {

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case1);

        ExceptionBuddy exceptionBuddy = new ExceptionBuddy.Builder(this)
                                                .automaticallyInvokePostExceptionActivity(true)
                                                .setPostExceptionActivity(MyPostExceptionActivity.class)
                                                .withExceptionDirective(new Case1Directive())
                                                .build();



    }

    public void case1_bt1_click(View v){
        BigDecimal bd1 = new BigDecimal("23dd");
        BigDecimal bd2 = new BigDecimal(0);
        TextView tv = findViewById(R.id.case1_tv1);

        tv.setText(bd1.divide(bd2).toString());

    }

    public void case1_bt2_click(View v){
        new CrashASyncTask().execute();

    }

    class CrashASyncTask extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {


            String h = et.getText().toString();

            return null;
        }
    }
}
