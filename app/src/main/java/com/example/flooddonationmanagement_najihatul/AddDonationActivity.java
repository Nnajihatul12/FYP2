package com.example.flooddonationmanagement_najihatul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddDonationActivity extends AppCompatActivity {

    Button mbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);

        mbtn = findViewById(R.id.donateBtn);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddDonationActivity.this, "Successfully Donate to your NGO", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}