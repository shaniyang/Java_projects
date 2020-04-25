package com.example.viikko85;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private String s1; //viimeinen ostos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView text = findViewById(R.id.text);
        Button buy = findViewById(R.id.buybutton);
        Button add = findViewById(R.id.addbutton);
        Button returnmoney = findViewById(R.id.returnbutton);
        Button receipt = findViewById(R.id.receiptbutton);
        final SeekBar seekbar = findViewById(R.id.seekBar);
        final String[] s = {""};
        final BottleDispenser[] bo = {new BottleDispenser()};

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s[0] = bo[0].buyBottle();
                text.setText(s[0]);
                s1 = s[0];
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
        receipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = "receipt.txt";
                FileOutputStream fos = null; //alustus
                try{
                    fos = openFileOutput(filename,MODE_PRIVATE);
                    fos.write(s1.getBytes());

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
