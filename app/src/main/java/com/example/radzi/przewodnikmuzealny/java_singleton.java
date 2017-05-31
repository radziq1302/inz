package com.example.radzi.przewodnikmuzealny;

import android.app.Application;

/**
 * Created by radzi on 2017-05-28.
 */


////// do poprawek plag
public class java_singleton extends Application {


        private static java_singleton singleton;
        public static int summa;
        public static int tryb_zwiedzania;

        public static java_singleton getInstance() {
            return singleton;
        }

        @Override
        public void onCreate() {
            super.onCreate();
            singleton = this;
        }
}
