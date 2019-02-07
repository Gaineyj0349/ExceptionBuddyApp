package com.gainwise.exceptionbuddytestapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gainwise.exceptionbuddy.ExceptionBuddy;

import java.math.BigDecimal;

public class Case2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case2);

        ExceptionBuddy exceptionBuddy = new ExceptionBuddy.Builder(this)
                                                .automaticallyInvokePostExceptionActivity(false)
                                                .withExceptionDirective(new Case2Directive())
                                                .build();



    }

    public void case2_bt1_click(View v){
        BigDecimal bd1 = new BigDecimal("23dd");
        BigDecimal bd2 = new BigDecimal(0);
        TextView tv = findViewById(R.id.case2_tv1);

        tv.setText(bd1.divide(bd2).toString());

    }
}
