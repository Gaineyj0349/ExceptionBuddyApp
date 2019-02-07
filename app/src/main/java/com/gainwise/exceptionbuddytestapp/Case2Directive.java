package com.gainwise.exceptionbuddytestapp;

import android.util.Log;

import com.gainwise.exceptionbuddy.ExceptionBuddy;
import com.gainwise.exceptionbuddy.ExceptionBuddyDirective;

class Case2Directive extends ExceptionBuddyDirective {

    /*this class is necessary - as the super class contains all of the custom exception handling code.
      an instance of this class must be provided to the ExceptionBuddy builder
    */

    //the context is given to this class from the builder object. just type context to use it

    @Override
    public void executeOnException() throws ExceptionBuddy.CrashBuddyException {




        /*
       This option is provided in case the developer wants to execute some simple code like changing sharedpref
       values, and still wants the android default uncaught exception behavior.
       The process has become unstable, so things like showing a toast is not possible now, maybe a future update
       this will be possible.
       */





        Log.i("Case2Directive", "process id = " + android.os.Process.myPid());
    }




}
