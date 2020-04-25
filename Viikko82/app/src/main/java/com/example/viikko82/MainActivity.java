package com.example.viikko82;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.text);
        Button buy = findViewById(R.id.buybutton);
        Button add = findViewById(R.id.addbutton);
        Button returnmoney = findViewById(R.id.returnbutton);


    }
}
