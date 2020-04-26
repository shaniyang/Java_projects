package com.example.viikko104;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private String url_add;
    private String old_url;
    private String next_url;
    WebView web;
    EditText text;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button go = findViewById(R.id.searchbutton);
        Button refresh = findViewById(R.id.refreshbutton);
        Button back = findViewById(R.id.backbutton);
        Button forward = findViewById(R.id.forwardbutton);
        text = findViewById(R.id.text);
        web = findViewById(R.id.webButton);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://lut.fi");

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.setWebViewClient(new WebViewClient());
                url_add = text.getText().toString();
                if (!url_add.startsWith("http://") && !url_add.startsWith("https://")) {
                    url_add = "http://" + url_add;
                }
                old_url = web.getUrl();
                web.loadUrl(url_add);
                System.out.println(url_add);

            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url_add = web.getUrl();
                web.loadUrl(url_add);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next_url = web.getUrl();
                web.loadUrl(old_url);
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                old_url = web.getUrl();
                web.loadUrl(next_url);
            }
        });

    }
}
