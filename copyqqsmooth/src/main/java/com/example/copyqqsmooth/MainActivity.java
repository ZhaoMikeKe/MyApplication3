package com.example.copyqqsmooth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i + "");

        }
        SlideAdapter slideAdapter = new SlideAdapter(this, list);
        SlideListView slideListView = findViewById(R.id.slidelistview);
        slideListView.setAdapter(slideAdapter);
    }
}
