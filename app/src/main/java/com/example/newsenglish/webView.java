package com.example.newsenglish;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class webView extends AppCompatActivity {
    Toolbar toolbar;
    WebView web_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        toolbar=findViewById(R.id.toolbar);
        web_view=findViewById(R.id.webView);
        setSupportActionBar(toolbar);
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        web_view.setWebViewClient(new WebViewClient());
        web_view.loadUrl(url);
    }
}