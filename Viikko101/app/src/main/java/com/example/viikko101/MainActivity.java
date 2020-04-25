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
        final EditText text = findViewById(R.id.text);
        final WebView web = findViewById(R.id.webButton);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://lut.fi");

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.setWebViewClient(new WebViewClient());
                url_add = text.getText().toString();
                if (!url_add.startsWith("http://") && !url_add.startsWith("https://")){
                    url_add = "http://" + url_add;
                }
                web.loadUrl(url_add);

            }
        });

    }
}
