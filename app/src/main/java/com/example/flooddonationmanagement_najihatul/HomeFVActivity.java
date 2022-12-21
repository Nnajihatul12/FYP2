package com.example.flooddonationmanagement_najihatul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeFVActivity extends AppCompatActivity {
    Button userBtn,ngoBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_fvactivity);

        userBtn = findViewById(R.id.userBtn);
        ngoBtn = findViewById(R.id.ngoBtn);

        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeFVActivity.this,SignInFVActivity.class);
                startActivity(i);

            }
        });

        ngoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeFVActivity.this,SignInNGOActivity.class);
                startActivity(i);
            }
        });




    }
}