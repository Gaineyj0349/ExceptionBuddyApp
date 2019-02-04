package com.gainwise.exceptionbuddytestapp;

import android.util.Log;
import android.widget.Toast;

import com.gainwise.exceptionbuddy.ExceptionBuddy;
import com.gainwise.exceptionbuddy.ExceptionBuddyDirective;

class Case1Directive extends ExceptionBuddyDirective {

    /*this class is necessary - as the super class contains all of the custom exception handling code.
      an instance of this class must be provided to the ExceptionBuddy builder
    */

    //the context is given to this class from the builder object. just type context to use it

    @Override
    public void executeOnException() throws ExceptionBuddy.CrashBuddyException {

        //this is where you can place custom code to execute.
        Toast.makeText(context, "Case1Activity crash.", Toast.LENGTH_LONG).show();
        Log.i("Exception_Buddy_App", "executeOnException called");

    }


}
