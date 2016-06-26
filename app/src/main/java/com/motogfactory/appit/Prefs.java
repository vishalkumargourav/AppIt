package com.motogfactory.appit;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by windows 8 on 04-06-2015.
 */
public class Prefs extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.perfs);

    }
}
