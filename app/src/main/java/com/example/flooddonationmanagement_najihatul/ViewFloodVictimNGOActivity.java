package com.example.flooddonationmanagement_najihatul;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class ViewFloodVictimNGOActivity extends AppCompatActivity {
    FirebaseFirestore db;
    CollectionReference collectionRef;

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flood_victim_ngoactivity);

        db = FirebaseFirestore.getInstance();
        collectionRef = db.collection("floodVictim");

        recyclerView =findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);

        collectionRef.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        // Get the data from the query and pass it to the adapter
                        List<FloodVictimModel> data = queryDocumentSnapshots.toObjects(FloodVictimModel.class);
                        adapter.setData(data);
                    }
                });

    }
}