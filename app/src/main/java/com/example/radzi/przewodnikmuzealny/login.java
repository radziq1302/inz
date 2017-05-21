package com.example.radzi.przewodnikmuzealny;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_login);
        final EditText log_login = (EditText) findViewById(R.id.login_username);
        final EditText log_pwd = (EditText) findViewById(R.id.login_password);
        final Button log_btn = (Button) findViewById(R.id.btnLogin);
        final Button btn_kwestionariusz = (Button) findViewById(R.id.btn_kwestionariusz);

        log_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final String username = log_login.getText().toString();
                final String password = log_pwd.getText().toString();

                Response.Listener<String> responseListenerr = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject jsonobj = new JSONObject(response);
                            boolean success = jsonobj.getBoolean("success");
                            if (success){
                                String name = jsonobj.getString("name");
                                int age = jsonobj.getInt("age");
                                int kwestionariusz = jsonobj.getInt("kwestionariusz");

                                if (kwestionariusz == 0) {
                                    //Intent intent = new Intent(login.this, postLog.class);
                                    Intent intent = new Intent(login.this, action.class);
                                    intent.putExtra("name", name);
                                    intent.putExtra("username", username);
                                    intent.putExtra("age", age);
                                    intent.putExtra("kwestionariusz", kwestionariusz);
                                    login.this.startActivity(intent);

                                    Context context = getApplicationContext();
                                    Toast ab = Toast.makeText(context, "niezle, wyslales", Toast.LENGTH_SHORT);
                                    ab.show();
                                    /*btn_kwestionariusz.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Response.Listener<String> kwestionariuszRListener = new Response.Listener<String>() {
                                                @Override
                                                public void onResponse(String response) {
                                                    try {

                                                        JSONObject jsonobj = new JSONObject(response);
                                                        boolean success = jsonobj.getBoolean("success");
                                                        if (success) {
                                                            jsonobj.put("kwestionariusz", 1);
                                                            //jsonobj.getInt("kwestionariusz");
                                                        }

                                                    } catch (JSONException e1) {
                                                        e1.printStackTrace();
                                                    }

                                                }
                                            };
                                            kwestionariuszChangeValue kwest = new kwestionariuszChangeValue(username, password, kwestionariuszRListener);
                                            RequestQueue queue = Volley.newRequestQueue(login.this);
                                            queue.add(kwest);
                                        }
                                    });*/

                                }
                                else {
                                    Intent intent = new Intent(login.this, postLog.class);
                                    intent.putExtra("name", name);
                                    intent.putExtra("username", username);
                                    intent.putExtra("age", age);
                                    intent.putExtra("kwestionariusz", kwestionariusz);
                                    login.this.startActivity(intent);

                                    Context context = getApplicationContext();
                                    Toast ab = Toast.makeText(context, "niezle, wyslales i masz kwestionariusz", Toast.LENGTH_SHORT);
                                    ab.show();
                                }
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
                                builder.setMessage("nie udalo sie zalogowac")
                                        .setNegativeButton("sprobuj", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                //
                LoginReq loginRequest = new LoginReq(username, password, responseListenerr);
                //
                RequestQueue queue = Volley.newRequestQueue(login.this);
                queue.add(loginRequest);
            }
        });
    }



}
