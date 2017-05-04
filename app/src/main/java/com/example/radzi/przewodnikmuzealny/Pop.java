package com.example.radzi.przewodnikmuzealny;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;



/**
 * Created by radzi on 2017-05-02.
 */

public class Pop extends FragmentActivity {
        private int width;
    private int heigth;
    public int dupka; // jak w log_in ustalić zmienną, której wartość będzie w pop. moze interface
    // if layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pop_login);
        /*DisplayMetrics dimens = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dimens);
        width=dimens.widthPixels;
        heigth=dimens.heightPixels;
        getWindow().setLayout((int) (width*0.7),(int) (heigth*0.8));
// dodaj hinty do xmla
*/

    }
    public void showDialog(View v) {

        DialogFragment abc = new FireMissilesDialogFragment();
        //abc.show(getSupportFragmentManager(),"my_dialog_tag");
        android.support.v4.app.FragmentManager x = this.getSupportFragmentManager();
        abc.show(this.getFragmentManager(),"sda");


    }

}
