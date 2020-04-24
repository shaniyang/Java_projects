package com.example.viikko75;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText insert = findViewById(R.id.insert);
        final EditText filename = findViewById(R.id.filename);
        Button Save = findViewById(R.id.savebutton);
        Button Load = findViewById(R.id.loadbutton);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = insert.getText().toString();
                String file = filename.getText().toString();

                FileOutputStream fos = null; //tiedostoon kirjoittaminen
                try{
                    fos = openFileOutput(file,MODE_PRIVATE);
                    fos.write(text.getBytes());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        Load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String file = filename.getText().toString();
                FileInputStream fis = null;
                try{
                    fis = openFileInput(file);
                    InputStreamReader isr = new InputStreamReader(fis);//alustus
                    BufferedReader br = new BufferedReader(isr);
                    StringBuilder sb = new StringBuilder(); //muodostaa pötkön koska bufferreader lukee vain rivin kerrallaan
                    String read = "";
                    while ((read = br.readLine())!= null){
                        sb.append(read).append("\n");
                    }
                    insert.setText(sb.toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
