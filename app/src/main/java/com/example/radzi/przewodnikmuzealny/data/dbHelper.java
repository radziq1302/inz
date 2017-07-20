package com.example.radzi.przewodnikmuzealny.data;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by radzi on 2017-06-16.
 */


public class dbHelper extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "items1.db";
    private final Context iContext;
    private static String DB_PATH;
    private SQLiteDatabase mDB;

    static final int DATABASE_VERSION = 1;
    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    public dbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.iContext = context;
        DB_PATH = "/data/data/" + context.getPackageName() + "/" + "databases/"; //context.getDatabasePath(DATABASE_NAME).getAbsolutePath() ;//
        //Log.e("Path 1", DB_PATH);
    }
    public boolean openDataBase() throws SQLException {
        String mPath = DB_PATH + DATABASE_NAME;
        mDB = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.OPEN_READWRITE);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDB != null;
    }
        //return dbFile.exists();


/*    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH;// + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }*/


    @Override
    public synchronized void close() {
        if (mDB != null)
            mDB.close();
        super.close();
    }

    public void createDataBase() throws IOException {
        /*final String SQL_CREATE_WAITLIST_TABLE = "CREATE TABLE " +
                dbContract.WaitlistEntry.TABLE_NAME +
                "(" + dbContract.WaitlistEntry._ID +
                "INTEGER PRIMARY KEY AUTOINCREMENT," +
                dbContract.WaitlistEntry.COLUMN_NAME +
                " TEXT NOT NULL, "+
                dbContract.WaitlistEntry.COLUMN_EDUCATION +
                "INTEGER NOT NULL, " +
                dbContract.WaitlistEntry.COLUMN_POINTS+"INTEGER NOT NULL, " +
                dbContract.WaitlistEntry.COLUMN_ENTRIES +"INTEGER NOT NULL, " +
                dbContract.WaitlistEntry.COLUMN_LAST_LAUNCH +"TIMESTAMP DEFAULT CURRENT_TIMESTAMP "+
                ");";
        db.execSQL(SQL_CREATE_WAITLIST_TABLE);*/
        boolean mDbExist = false;//checkDataBase();
        if (mDbExist) {
        }
        else {
            this.getReadableDatabase();
            this.close();
            try {
                this.close();
                copyDataBase();
                Log.e("abc", "Create database");
            }
            catch (IOException e)
            {
                throw new Error("ErrorCopyingDataBase");
            }
        }
        //db.execSQL("create table " + DATABASE_NAME);
    }
    private boolean checkDataBase()
    {
        File dbFile = new File(DB_PATH + DATABASE_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();

            }

    }
    public void copyDataBase () throws IOException {
        InputStream input = iContext.getAssets().open(DATABASE_NAME);

        String outFileName = DB_PATH + DATABASE_NAME;
        OutputStream output = new FileOutputStream(outFileName);
        byte[] buffer = new byte[10240];
        int length;
        while ((length = input.read(buffer))>0) {
            output.write(buffer, 0, length);
        }
        output.flush();
        output.close();
        input.close();
    }
    public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return mDB.query("a", null, null, null, null, null, null);
    }
   /* public Cursor getInfo (SQLiteDatabase db) {

        Cursor cursor;
        String[] kolumny = {dbContract.WaitlistEntry.COLUMN_NAME, dbContract.WaitlistEntry.COLUMN_ENTRIES };
        db.query()
        return cursor;
    }*/
}
