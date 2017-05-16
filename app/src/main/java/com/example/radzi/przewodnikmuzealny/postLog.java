package com.example.radzi.przewodnikmuzealny;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class postLog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_log);

        final TextView log_login = (TextView) findViewById(R.id.log_usrnm);
        final EditText log_pwd = (EditText) findViewById(R.id.log_psw);
        //final TextView welcomeMessage = (TextView) findViewById(R.id.log_psw);
        //final Button log_btn = (Button) findViewById(R.id.btnLogin);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        int age = intent.getIntExtra("age", -1);

        String message = name + "siemka zioomq";
        Context context = getApplicationContext();
        Toast ab = Toast.makeText(context, message,Toast.LENGTH_LONG);
        ab.show();
        log_login.setText(name);
        log_pwd.setText(age+ "");
        //welcomeMessage.setText(message);

    }
}
