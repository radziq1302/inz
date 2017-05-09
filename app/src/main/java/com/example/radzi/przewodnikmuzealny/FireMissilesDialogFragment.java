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
        public void onDialogPositiveClick(DialogFragment dialog);
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

/*    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
//
//        switch (view.getId()){
//            case R.id.
//        }

        builder.setView(inflater.inflate(lay_arg, null))
                // Add action buttons
                .setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.onDialogPositiveClick(FireMissilesDialogFragment.this);
                        // sign in the user ...
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        FireMissilesDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }*/
    }