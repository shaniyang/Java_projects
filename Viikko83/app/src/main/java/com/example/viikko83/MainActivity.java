package com.example.viikko83;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
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
        final SeekBar seekbar = findViewById(R.id.seekBar);
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
                Integer i = seekbar.getProgress();
                s[0] = bo[0].addMoney(i);
                text.setText(s[0]);
                seekbar.setProgress(0);

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
