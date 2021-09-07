package com.example.android.musicstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView italy = (TextView) findViewById(R.id.italian_text_view);
        italy.setOnClickListener(view -> {

            Intent italyIntent = new Intent(MainActivity.this, ItalyActivity.class);
            startActivity(italyIntent);
        });


        TextView sardinia = (TextView) findViewById(R.id.sardinia_text_view);
        sardinia.setOnClickListener(view -> {

            Intent sardiniaIntent = new Intent(MainActivity.this, SardiniaActivity.class);
            startActivity(sardiniaIntent);
        });


        TextView austria = (TextView) findViewById(R.id.austria_text_view);
        austria.setOnClickListener(view -> {

            Intent austriaIntent = new Intent(MainActivity.this, AustriaActivity.class);
            startActivity(austriaIntent);
        });


    }
}