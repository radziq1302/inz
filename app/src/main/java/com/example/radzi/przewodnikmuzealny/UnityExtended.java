package com.example.radzi.przewodnikmuzealny;


import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

/**
 * Created by radzi on 2017-06-25.
 */

public class UnityExtended extends UnityPlayerActivity {
    public static Context context;
    autolog akcja;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        akcja = new autolog(this);
        Integer sum = akcja.sumOfQuestionnaire();
        //java_singleton.summa;
        String tygrys = sum.toString();
        super.onCreate(savedInstanceState);
        UnityPlayer.UnitySendMessage("xxx", "PluginWrapper", tygrys);
        context = this;
    }
}
