package com.example.radzi.przewodnikmuzealny;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by radzi on 2017-05-31.
 */

public class msn extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        int age = intent.getIntExtra("age", -1);
        int kwestionariusz = intent.getIntExtra("kwestionariusz", -1);
        //boolean newbe1 = (kwestionariusz != 0);

            setContentView(R.layout.activity_post_log);


        final TextView log_login = (TextView) findViewById(R.id.log_usrnm);
        final EditText log_pwd = (EditText) findViewById(R.id.log_psw);
        final EditText log_kwest = (EditText) findViewById(R.id.editText);
        //final TextView welcomeMessage = (TextView) findViewById(R.id.log_psw);
        //final Button log_btn = (Button) findViewById(R.id.btnLogin);

        /*Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        int age = intent.getIntExtra("age", -1);
        int kwestionariusz = intent.getIntExtra("kwestionariusz", -1);*/

        String message = name + " siemka zioomq";
        Context context = getApplicationContext();
        Toast ab = Toast.makeText(context, message,Toast.LENGTH_LONG);
        ab.show();
        log_login.setText(name);
        log_pwd.setText(age+ "");
        log_kwest.setText(kwestionariusz+"");
        //welcomeMessage.setText(message);

    }
}
