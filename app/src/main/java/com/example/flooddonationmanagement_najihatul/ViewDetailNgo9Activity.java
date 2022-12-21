package com.example.flooddonationmanagement_najihatul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewDetailNgo9Activity extends AppCompatActivity {
    String ngoName;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail_ngo9);

        ngoName = "Yayasan Amal Malaysia";


        btn1 = findViewById(R.id.requestDonationBtn9);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewDetailNgo9Activity.this,UserFormActivity.class);
                i.putExtra("ngoName",ngoName);
                startActivity(i);
            }
        });
    }
}