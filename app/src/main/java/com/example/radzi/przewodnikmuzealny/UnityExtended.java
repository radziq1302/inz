package com.example.radzi.przewodnikmuzealny;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;

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
        //String DB_PATH = "/data/data/" + context.getPackageName() + "/" + "databases/items1.db";
        //Log.v("To jest wynik singleton",""+java_singleton.summa);
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
        opisyLvl.close();
        oAutorach.close();
        String opisLvlFull="";
        for (String s : opisLvl)
        {
            opisLvlFull = opisLvlFull + s + ";";
        }
        //java_singleton.autorki = wyniki(oAutorach);
       // Log.v("jeden String",opisLvlFull);
        akcja = new autolog(this);
        Integer sum = akcja.sumOfQuestionnaire();
        //java_singleton.summa;
        String tygrys = sum.toString();
        String [] tygrys1 = oAutorze;
        //tygrys = oAutorze[1];
        super.onCreate(savedInstanceState);
        UnityPlayer.UnitySendMessage("xxx", "OdbiorDanych", tygrys);//tygrys1[1]); // tygrys1); nie mozna tak zrobic, mozna wrzucac w odpowiednie miejsca odpowiednie rzeczy == dlugi kod
        //UnityPlayer.UnitySendMessage("abx", "OdbiorDanych1", DB_PATH);//opisLvlFull);
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
        crs.close();
        return abc;
    }
}
