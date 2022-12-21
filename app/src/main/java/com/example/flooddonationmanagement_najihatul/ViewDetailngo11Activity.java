package com.example.flooddonationmanagement_najihatul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ViewDetailngo11Activity extends AppCompatActivity {
    String ngoName;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detailngo11);

        ngoName = "myCARE";


        btn1 = findViewById(R.id.requestDonationBtn11);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewDetailngo11Activity.this,UserFormActivity.class);
                i.putExtra("ngoName",ngoName);
                startActivity(i);
            }
        });
    }
}