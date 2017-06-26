package com.example.radzi.przewodnikmuzealny;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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
    static boolean remember1 = false;
    autolog akcja;
    private long klikacz = 0;
    static boolean licznik;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_login);
        final EditText log_login = (EditText) findViewById(R.id.login_username);
        final EditText log_pwd = (EditText) findViewById(R.id.login_password);
        final Button log_btn = (Button) findViewById(R.id.btnLogin);
        final Button btn_kwestionariusz = (Button) findViewById(R.id.btn_kwestionariusz);
        final CheckBox checkbox_rmb = (CheckBox) findViewById(R.id.checkbox_remember);
        akcja = new autolog(this);
        licznik = false;

        if (licznik==false) {

            log_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    licznik = true;
                    if (SystemClock.elapsedRealtime() - klikacz < 1000){
                        return;
                    }
                    klikacz  = SystemClock.elapsedRealtime();

                    final String username = log_login.getText().toString();
                    final String password = log_pwd.getText().toString();

                    Response.Listener<String> responseListenerr = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {

                                JSONObject jsonobj = new JSONObject(response);
                                boolean success = jsonobj.getBoolean("success");
                                if (success) {
                                    String name = jsonobj.getString("name");
                                    int age = jsonobj.getInt("age");
                                    int kwestionariusz = jsonobj.getInt("kwestionariusz");

                                    if (kwestionariusz == -1) {
                                        Intent intent = new Intent(login.this, kwestionariusz.class);
                                        //Intent intent = new Intent(login.this, kwestionariusz.class);
                                        intent.putExtra("name", name);
                                        intent.putExtra("username", username);
                                        intent.putExtra("password", password);
                                        intent.putExtra("kwestionariusz", kwestionariusz);
                                        login.this.startActivity(intent);

                                        Context context = getApplicationContext();
                                        Toast ab = Toast.makeText(context, "niezle, wyslales", Toast.LENGTH_SHORT);
                                        ab.show();


                                    } else {
                                        Intent intent = new Intent(login.this, postLogExChoice.class);
                                        intent.putExtra("name", name);
                                        intent.putExtra("username", username);
                                        intent.putExtra("age", age);
                                        intent.putExtra("kwestionariusz", kwestionariusz);
                                        login.this.startActivity(intent);

                                        Context context = getApplicationContext();
                                        Toast ab = Toast.makeText(context, "niezle, wyslales i masz kwestionariusz", Toast.LENGTH_SHORT);
                                        ab.show();
                                    }
                                    if (checkbox_rmb.isChecked()) {
                                        akcja.setLog(true);
/*                                    SharedPreferences shr = getSharedPreferences("login_data", MODE_PRIVATE);
                                    SharedPreferences.Editor editor_share1 = shr.edit();
                                    editor_share1.clear();
                                    editor_share1.putString("login",username);
                                    editor_share1.putString("password",password);
                                    editor_share1.putBoolean("pamietacz", remember1=true);
                                    editor_share1.commit();
                                    java_singleton.share = getSharedPreferences("login_data", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor_share = java_singleton.share.edit();
                                    editor_share.clear();
                                    editor_share.putString("login",username);
                                    editor_share.putString("password",password);
                                    editor_share.putBoolean("pamietacz", java_singleton.remember=true);
                                    editor_share.commit();*/
                                        Context context = getApplicationContext();
                                        Toast abd = Toast.makeText(context, "tuna" + akcja.zaloguj(), Toast.LENGTH_SHORT);
                                        abd.show();
                                    }
                                } else {
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



}
