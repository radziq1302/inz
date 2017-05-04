package com.example.radzi.przewodnikmuzealny;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class log_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Button login = (Button) findViewById(R.id.button);
        Button register = (Button) findViewById(R.id.button7);


        //Intent a = new Intent();

       /* View.OnClickListener x = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };*/
        //login.setOnClickListener();



        //JAK zrobić jeden showdialog do
    }

    public void showDialog(View v) {

        DialogFragment abc = new FireMissilesDialogFragment(R.layout.pop_login);
        //abc.show(getSupportFragmentManager(),"my_dialog_tag");
        android.support.v4.app.FragmentManager x = this.getSupportFragmentManager();
        abc.show(this.getFragmentManager(),"sda");


    }
    public void showDialog1(View v) {

        DialogFragment abc = new FireMissilesDialogFragment(R.layout.pop_register);
        //abc.show(getSupportFragmentManager(),"my_dialog_tag");
        android.support.v4.app.FragmentManager x = this.getSupportFragmentManager();
        abc.show(this.getFragmentManager(),"sdaa");


    }
}
