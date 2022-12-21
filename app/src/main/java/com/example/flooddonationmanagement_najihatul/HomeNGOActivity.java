package com.example.flooddonationmanagement_najihatul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeNGOActivity extends AppCompatActivity {
    Button mViewFloodVictimDetailBtn, addDonation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ngoactivity);

        mViewFloodVictimDetailBtn = findViewById(R.id.viewNgoBtn);
        addDonation = findViewById(R.id.addDonationBtn);

        mViewFloodVictimDetailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeNGOActivity.this,ViewFloodVictimNGOActivity.class);
                startActivity(i);
            }
        });

        addDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(HomeNGOActivity.this,AddDonationNGOActivity.class);
                startActivity(i1);
            }
        });
    }
}