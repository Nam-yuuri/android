package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class singin extends AppCompatActivity {

    Button btndangky,btndangnhap;
    TextView edttaikhoan, edtmatkhau;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);

        firebaseAuth = FirebaseAuth.getInstance();

        edttaikhoan = findViewById(R.id.edttaikhoan);
        edtmatkhau = findViewById(R.id.edtmatkhau);
        btndangky = findViewById(R.id.btndangky);
        btndangnhap = findViewById(R.id.btndangnhap);

        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getEmail = edttaikhoan.getText().toString();
                String getPassword = edtmatkhau.getText().toString();
                firebaseAuth.createUserWithEmailAndPassword(getEmail,getPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(singin.this,"Tao tai khoan thanh cong",Toast.LENGTH_SHORT).show();
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(singin.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(singin.this, login.class);
                startActivity(intent);
            }
        });
    }
}