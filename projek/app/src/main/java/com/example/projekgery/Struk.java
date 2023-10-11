package com.example.projekgery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Struk extends AppCompatActivity {

    TextView nama_penyewa, jenis_kamar,lama_sewa,total,uang_bayar,uang_kembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_struk);
        nama_penyewa = findViewById(R.id.nama_penyewa);
        jenis_kamar = findViewById(R.id.jenis_mobil);
        lama_sewa = findViewById(R.id.lama_sewa);
        total = findViewById(R.id.total);
        uang_bayar = findViewById(R.id.uang_bayar);
        uang_kembali = findViewById(R.id.uang_kembali);

        nama_penyewa.setText(getIntent().getStringExtra("Nama"));
        jenis_kamar.setText(getIntent().getStringExtra("Kamar"));
        lama_sewa.setText(String.valueOf(getIntent().getIntExtra("Lama",0)));
        total.setText(String.valueOf(getIntent().getIntExtra("Total",0)));
        uang_bayar.setText(String.valueOf(getIntent().getIntExtra("Uang",0)));
        uang_kembali.setText(String.valueOf(getIntent().getIntExtra("Kembalian",0)));
    }

    public void hal_utama(View view) {
        Intent intent =new Intent(Struk.this, MainActivity.class);
        startActivity(intent);
    }
}