package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {

    EditText edttaikhoan, edtmatkhau;
    Button btndangnhap, btndangky1;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        setStatusbarColor();
        firebaseAuth = FirebaseAuth.getInstance();

        edttaikhoan = findViewById(R.id.edttaikhoan);
        edtmatkhau = findViewById(R.id.edtmatkhau);
        btndangnhap = findViewById(R.id.btndangnhap);
        btndangky1 = findViewById(R.id.btndangky1);

        btndangky1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, singin.class);
                startActivity(intent);
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getEmail = edttaikhoan.getText().toString();
                String getPassword = edtmatkhau.getText().toString();
                firebaseAuth.signInWithEmailAndPassword(getEmail,getPassword)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(login.this, "Chuc mung, chay duoc roi", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(login.this, ""+e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    private void setStatusbarColor() {
    }
}