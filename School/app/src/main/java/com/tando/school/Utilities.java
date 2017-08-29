package com.tando.school;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Utilities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilities);
    }

    //Calendar
    public void StartCalendar (View view) {
        startActivity(new Intent(this, Calendar.class));
    }
    //GPA Calculator
    public void StartGPACal (View view) {
        startActivity(new Intent(this, GPAcalculator.class));
    }
    //MyLocation
    public void StartLoc (View view) {
        startActivity(new Intent(this, MyLocation.class));
    }
    //Location

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
}
