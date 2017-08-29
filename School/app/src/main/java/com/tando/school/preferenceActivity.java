package com.tando.school;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

/**
 * Created by tando on 5/31/17.
 */
//use PreferenceFragment class
public class preferenceActivity extends PreferenceFragment {
    //use onCreate method to get the pref.xml
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //use addPreferencesFromResource to add the pref.xml
        addPreferencesFromResource(R.xml.pref);
    }
}
