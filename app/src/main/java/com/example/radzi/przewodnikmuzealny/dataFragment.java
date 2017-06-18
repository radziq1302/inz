package com.example.radzi.przewodnikmuzealny;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

/**
 * Created by radzi on 2017-06-18.
 */

public class dataFragment extends PreferenceFragmentCompat{
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.data_preference);
    }
}
