package com.example.viikko101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private String url_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button go = findViewById(R.id.searchbutton);
        EditText text = findViewById(R.id.text);
        WebView web = findViewById(R.id.webButton);
        web.setWebViewClient(new WebViewClient());

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url_add = text.getText().toString();


            }
        });

    }
}
