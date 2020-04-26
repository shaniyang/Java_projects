package com.example.viikko105;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String url_add;
    private String old_url;
    private String next_url;
    WebView web;
    EditText text;
    ArrayList<String> url_list = new ArrayList<>();
    Integer index = 0;
    Integer maxIndex = 0;

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
                web.loadUrl(url_add);
                url_list.add(url_add);
                index = url_list.size()-1;
                maxIndex =url_list.size()-1;
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
               if (index > 0){
                   index -= 1;
                   web.loadUrl(url_list.get(index));
               }
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index > -1 || index + 1 == maxIndex){
                    index += 1;
                    web.loadUrl(url_list.get(index));
                }
            }
        });
}}
