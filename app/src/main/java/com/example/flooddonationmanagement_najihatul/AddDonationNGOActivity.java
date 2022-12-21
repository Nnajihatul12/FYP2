package com.example.flooddonationmanagement_najihatul;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddDonationNGOActivity extends AppCompatActivity {

    Button add;
    String ngoID;
    FirebaseFirestore fstore;

    private EditText ngoname;
    private EditText ngoemail;
    private EditText ngophone;
    private EditText ngoaddress;
    private EditText ngodonate;

    private FirebaseAuth auth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation_ngoactivity);

        ngoname = findViewById(R.id.ngoname);
        ngoemail = findViewById(R.id.ngoemail);
        ngophone = findViewById(R.id.ngophone);
        ngoaddress = findViewById(R.id.ngoaddress);
        ngodonate = findViewById(R.id.ngodonate);
        add = findViewById(R.id.buttonadd);


        auth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickedAdd();
            }
        });

    }

    private void onClickedAdd() {
        String mNGONameString = ngoname.getText().toString();
        String mNGOEmailString = ngoemail.getText().toString();
        String mNGOPhoneString = ngophone.getText().toString();
        String mNGOAddressString = ngoaddress.getText().toString();
        String mNGOListString = ngodonate.getText().toString();

        if (TextUtils.isEmpty(mNGONameString)) {
            Toast.makeText(AddDonationNGOActivity.this, "Enter the organisation name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mNGOEmailString)) {
            Toast.makeText(AddDonationNGOActivity.this, "Enter the organisation email", Toast.LENGTH_SHORT).show();
        }else if (!Patterns.EMAIL_ADDRESS.matcher(mNGOEmailString).matches()) {
            ngoemail.setError("Please provide valid email!");
            ngoemail.requestFocus();
        } else if (TextUtils.isEmpty(mNGOPhoneString)) {
            Toast.makeText(AddDonationNGOActivity.this, "Enter the organisation phone number", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mNGOAddressString)) {
            Toast.makeText(AddDonationNGOActivity.this, "Enter the organisation address", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(mNGOListString)) {
            Toast.makeText(AddDonationNGOActivity.this, "Enter list donations provided by your organisations", Toast.LENGTH_SHORT).show();
        } else {
            addDataToFirestore();
            Toast.makeText(AddDonationNGOActivity.this, "Successfully added!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(AddDonationNGOActivity.this, HomeNGOActivity.class);
            startActivity(i);
        }
    }

    private void addDataToFirestore() {

        Map<String, String> NGODetail1 = new HashMap<>();

        String mNGONameString = ngoname.getText().toString();
        String mNGOEmailString = ngoemail.getText().toString();
        String mNGOPhoneString = ngophone.getText().toString();
        String mNGOAddressString = ngoaddress.getText().toString();
        String mNGOListString = ngodonate.getText().toString();

        NGODetail1.put("Name", mNGONameString);
        NGODetail1.put("Email", mNGOEmailString);
        NGODetail1.put("Phone", mNGOPhoneString);
        NGODetail1.put("Address", mNGOAddressString);
        NGODetail1.put("DonationType", mNGOListString);


        fstore.collection("AddDonationbyNGO").add(NGODetail1).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
            @Override
            public void onComplete(@NonNull Task<DocumentReference> task) {

            }
        });

    }
}