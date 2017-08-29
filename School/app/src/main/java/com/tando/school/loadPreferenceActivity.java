package com.tando.school;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by tando on 5/31/17.
 */
//load the pref.xml into an activity
public class loadPreferenceActivity extends Activity {
    @Override
    //use onCreate method
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //load preferenceActivity as an activity
        getFragmentManager().beginTransaction().replace((android.R.id.content),
                new preferenceActivity()).commit();
    }
}
