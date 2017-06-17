package com.example.radzi.przewodnikmuzealny.data;

import android.provider.BaseColumns;

/**
 * Created by radzi on 2017-06-16.
 */

public class dbContract {

    public static final class WaitlistEntry implements BaseColumns {
        public static final String TABLE_NAME = "Dane uzytkownika";
        public static final String COLUMN_NAME = "Name";
        public static final String COLUMN_ENTRIES = "ile wizyt";
        public static final String COLUMN_EDUCATION = "wyksztalcenie";
        public static final String COLUMN_POINTS = "punkty";
        public static final String COLUMN_LAST_LAUNCH = "ostatnia wizyta";
    }
}
