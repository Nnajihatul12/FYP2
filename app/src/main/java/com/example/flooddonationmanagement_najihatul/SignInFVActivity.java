package com.example.flooddonationmanagement_najihatul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInFVActivity extends AppCompatActivity {

    TextView emailuser, passworduser, signupuser;
    Button signinuser;

    private String email;
    private String password;
    private CheckBox checkboxEmail, checkboxPassword;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_fvactivity);

        emailuser = findViewById(R.id.emailuser);
        passworduser = findViewById(R.id.passworduser);
        signupuser = findViewById(R.id.signupuser);
        signinuser = findViewById(R.id.signinuser);
        checkboxEmail = findViewById(R.id.checkboxEmail);
        checkboxPassword = findViewById(R.id.checkboxPassword);

        auth = FirebaseAuth.getInstance();

        signupuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickedSignUp();
            }
        });

        signinuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickedSignIn();
            }
        });

        checkboxEmail.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(SignInFVActivity.this);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("pref_email_key", emailuser.getText().toString());
                    editor.commit();
                } else {
                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(SignInFVActivity.this);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("pref_email_key", "");
                    editor.putString("pref_password_key", "");
                    editor.commit();

                }
            }
        });

        checkboxPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(SignInFVActivity.this);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("pref_password_key", passworduser.getText().toString());
                    editor.commit();
                } else {
                    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(SignInFVActivity.this);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("pref_email_key", "");
                    editor.putString("pref_password_key", "");
                    editor.commit();
                }

            }

        });

        initParam();

    }

    public void initParam() {
        checkboxEmail.setOnCheckedChangeListener(null);
        checkboxPassword.setOnCheckedChangeListener(null);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String signInId = pref.getString("pref_email_key", "");
        String password = pref.getString("pref_password_key", "");
        boolean emailcheckbox = pref.getBoolean("pref_email_checkbox_key", false);
        boolean passwordcheckbox = pref.getBoolean("pref_password_checkbox_key", false);
        if (emailcheckbox == true && passwordcheckbox == true) {
            emailuser.setText(signInId);
            passworduser.setText(password);
            checkboxEmail.setChecked(true);
            checkboxPassword.setChecked(true);
        } else {
            checkboxEmail.setChecked(false);
            checkboxPassword.setChecked(false);
        }
    }

    private void onClickedSignUp() {
        Intent intent = new Intent(SignInFVActivity.this, SignUpFVActivity.class);
        startActivity(intent);
    }

    private void onClickedSignIn() {
        email = emailuser.getText().toString();
        password = passworduser.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(SignInFVActivity.this, "Please enter the email", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(SignInFVActivity.this, "Please enter the password", Toast.LENGTH_SHORT).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailuser.setError("Please provide valid email");
            emailuser.requestFocus();
        } else if (password.length() < 6 || password.length() >= 20) {
            Toast.makeText(SignInFVActivity.this, "Password must contain 6 character at least", Toast.LENGTH_SHORT).show();

        } else {
            finish();
            FV(email, password);

        }
    }


    private void FV(String email, String password) {

        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(SignInFVActivity.this);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("pref_email_key", emailuser.getText().toString());
                        editor.putString("pref_password_key", passworduser.getText().toString());
                        editor.putBoolean("pref_email_checkbox_key", checkboxEmail.isChecked());
                        editor.putBoolean("pref_password_checkbox_key", checkboxPassword.isChecked());
                        editor.apply();

                        Toast.makeText(SignInFVActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignInFVActivity.this, ListNGOsActivity.class));
                        finish();
                    }
                })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignInFVActivity.this, "Failed to sign in", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}








