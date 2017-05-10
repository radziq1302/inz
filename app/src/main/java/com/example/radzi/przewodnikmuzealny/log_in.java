package com.example.radzi.przewodnikmuzealny;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.zip.Inflater;


public class log_in extends AppCompatActivity implements View.OnClickListener, FireMissilesDialogFragment.FireMissilesDialogListener {
    View view;
    LayoutInflater Inflater;
    FireMissilesDialogFragment.FireMissilesDialogListener mListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        Inflater = log_in.this.getLayoutInflater();
        Button login = (Button) findViewById(R.id.button);
        Button register = (Button) findViewById(R.id.button7);
        register.setOnClickListener(this);
        login.setOnClickListener(this);
        TextView log_login = (TextView) findViewById(R.id.login_username);
        TextView log_pwd = (TextView) findViewById(R.id.login_password);
        TextView reg_login = (TextView) findViewById(R.id.register_login);
        TextView reg_pwd = (TextView) findViewById(R.id.register_password);
        TextView reg_email = (TextView) findViewById(R.id.register_email);

    }

    @Override
    public void onDialogPositiveClick ()
    {
        TextView log_login = (TextView) findViewById(R.id.login_username);
        TextView log_pwd = (TextView) findViewById(R.id.login_password);
        TextView reg_login = (TextView) findViewById(R.id.register_login);
        TextView reg_pwd = (TextView) findViewById(R.id.register_password);
        TextView reg_email = (TextView) findViewById(R.id.register_email);
//        final String login = reg_login.getText().toString();
//        final String email = reg_email.getText().toString();
//        final String pswd = reg_pwd.getText().toString();
        final String login = "abc0";
        final String email = "hjs";
        final String pswd = "sd3";
        Toast.makeText(getApplicationContext() , "dupka", Toast.LENGTH_LONG).show();
        //final int age = reg_login.getText().toString();
        /*Response.Listener<String>responseL = new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    *//*if (success){
                        Intent intent = new Intent(log_in.this, FireMissilesDialogFragment.class);
                        log_in.this.st
                    }
                    if (!success){
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        // Get the layout inflater
                        LayoutInflater inflater = getActivity().getLayoutInflater();
                    }*//*
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
         RegisterReq RegisterReq = new RegisterReq(login, email, pswd,responseL);*/
        //RequestQueue queue = Volley.newRequestQueue(new FireMissilesDialogFragment(R.layout.pop_register));
    }


    public void oonDialogPositiveClick ()
    {
        TextView log_login = (TextView) findViewById(R.id.login_username);
        TextView log_pwd = (TextView) findViewById(R.id.login_password);
        TextView reg_login = (TextView) findViewById(R.id.register_login);
        TextView reg_pwd = (TextView) findViewById(R.id.register_password);
        TextView reg_email = (TextView) findViewById(R.id.register_email);
//        final String login = reg_login.getText().toString();
//        final String email = reg_email.getText().toString();
//        final String pswd = reg_pwd.getText().toString();
        final String login = "abc0";
        final String email = "hjs";
        final String pswd = "sd3";
        Toast.makeText(getApplicationContext() , "dupka", Toast.LENGTH_LONG).show();
        //final int age = reg_login.getText().toString();
        /*Response.Listener<String>responseL = new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    *//*if (success){
                        Intent intent = new Intent(log_in.this, FireMissilesDialogFragment.class);
                        log_in.this.st
                    }
                    if (!success){
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        // Get the layout inflater
                        LayoutInflater inflater = getActivity().getLayoutInflater();
                    }*//*
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
         RegisterReq RegisterReq = new RegisterReq(login, email, pswd,responseL);*/
        //RequestQueue queue = Volley.newRequestQueue(new FireMissilesDialogFragment(R.layout.pop_register));
    }
    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

        // User touched the dialog's negative button
    }
    /*
    public void showDialog(View v) {

        DialogFragment abc = new FireMissilesDialogFragment(R.layout.pop_login);
        //abc.show(getSupportFragmentManager(),"my_dialog_tag");
        android.support.v4.app.FragmentManager x = this.getSupportFragmentManager();
        }*/
    @Override
    public void onClick(View v) {

        this.view = v;
        switch (v.getId()){
            case R.id.button7:
                TextView log_login = (TextView) findViewById(R.id.login_username);
                TextView log_pwd = (TextView) findViewById(R.id.login_password);
                TextView reg_login = (TextView) findViewById(R.id.register_login);
                TextView reg_pwd = (TextView) findViewById(R.id.register_password);
                TextView reg_email = (TextView) findViewById(R.id.register_email);

                v = Inflater.inflate(R.layout.pop_register, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(log_in.this);
                builder.setView(v);
                builder.setMessage("Testowa wiadomość");

                builder.setPositiveButton(R.string.register, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        TextView log_login = (TextView) findViewById(R.id.login_username);
                        TextView log_pwd = (TextView) findViewById(R.id.login_password);
                        TextView reg_login = (TextView) findViewById(R.id.register_login);
                        TextView reg_pwd = (TextView) findViewById(R.id.register_password);
                        TextView reg_email = (TextView) findViewById(R.id.register_email);

                        Response.Listener<String>responseL = new Response.Listener<String>(){

                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonResponse = new JSONObject(response);
                                    boolean success = jsonResponse.getBoolean("success");
                    /*if (success){
                                    Intent intent = new Intent(log_in.this, FireMissilesDialogFragment.class);
                                    log_in.this.st
                                }*/
                                if (!success){
                                    AlertDialog.Builder builder = new AlertDialog.Builder(log_in.this);
                                    // Get the layout inflater
                                    builder.setMessage("dupadupadupa");
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            }
                        };
                        final String login = "abc";//reg_login.getText().toString();
                        final String email = "abc";//reg_email.getText().toString();
                        final String pswd = "abc";//reg_pwd.getText().toString();

                        RegisterReq RegisterReq = new RegisterReq(login, email, pswd,responseL);
                        RequestQueue queue = Volley.newRequestQueue(log_in.this);
                        queue.add(RegisterReq);

                        /*Intent intent = new Intent(getApplicationContext(),RegisterReq.class);
                        startActivity(intent);*/
                        //mListener.onDialogPositiveClick();
                        // sign in the user ...
                        Toast.makeText(getApplicationContext() , "dupka", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //builder1.getDialog().cancel();
                    }
                });
                builder.show();
                final String login = reg_login.getText().toString();
                final String email = reg_email.getText().toString();
                final String pswd = reg_pwd.getText().toString();
                break;
            case R.id.button:
                v = Inflater.inflate(R.layout.pop_login, null);
                AlertDialog.Builder builder1 = new AlertDialog.Builder(log_in.this);
                builder1.setView(v);

                builder1.setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // mListener.onDialogPositiveClick(log_in.this);
                        // sign in the user ...
                    }
                });
                builder1.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //builder1.getDialog().cancel();
                    }
                });
                builder1.show();
                break;
        }
    }
}
