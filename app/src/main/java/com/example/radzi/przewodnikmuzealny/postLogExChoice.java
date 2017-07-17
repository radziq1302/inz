package com.example.radzi.przewodnikmuzealny;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.radzi.przewodnikmuzealny.data.dbAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class postLogExChoice extends AppCompatActivity implements mAdapter.listItemClickListener{
    private static final int NUM_LIST_ITEM = 100;
    private mAdapter madapter;
    public static String [] opisLvl;
    public String [] oAutorze;
    Cursor oAutorach;

    private Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_log_ex_choice);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleViewOferta);
        // w celach optymalizacji
        recyclerView.setHasFixedSize(true);
        // ustawiamy LayoutManagera
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // ustawiamy animatora, który odpowiada za animację dodania/usunięcia elementów listy
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // specify an adapter (see also next example)
        ArrayList<placowka> lista_miejsc = new ArrayList<>();
        for (int i=0; i<2; i++)
            lista_miejsc.add(new placowka(i));

        madapter = new mAdapter(lista_miejsc, this);
        recyclerView.setAdapter(madapter);


        final TextView log_login = (TextView) findViewById(R.id.log_usrnm);
        final EditText log_pwd = (EditText) findViewById(R.id.log_psw);
        final EditText log_kwest = (EditText) findViewById(R.id.editText);

        Context context = getApplicationContext();
        Toast abd = Toast.makeText(context, "tunak"+ java_singleton.remember, Toast.LENGTH_SHORT);
        abd.show();
        String poziom = "opis1";
        if (java_singleton.summa <= 3)
            poziom = "opis1";
        if (java_singleton.summa > 3 &&java_singleton.summa <= 7 )
            poziom = "opis2";
        if (java_singleton.summa > 7)
            poziom = "opis3";

        dbAdapter mDbHelper = new dbAdapter(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();

        Cursor testdata = mDbHelper.getTestData("autorInfo");

        Cursor opisyLvl = mDbHelper.getTestData(poziom);
        oAutorach = mDbHelper.getTestData("autorInfo");

        mDbHelper.close();
        /*String[] abs = new String[5];
        abs[0] = testdata.getString(0);
        testdata.moveToNext();
        abs[1] = testdata.getString(0);
        String kaput = testdata.getString(0);*/
        String[] wud = wyniki(testdata);
        opisLvl = wyniki(opisyLvl);
        oAutorze = wyniki(oAutorach);
        java_singleton.autorki = wyniki(oAutorach);
        //java_singleton.autorki = wud;

        Log.e("costam kolumny ktorejs", Arrays.toString(wud));
        //final TextView welcomeMessage = (TextView) findViewById(R.id.log_psw);
        //final Button log_btn = (Button) findViewById(R.id.btnLogin);

        /*Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        int age = intent.getIntExtra("age", -1);
        int kwestionariusz = intent.getIntExtra("kwestionariusz", -1);*/

        /*String message = name + " siemka zioomq";
        Context context = getApplicationContext();
        Toast ab = Toast.makeText(context, message,Toast.LENGTH_LONG);
        ab.show();
        log_login.setText(name);
        log_pwd.setText(age+ "");
        log_kwest.setText(kwestionariusz+"");*/
        //welcomeMessage.setText(message);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem elemencik) {
        int mId = elemencik.getItemId();
        if (mId == R.id.settings)
        {   Intent startSetts = new Intent(this, settingsActivity.class);
            startActivity(startSetts);
            return true;
        }
        return super.onOptionsItemSelected(elemencik);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        if (toast!=null){
            toast.cancel();
        }
        String toastMessage = "Item #" + clickedItemIndex + " clcked.";
        toast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);
        toast.show();

        String klasa;
        switch (clickedItemIndex) {
            case 0: {klasa="msn";             Intent intent = new Intent(postLogExChoice.this, UnityExtended.class);//com.mchtr.Przewodnix.UnityPlayerNativeActivity.class);//msn.class);
                postLogExChoice.this.startActivity(intent);}
           /* case 1: klasa="tbc";Intent intent2 = new Intent(postLogExChoice.this, tbc.class);
                postLogExChoice.this.startActivity(intent2);*/

        }

    }

    public String[] wyniki (Cursor crs) {
        String[] abc = new String [crs.getCount()];
        int licznik = 0;
        crs.moveToFirst();
        for (int i = 0; i<crs.getCount(); i++) {
            abc[i] = crs.getString(0);
            crs.moveToNext();
        }
        return abc;
    }
    public class placowka {
        private String placowka_nazwa;
        private String placowka_klasa;
        private int licznik = 0;
        private String[] placowka_lista= {"Muzeum Sztuki Współczesnej w Warszawie", "Wkrótce"};
        private String[] placowka_lista_klas= {"msn", "tbc"};
        public placowka(int i){

                placowka_nazwa = placowka_lista[i];
                placowka_klasa = placowka_lista_klas[i];
                licznik++;

        }
        public String getNazwa() {
            return placowka_nazwa;
        }
        public String getNazwaClasy() {
            return placowka_klasa;
        }
    }

}
