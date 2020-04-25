package com.example.viikko82;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = findViewById(R.id.text);
        Button buy = findViewById(R.id.buybutton);
        Button add = findViewById(R.id.addbutton);
        Button returnmoney = findViewById(R.id.returnbutton);
        final String[] s = {""};
        final BottleDispenser[] bo = {new BottleDispenser()};

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s[0] = bo[0].buyBottle();
                text.setText(s[0]);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               s[0] = bo[0].addMoney();
               text.setText(s[0]);
            }
        });
        returnmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s[0] = bo[0].returnMoney();
                text.setText(s[0]);
            }
        });




    }
}
