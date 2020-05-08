package com.example.viikko91;

import android.content.Context;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context ctx;
    Spinner theatreSpinner;
    Spinner movieSpinner;
    ScrollView movieScroll;
    TextView showView;
    EditText editDate;
    EditText editTimeIn;
    EditText editTimeBetween;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = MainActivity.this;

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        // Components
        theatreSpinner = findViewById(R.id.theatreSpinner);
        movieSpinner = findViewById(R.id.movieSpinner);

        movieScroll = findViewById(R.id.movieScroll);
        showView = findViewById(R.id.showView);
        editDate = findViewById(R.id.editDate);
        editTimeIn = findViewById(R.id.editTimein);
        editTimeBetween = findViewById(R.id.editTimebetween);

        // Get the Area List and Convert To an Array
        MovieTheatreList mtl = MovieTheatreList.getInstance();
        mtl.readXmlAreaID();
        ArrayList<String> areaList = new ArrayList<>(mtl.getCityList());
        areaList.remove(0);
        areaList.add(0,"Choose an area/a theatre");
        String[] areaArray = new String[areaList.size()];
        areaArray = areaList.toArray(areaArray);

        // Get the Title List and Convert To an Array
        mtl.readXmlEvents();

        ArrayList<String> movieList = new ArrayList<>(mtl.getTitleList());
        movieList.add(0,"Choose a movie by title");
        String[] title = new String[movieList.size()];
        title = movieList.toArray(title);

        // Set the Spinner Dropdowns

        // Theatres dropdowd
        ArrayAdapter aa1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, areaArray);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        theatreSpinner.setAdapter(aa1);

        // Movies dropdowd
        ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, title);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        movieSpinner.setAdapter(aa2);

        System.out.println();
    }

    public void Search(View v) {
        // Search and Display shows by Date and Theatre Name.

        MovieTheatreList mtl = MovieTheatreList.getInstance();

        // Get Theatre Name
        String theatreName = theatreSpinner.getSelectedItem().toString();
        if (theatreName.matches("Choose an area/a theatre") ){
            theatreName = "Valitse alue/teatteri";
        } else {
            theatreName = theatreSpinner.getSelectedItem().toString();
            System.out.println("#######theatrename: "+theatreName);
        }

        // Get Movie Name
        String movieName = movieSpinner.getSelectedItem().toString();
        if (movieName.matches("Choose a movie by title") ){
            movieName = "";
        } else {
            movieName = movieSpinner.getSelectedItem().toString();
        }

        // Get Date
        String date = editDate.getText().toString();

        // Get time in & between

        String in = editTimeIn.getText().toString();

        // Check if inputs are empty

        if (in.matches("") ){
            in = "00:00:00";
        } else {
            in = editTimeIn.getText().toString();
        }
        in = in.replaceAll("\\D+","");
        int timeIn = Integer.parseInt(in);

        String between = editTimeBetween.getText().toString();

        if (between.matches("")){
            between = "23:59:59";
        } else {
            between = editTimeBetween.getText().toString();
        }
        between = between.replaceAll("\\D+","");
        int timeBetween = Integer.parseInt(between);

        // Search a right list by filters
        ArrayList<String> showList = new ArrayList<>(mtl.readXmlDateShow(theatreName,movieName, date, timeIn, timeBetween));

        // Display information
        String line = "";
        System.out.println("list size: "+showList.size());
        for (int i = 0; i < showList.size(); i++) {
            System.out.println("########2"+ showList.get(i));
            line = line+"\n\n"+showList.get(i);
        }
        if (line == ""){
            showView.setText("No movies available.");
            Toast.makeText(this,"No movies available." , Toast.LENGTH_SHORT).show();

        } else{
            showView.setText(line);
        }

    }
}