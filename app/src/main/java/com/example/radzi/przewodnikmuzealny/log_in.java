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


public class log_in extends AppCompatActivity  {
    View view;
    LayoutInflater Inflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Button login = (Button) findViewById(R.id.button);
        Button register = (Button) findViewById(R.id.button7);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent = new Intent(getApplicationContext(),register.class);
                startActivity(regIntent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logIntent = new Intent(getApplicationContext(),login.class);
                startActivity(logIntent);
            }
        });
        /* TextView log_login = (TextView) findViewById(R.id.login_username);
        TextView log_pwd = (TextView) findViewById(R.id.login_password);
        TextView reg_login = (TextView) findViewById(R.id.register_login);
        TextView reg_pwd = (TextView) findViewById(R.id.register_password);
        TextView reg_email = (TextView) findViewById(R.id.register_email);*/
        Inflater = log_in.this.getLayoutInflater();


    }




}