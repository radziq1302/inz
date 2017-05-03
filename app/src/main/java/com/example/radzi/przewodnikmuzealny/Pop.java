package com.example.radzi.przewodnikmuzealny;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.widget.Button;

/**
 * Created by radzi on 2017-05-02.
 */

public class Pop extends DialogFragment{
        private int width;
    private int heigth;
    public int dupka; // jak w log_in ustalić zmienną, której wartość będzie w pop. moze interface
    // if layout
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pop_login);
        DisplayMetrics dimens = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dimens);
        width=dimens.widthPixels;
        heigth=dimens.heightPixels;
        getWindow().setLayout((int) (width*0.7),(int) (heigth*0.8));
// dodaj hinty do xmla


    }
    */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.cancel)
                .setPositiveButton(R.string.password, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
