package com.example.projekgery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    public Button btnbuat;
    private Button btnlogin;
    private FirebaseAuth mAuth;
    private EditText Et_user;
    private EditText Et_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Et_user = findViewById(R.id.inputEmail);
        Et_pass = findViewById(R.id.inputPassword);
        btnlogin =findViewById(R.id.btnlogin);
        mAuth = FirebaseAuth.getInstance();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_email = Et_user.getText().toString().trim();
                String user_password = Et_pass.getText().toString().trim();
                mAuth.signInWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(login.this, "Login Sukses", Toast.LENGTH_LONG).show();
                            finish();
                            startActivity(new Intent(login.this, utama.class));
                        }else{
                            Toast.makeText(login.this, "Login Gagal", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        btnbuat = findViewById(R.id.btnbuat);
        btnbuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Buat = new Intent(login.this, singup.class);
                startActivity(Buat);
            }
        });
    }
}