package com.tando.school;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutTheApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_the_app);
    }
    //as I put onClick method in the ImageView in its xml file we will call it here
    public void backHome (View view) {
        //when user clicks the image (logo) it will go to the MainActivity
        startActivity(new Intent(this, MainActivity.class));
    }
}
