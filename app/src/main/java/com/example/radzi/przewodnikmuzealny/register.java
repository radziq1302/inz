package com.example.radzi.przewodnikmuzealny;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by radzi on 2017-05-10.
 */

public class register extends AppCompatActivity {
    private long klikacz = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_register);

        final TextView reg_login = (TextView) findViewById(R.id.register_login);
        final TextView reg_pwd = (TextView) findViewById(R.id.register_password);
        final TextView reg_email = (TextView) findViewById(R.id.register_email);
        final TextView reg_age = (TextView) findViewById(R.id.register_age);
        final Button reg_btn = (Button) findViewById(R.id.btnRegister);
        reg_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (SystemClock.elapsedRealtime() - klikacz < 1000){
                    return;
                }
                klikacz  = SystemClock.elapsedRealtime();
                final String imie = reg_login.getText().toString();
                final String nazwisko = reg_email.getText().toString();
                final String haslo = reg_pwd.getText().toString();
                final int wiek = Integer.parseInt(reg_age.getText().toString());

                Response.Listener<String> responseListenerr = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonobj = new JSONObject(response);
                            boolean success = jsonobj.getBoolean("success");
                            if (success){
                                Intent intent = new Intent(register.this, log_in.class);
                                startActivity(intent);
                                Context context = getApplicationContext();
                                Toast ab = Toast.makeText(context, "niezle, wyslales",Toast.LENGTH_SHORT);
                                //ab.show();
                            }
                        else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                                builder.setMessage("nie udalo sie zarejestrowac")
                                        .setNegativeButton("sprobuj", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegisterReq registerRequest = new RegisterReq(imie, nazwisko, wiek, haslo, responseListenerr);
                RequestQueue queue = Volley.newRequestQueue(register.this);
                queue.add(registerRequest);
            }
        });
    }



}
