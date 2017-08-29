package com.tando.school;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Display setting icon. Using onCreateOptionsMenu method

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //cast the menu xml called settingicon into the Menu inflater
        getMenuInflater().inflate(R.menu.settingicon, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //Called a boolean called onOptionsItemSelected

    @Override
    //Called when a panel's menu is opened by the user
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            //case that the user clicks on the setting icon
            case R.id.settingsIcon:
                //when the user clicks, it open a loadPreferenceActivity
                Intent intent = new Intent(this, loadPreferenceActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //link to FaceBook
    public void fbClick (View view) {
        //use startActivity and Intent methods to parse the link
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/flitetest/")));
    }
    //google+
    public void googleClick (View view) {
        //use startActivity and Intent methods to parse the link
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/u/0/+google")));
    }
    //LinkedIn
    public void linkedInClick (View view) {
        //use startActivity and Intent methods to parse the link
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/mbacsusb/")));
    }
    //youtube
    public void youTubeClick (View view) {
        //use startActivity and Intent methods to parse the link
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCwqJShoifP6032UXYe-sD-A")));
    }
    //Twitter
    public void twitterClick (View view) {
        //use startActivity and Intent methods to parse the link
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Google")));
    }

    //MySchoolAccount
    public void StartAccount (View v) {
        startActivity(new Intent(this, MySchoolAccount.class));
    }

    //Announcement Activity
    public void StartAnnoucement (View view) {
        startActivity(new Intent(this, Announcement.class));
    }
    //feedback activity
    public void StartFeedback (View view) {
        startActivity(new Intent(this, Feedback.class));
    }
    //Utilities activity
    public void StartUtils (View view) {
        startActivity(new Intent(this, Utilities.class));
    }
}
