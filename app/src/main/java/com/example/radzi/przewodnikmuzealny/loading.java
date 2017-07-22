package com.example.radzi.przewodnikmuzealny;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class loading extends Activity {
    autolog akcja;
    boolean dpk = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        akcja = new autolog(this);
        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);

                    //jeżeli już ktoś zalogowany to do MainActivity a jesli nie to do log_in, może zmienna boolean po zapamiętaniu logowania Tickbox
                    //Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    if (!akcja.zaloguj())   //// usunac dupk
                    {   akcja.setLog(false);
                        Intent intent = new Intent(getApplicationContext(),log_in.class);
                        startActivity(intent);

                        //Log.e ("tunaczek_false", "tunaczek "+ akcja.zaloguj());

                    }
                    else {
                        //if (login.remember1 ==true) {//(java_singleton.share.getBoolean("pamietacz",false)==true) {
                            //Log.e ("tunaczek_true", "tunaczek "+ akcja.zaloguj());
                            Intent intent_f = new Intent(getApplicationContext(), postLogExChoice.class);
                            startActivity(intent_f);
                        //}

                    }
/*                    if (java_singleton.remember == false )
                        {
                        Intent intent = new Intent(getApplicationContext(),log_in.class);
                        startActivity(intent);

                            Log.e ("tunaczek_false", "tunaczek "+ java_singleton.remember);

                        }
                    else {
                        if (java_singleton.remember ==true) {//(java_singleton.share.getBoolean("pamietacz",false)==true) {
                            Log.e ("tunaczek_true", "tunaczek "+ java_singleton.remember);
                            Intent intent_f = new Intent(getApplicationContext(), postLogExChoice.class);
                            startActivity(intent_f);
                        }

                    }*/
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
        View V = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        V.setSystemUiVisibility(uiOptions);


    }
}