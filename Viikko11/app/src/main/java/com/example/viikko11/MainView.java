package com.example.viikko11;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.viikko11.R;

import java.util.Objects;

public class MainView extends Fragment {
    private TextView text;
    private String font_color = "#FFFFFF";
    private Integer font_size = 12;
    private String text_value = "This is basic text for the txt box and it is used to demo this!";
    private boolean all_caps = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_view_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        text = getView().findViewById(R.id.textView2);
        text.setText(text_value);
        text.setTextColor(Color.parseColor(font_color));
        text.setAllCaps(all_caps);
        text.setTextSize(TypedValue.COMPLEX_UNIT_DIP,font_size);

    }
    public MainView(){}

}

