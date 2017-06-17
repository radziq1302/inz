package com.example.radzi.przewodnikmuzealny;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
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
import com.example.radzi.przewodnikmuzealny.data.dbAdapter;
import com.example.radzi.przewodnikmuzealny.data.dbContract;
import com.example.radzi.przewodnikmuzealny.data.dbHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class kwestionariusz extends AppCompatActivity {
    int q1=0;
    int q2;
    int q3;
    int suma_pkt=0;
    SQLiteDatabase mDb;
    Cursor cursor = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        Intent intent = getIntent();
        final String username = intent.getStringExtra("username");
        final String password = intent.getStringExtra("password");



        setContentView(R.layout.activity_kwestionariusz);
        final EditText tmp1 = (EditText) findViewById(R.id.tmp_1);
        final EditText tmp2 = (EditText) findViewById(R.id.tmp_2);
        final EditText tmp3 = (EditText) findViewById(R.id.tmp_3);
        final EditText tmp4 = (EditText) findViewById(R.id.tmp_4);
        final Button kwest_btn = (Button) findViewById(R.id.btn_kwestionariusz);

        final String pierwszy = tmp1.getText().toString();
        Log.i("bdxsmxxx", username);

        tmp1.setText("");
        tmp2.setText("");
        tmp3.setText("");

        kwest_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                    Response.Listener<String> kwestionariusz_change_value = new Response.Listener<String>() {

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
                                Toast ab = Toast.makeText(context, "kwestionariusz wyslales", Toast.LENGTH_SHORT);
                                ab.show();
                                suma_pkt = q1+q2+q3;
                                java_singleton.summa = q1+q2+q3;


                                Log.i("sumka", "wartosc = " + suma_pkt);
                                Log.i("summa", "MM_wartosc = " + java_singleton.summa);
                                Intent intent = new Intent(kwestionariusz.this, postLogExChoice.class);
                                //// tutaj dać summę
                                intent.putExtra("suma punktow", suma_pkt);
                                kwestionariusz.this.startActivity(intent);

                                //}
                            } catch (JSONException e1) {
                                e1.printStackTrace();

                            }
                        }

                    };
                if (!("".equals(tmp1.getText().toString()))&&!("".equals(tmp2.getText().toString()))&&!("".equals(tmp3.getText().toString()))&&!("".equals(tmp4.getText().toString())) ){
                    kwestionariuszChangeValue kwestionariuszRequest = new kwestionariuszChangeValue(username, password, java_singleton.summa, kwestionariusz_change_value);
                    dbAdapter mDbHelper = new dbAdapter(getApplicationContext());
                    mDbHelper.createDatabase();
                    mDbHelper.open();

                    Cursor testdata = mDbHelper.getTestData();

                    mDbHelper.close();
                    String kaput = testdata.getColumnName(2);

                    Log.e("costam kolumny ktorejs",kaput);

                    RequestQueue queue = Volley.newRequestQueue(kwestionariusz.this);
                    queue.add(kwestionariuszRequest);
                }


                else{
                    Context context = getApplicationContext();
                    Toast abc = Toast.makeText(context, "wypelnij wszystkie pola", Toast.LENGTH_SHORT);
                    abc.show();
                }
            }
        });
        tmp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence wyksztalcenie[] = new CharSequence[] {"podstawowe", "średnie", "wyższe techniczne", "wyższe artystyczne", "wyższe humanistyczne"};

                AlertDialog.Builder builder = new AlertDialog.Builder(kwestionariusz.this);
                builder.setTitle("Wykształcenie");
                builder.setItems(wyksztalcenie, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        tmp1.setText(wyksztalcenie[which]);
                        switch (wyksztalcenie[which].toString()) {
                            case "podstawowe": q1=0;
                            case "średnie": q1=1;
                            case "wyższe techniczne": q1=2;
                            case "wyższe artystyczne": q1=4;
                            case "wyższe humanistyczne": q1=3;
                        }
                    }
                });
                builder.show();

            }
        });
        tmp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence odwiedziny[] = new CharSequence[] {"mniej niż raz w roku","raz w roku", "2 - 3 razy w roku",  "częściej"};

                AlertDialog.Builder builder = new AlertDialog.Builder(kwestionariusz.this);
                builder.setTitle("Jak często odwiedzasz placówki kultury");
                builder.setItems(odwiedziny, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        tmp2.setText(odwiedziny[which]);
                        switch (odwiedziny[which].toString()) {
                            case "mniej niż raz w roku": q3=0;
                            case "raz w roku": q3=1;
                            case "2 - 3 razy w roku": q3=2;
                            case "częściej": q3=4;

                        }
                    }
                });
                builder.show();
            }
        });

        tmp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence wiedza[] = new CharSequence[] {"mala", "przeciętna",  "ponadprzeciętna"};

                AlertDialog.Builder builder = new AlertDialog.Builder(kwestionariusz.this);
                builder.setTitle("Jak oceniasz swoją wiedzę na temat sztuki");
                builder.setItems(wiedza, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        tmp3.setText(wiedza[which]);
                        switch (wiedza[which].toString()) {
                            case "mala": q2=0;
                            case "przeciętna": q2=1;
                            case "ponadprzeciętna": q2=4;


                        }
                    }
                });
                builder.show();
            }
        });
        tmp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence tryb[] = new CharSequence[] {"szybki", "spacerowicz",  "rekreacyjny"};

                AlertDialog.Builder builder = new AlertDialog.Builder(kwestionariusz.this);
                builder.setTitle("Jak oceniasz swoją wiedzę na temat sztuki");
                builder.setItems(tryb, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        tmp4.setText(tryb[which]);
                        switch (tryb[which].toString()) {
                            case "szybki": java_singleton.tryb_zwiedzania=1;
                            case "spacerowicz": java_singleton.tryb_zwiedzania=0;
                            case "spokojny": java_singleton.tryb_zwiedzania=2;


                        }
                    }
                });
                builder.show();
            }
        });

    }
}
