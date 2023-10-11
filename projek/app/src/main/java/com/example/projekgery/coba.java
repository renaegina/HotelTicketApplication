package com.example.projekgery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class coba extends AppCompatActivity {

    public CardView single;
    public CardView doubles;
    public CardView family;
    public CardView deluxe;
    public CardView suite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba);

        single = findViewById(R.id.single);
        single.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Masuk = new Intent(coba.this, single.class);
                startActivity(Masuk);
            }
        });

        doubles = findViewById(R.id.doubles);
        doubles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Masuk = new Intent(coba.this, doubles.class);
                startActivity(Masuk);
            }
        });

        family= findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Masuk = new Intent(coba.this, family.class);
                startActivity(Masuk);
            }
        });

        deluxe = findViewById(R.id.deluxe);
        deluxe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Masuk = new Intent(coba.this, deluxe.class);
                startActivity(Masuk);
            }
        });

        suite = findViewById(R.id.suite);
        suite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Masuk = new Intent(coba.this, suite.class);
                startActivity(Masuk);
            }
        });
    }


}