package com.example.radzi.przewodnikmuzealny;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

/**
 * Created by radzi on 2017-05-03.
 */

public class FireMissilesDialogFragment extends DialogFragment {


    public interface FireMissilesDialogListener {
        public void onDialogPositiveClick();
        public void onDialogNegativeClick(DialogFragment dialog);
    }
    FireMissilesDialogListener mListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (FireMissilesDialogListener) context;

        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString()+"must implements Listener");
        }
    }   

    }