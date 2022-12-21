package com.example.flooddonationmanagement_najihatul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInNGOActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText mEmailEt,mPasswordEt;
    Button mBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_ngoactivity);
        auth = FirebaseAuth.getInstance();

        mBtn = findViewById(R.id.button4);
        mEmailEt = findViewById(R.id.ngoEmail);
        mPasswordEt = findViewById(R.id.ngoPassword);



        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ngo(mEmailEt.getText().toString(),mPasswordEt.getText().toString());
            }
        });


    }


    private void ngo(String email, String password) {

        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        Toast.makeText(SignInNGOActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignInNGOActivity.this, HomeNGOActivity.class));
                        finish();
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignInNGOActivity.this, "Failed to sign in", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}