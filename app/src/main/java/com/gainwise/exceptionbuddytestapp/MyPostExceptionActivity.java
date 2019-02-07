package com.gainwise.exceptionbuddytestapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gainwise.exceptionbuddy.ExceptionBuddyUtils;
import com.gainwise.exceptionbuddy.PostExceptionActivity;
import com.squareup.picasso.Picasso;

public class MyPostExceptionActivity extends PostExceptionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_post_exception);

        getSupportActionBar().setTitle("WOOOPS");

        ImageView imageView = findViewById(R.id.post_act_iv);

        Picasso.get().load(R.drawable.spawner).into(imageView);
        RotateAnimation rotate = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );
        rotate.setDuration(3500);

        rotate.setRepeatCount(Animation.INFINITE);
        imageView.startAnimation(rotate);
        
    }

    private String buildString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n\n#### APP ERROR START ####\n\n");
        sb.append(EXCEPTION_REPORT);
        sb.append("#### APP ERROR END ####\n\n\n\n");

        if(!DEV_CUSTOM_CODE_COMPLETED){
            sb.append("### DEV ERROR START ###\n");
            sb.append(EXCEPTION_REPORT);
            sb.append("### DEV ERROR END ###\n\n\n\n");
        }

        sb.append(PHONE_INFO);


        return sb.toString();
    }


    public void post_act_finish(View v){

        finishAffinity();
    }


    public void post_act_see_log(View v){

        BottomSheetDialog sheetDialog = new BottomSheetDialog(this);
        sheetDialog.setCancelable(true);
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        TextView tv = view.findViewById(R.id.bottom_sheet_tv);

        sheetDialog.setContentView(view);
        tv.setText(buildString());
        sheetDialog.show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        //be sure to clear the data from this current exception, as to keep accurate record of exception.
        ExceptionBuddyUtils.clearData(this);
    }

    public void post_act_send_email(View v){
        sendEmail(buildString());
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
