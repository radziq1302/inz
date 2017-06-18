package com.example.radzi.przewodnikmuzealny;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by radzi on 2017-06-18.
 */

public class autolog extends AppCompatActivity {
    Context contxt;
    SharedPreferences.Editor editor_shr;

    SharedPreferences shr;


    public autolog(Context contxt) {
        this.contxt = contxt;
        shr = contxt.getSharedPreferences("login_data", Context.MODE_PRIVATE); /// usun context
        editor_shr = shr.edit();
            }
    public boolean zaloguj () {
        return shr.getBoolean("zalogowany", false);
    }
    public void setLog(boolean zaloguj) {
        editor_shr.putBoolean("zalogowany", zaloguj);
        editor_shr.commit(); ///////aply
    }

}
