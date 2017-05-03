package com.example.radzi.przewodnikmuzealny;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * Created by radzi on 2017-05-03.
 */

public class PopR  extends Activity {
    private int width;
    private int heigth;
    public int dupka; // jak w log_in ustalić zmienną, której wartość będzie w pop. moze interface
    // if layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pop_register);
        DisplayMetrics dimens = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dimens);
        width=dimens.widthPixels;
        heigth=dimens.heightPixels;
        getWindow().setLayout((int) (width*0.7),(int) (heigth*0.8));
// dodaj hinty do xmla


    }
}
