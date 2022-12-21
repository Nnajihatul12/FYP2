package com.example.flooddonationmanagement_najihatul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUpFVActivity extends AppCompatActivity {

    EditText fullnameuser, emailuser, passworduser;
    Button signupuser;

    FirebaseFirestore fstore;
    String userID;

    private String fullname;
    private String email;
    private String password;

    private FirebaseAuth auth;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_fvactivity);

        fullnameuser = findViewById(R.id.fullnameuser);
        emailuser = findViewById(R.id.emailuser);
        passworduser = findViewById(R.id.passworduser);
        signupuser = findViewById(R.id.signupuser);

        auth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        ref = db.collection("client").document();

        signupuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickedSignUp();
            }
        });
    }

    private void onClickedSignUp(){
        fullname = fullnameuser.getText().toString().trim();
        email = emailuser.getText().toString().trim();
        password = passworduser.getText().toString().trim();

        if(TextUtils.isEmpty(fullname)){
            Toast.makeText(SignUpFVActivity.this,"Please enter the fullname", Toast.LENGTH_SHORT).show();
        }

        else if (TextUtils.isEmpty(email)){
            Toast.makeText(SignUpFVActivity.this, "Please enter the email", Toast.LENGTH_SHORT).show();
        }

        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailuser.setError("Please provide valid email!");
            emailuser.requestFocus();
        }

        else if (TextUtils.isEmpty(password)){
            Toast.makeText(SignUpFVActivity.this,"Please enter the password", Toast.LENGTH_SHORT).show();
        }

        else if (password.length() < 6 || password.length() >=20) {
            Toast.makeText(SignUpFVActivity.this, "Password must contain 6 character at least", Toast.LENGTH_SHORT).show();
        }

        else {
            FV(email, password);
        }
    }

    private void FV(String email, String password){

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()){
                User user = new User(fullname);

                userID = auth.getCurrentUser().getUid();

            }

            }
        });

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpFVActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    userID = auth.getCurrentUser().getUid();
                    DocumentReference documentReference = fstore.collection("User").document(userID);
                    Map<String,Object> FV = new HashMap<>();
                    FV.put("Fullname", fullname);
                    FV.put("Email", email);
                    FV.put("Password", password);

                    documentReference.set(FV).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(SignUpFVActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();

                        }
                    })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(SignUpFVActivity.this, "Registering user failed", Toast.LENGTH_SHORT).show();
                                }
                            });
                    startActivity(new Intent(SignUpFVActivity.this, ListNGOsActivity.class));
                    finish();
                }
                //else{
                   // Toast.makeText(SignUpFVActivity.this,"Registration failed", Toast.LENGTH_SHORT).show();
                //}
            }
        });
    }
}