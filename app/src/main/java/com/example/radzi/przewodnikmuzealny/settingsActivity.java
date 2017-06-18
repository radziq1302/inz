package com.example.radzi.przewodnikmuzealny;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by radzi on 2017-06-18.
 */

public class settingsActivity extends AppCompatActivity{
    Button logout;
    View view;
    autolog akcja;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        logout = (Button) findViewById(R.id.button_logout);
        akcja = new autolog(this);
        ActionBar aBar = this.getSupportActionBar();
        if (aBar !=null) {
            aBar.setDisplayHomeAsUpEnabled(true);
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                akcja.setLog(false);
                Intent logIntent = new Intent(getApplicationContext(),log_in.class);
                startActivity(logIntent);
            }
                                  }
        );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem elemencik) {
        int mId = elemencik.getItemId();
        if (mId == R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(elemencik);
    }
}
