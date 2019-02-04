package com.gainwise.exceptionbuddytestapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gainwise.exceptionbuddy.PostExceptionActivity;

public class MyPostExceptionActivity extends PostExceptionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_post_exception);
        
    }

    public void post_act_finish(View v){
        finishAffinity();
    }


    public void post_act_send_email(View v){
        sendEmail("test");
    }

    public void sendEmail(String body){
        try {
            //String array for recipients
            String[] recipients = new String[1];
            recipients[0] = "email_here@email.com";


            Intent intent = new Intent(Intent.ACTION_SENDTO);

            // only user email apps should handle this
            intent.setData(Uri.parse("mailto:"));

            intent.putExtra(Intent.EXTRA_EMAIL, recipients);

            //email subject
            intent.putExtra(Intent.EXTRA_SUBJECT, "ExceptionBuddyApp crash report");

            //email body
            intent.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(intent);

            //finish app
            finishAffinity();

        } catch (ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email client installed on your device.", Toast.LENGTH_LONG).show();
        }

    }
}
