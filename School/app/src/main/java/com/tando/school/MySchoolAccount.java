package com.tando.school;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MySchoolAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_school_account);
        //Cast the WebView class to the webview in the xml file
        WebView webView = (WebView) findViewById(R.id.webView);
        //enable javascript
        webView.getSettings().setJavaScriptEnabled(true);
        //Avoid jumping to browser
        webView.setWebViewClient(new WebViewClient());

        //load the url for the webview
        webView.loadUrl("https://weblogon.csusb.edu/cas/login?service=https%3A%2F%2Fmy.csusb.edu%2Fpaf%2Fauthorize");
    }
}
