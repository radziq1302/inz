package com.example.radzi.przewodnikmuzealny;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.example.radzi.przewodnikmuzealny.data.dbAdapter;
import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

/**
 * Created by radzi on 2017-06-25.
 */

public class UnityExtended extends UnityPlayerActivity {
    String[] danePoziom;
    public static Context context;
    autolog akcja;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        dbAdapter mDbHelper = new dbAdapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();
        String poziom = "opis1";
        if (java_singleton.summa <= 3)
            poziom = "opis1";
        if (java_singleton.summa > 3 &&java_singleton.summa <= 7 )
            poziom = "opis2";
        if (java_singleton.summa > 7)
            poziom = "opis3";
        Cursor opisyLvl = mDbHelper.getTestData(poziom);
        Cursor oAutorach = mDbHelper.getTestData("autorInfo");
        mDbHelper.close();
        String [] opisLvl = wyniki(opisyLvl);
        String [] oAutorze = wyniki(oAutorach);
        //java_singleton.autorki = wyniki(oAutorach);
        akcja = new autolog(this);
        Integer sum = akcja.sumOfQuestionnaire();
        //java_singleton.summa;
        String tygrys = sum.toString();
        String [] tygrys1 = oAutorze;
        tygrys = oAutorze[1];
        super.onCreate(savedInstanceState);
        String [] tygrys1 = oAutorze;
        context = this;
    }
    public String[] wyniki (Cursor crs) {
        String[] abc = new String [crs.getCount()];
        int licznik = 0;
        crs.moveToFirst();
        for (int i = 0; i<crs.getCount(); i++) {
            abc[i] = crs.getString(0);
            crs.moveToNext();
        }
        return abc;
    }
}
