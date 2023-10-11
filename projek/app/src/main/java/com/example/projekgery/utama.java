package com.example.projekgery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class utama extends AppCompatActivity {

    public CardView btnlist;
    public CardView btnsewa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);


        btnlist = findViewById(R.id.btnlist);
        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent List = new Intent(utama.this, coba.class);
                startActivity(List);
            }
        });

        btnsewa = findViewById(R.id.btnsewa);
        btnsewa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Sewa = new Intent(utama.this, Bayar.class);
                startActivity(Sewa);
            }
        });
    }
}