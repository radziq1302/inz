package com.example.radzi.przewodnikmuzealny;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class kwestionariusz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        final String username = intent.getStringExtra("username");
        final String password = intent.getStringExtra("password");
        final String usr = username;
        final String pwd = password;

       // final String username = "tomek";
        //final String password = "qwerty";
        setContentView(R.layout.activity_kwestionariusz);
        final EditText tmp1 = (EditText) findViewById(R.id.tmp_1);
        final EditText tmp2 = (EditText) findViewById(R.id.tmp_2);
        final Button kwest_btn = (Button) findViewById(R.id.btn_kwestionariusz);


        Log.i("bdxsm", username);
        //Log.i("bdxsma", pwd);
        kwest_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Response.Listener<String> kwestionariusz_change_value = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonobj = new JSONObject(response);
                            boolean success = jsonobj.getBoolean("success");
                            //if (success) {
                                //jsonobj.put("kwestionariusz", 1);

                                //jsonobj.getInt("kwestionariusz");
                               /* Intent intent = new Intent(kwestionariusz.this, log_in.class);
                                startActivity(intent);*/
                                Context context = getApplicationContext();
                                Toast ab = Toast.makeText(context, "kwesionariusz wyslales",Toast.LENGTH_SHORT);
                                ab.show();
                            //}
                        }
                        catch (JSONException e1) {
                            e1.printStackTrace();

                            }
                        }

                };
                kwestionariuszChangeValue kwestionariuszRequest = new kwestionariuszChangeValue(username, password, kwestionariusz_change_value);
                RequestQueue queue = Volley.newRequestQueue(kwestionariusz.this);
                queue.add(kwestionariuszRequest);
            }
        });

    }
}
