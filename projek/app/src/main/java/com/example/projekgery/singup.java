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
import com.google.firebase.auth.FirebaseUser;

public class singup extends AppCompatActivity {

    public Button btnback;
    private FirebaseAuth mAuth;
    private EditText etUsername;
    private EditText etPass;
    private Button btnRgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        etUsername = findViewById(R.id.inputEmail);
        etPass = findViewById(R.id.inputPassword);
        btnRgs = findViewById(R.id.btnRgs);

        mAuth = FirebaseAuth.getInstance();

        btnRgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etUsername.getText().toString().trim();
                String pass = etPass.getText().toString().trim();
                mAuth.createUserWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(singup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(singup.this, "Registrasi Sukses", Toast.LENGTH_LONG).show();
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    startActivity(new Intent(singup.this, login.class));
                                }else{
                                    Toast.makeText(singup.this, "Registrasi Gagal", Toast.LENGTH_LONG).show();
                                    FirebaseUser user = mAuth.getCurrentUser();
                                }
                            }
                        });
            }
        });

        btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Back = new Intent(singup.this, login.class);
                startActivity(Back);
            }
        });
    }
}