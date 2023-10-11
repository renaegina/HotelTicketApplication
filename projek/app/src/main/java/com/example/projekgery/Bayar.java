package com.example.projekgery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Bayar extends AppCompatActivity {
    int harga_sewa_hotel,jml_lmsw,ttl_hargasewa,jml_uang;
    String s_nama;

    Spinner ad_listkamar;
    TextView harga_kamar;
    EditText lama_sewa,uangbayar,nama_penyewa;

    String list_mobil[] = {"Single Room","Double Room","Family Room","Deluxe Room","Suite Room"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar);

        nama_penyewa = findViewById(R.id.nama_penyewa);
        ad_listkamar = findViewById(R.id.ad_listkamar);
        harga_kamar = findViewById(R.id.harga_mobil);
        lama_sewa = findViewById(R.id.lama_sewa);
        uangbayar = findViewById(R.id.uangbayar);

        ArrayAdapter ad_mbl = new ArrayAdapter(Bayar.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list_mobil);
        ad_listkamar.setAdapter(ad_mbl);
    }
    public void tmbl_OK (View view) {
        jml_lmsw= Integer.parseInt(lama_sewa.getText().toString());
        s_nama = nama_penyewa.getText().toString();


        if(ad_listkamar.getSelectedItem().toString()=="Single Room"){
            harga_sewa_hotel = 800000;
            ttl_hargasewa = jml_lmsw * harga_sewa_hotel;
            harga_kamar.setText(Integer.toString(ttl_hargasewa));
        } else if (ad_listkamar.getSelectedItem().toString() == "Double Room"){
            harga_sewa_hotel = 1000000;
            ttl_hargasewa = jml_lmsw * harga_sewa_hotel;
            harga_kamar.setText(Integer.toString(ttl_hargasewa));
        } else if (ad_listkamar.getSelectedItem().toString() == "Family Room"){
            harga_sewa_hotel = 1500000;
            ttl_hargasewa = jml_lmsw * harga_sewa_hotel;
            harga_kamar.setText(Integer.toString(ttl_hargasewa));
        } else if (ad_listkamar.getSelectedItem().toString() == "Deluxe Room"){
            harga_sewa_hotel = 1800000;
            ttl_hargasewa = jml_lmsw * harga_sewa_hotel;
            harga_kamar.setText(Integer.toString(ttl_hargasewa));
        } else if (ad_listkamar.getSelectedItem().toString() == "Suite Room"){
            harga_sewa_hotel = 2000000;
            ttl_hargasewa = jml_lmsw * harga_sewa_hotel;
            harga_kamar.setText(Integer.toString(ttl_hargasewa));
        }

    }

    public void tombol_sewa2(View view) {
        jml_uang = Integer.parseInt(uangbayar.getText().toString());
        if (jml_uang < ttl_hargasewa) {
            Toast.makeText(this, "Uang Kurang", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(Bayar.this, Struk.class);

            intent.putExtra("Nama",s_nama);
            intent.putExtra("Kamar", ad_listkamar.getSelectedItem().toString());
            intent.putExtra("Lama",jml_lmsw);
            intent.putExtra("Total",ttl_hargasewa);
            intent.putExtra("Uang",jml_uang);
            intent.putExtra("Kembalian",jml_uang-ttl_hargasewa);

            startActivity(intent);
        }
    }

}