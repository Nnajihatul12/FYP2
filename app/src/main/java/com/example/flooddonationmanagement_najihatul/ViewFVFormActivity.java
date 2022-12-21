package com.example.flooddonationmanagement_najihatul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

public class ViewFVFormActivity extends AppCompatActivity {
    TextView fullNameTv,phoneNoTV,genderTv,ageTv,incomeTv,address1tV,address2Tv,postCodeTv,babyQty,childrenQty,teenQty,adultQty,elderlyQty,disabledQty;
    CheckBox hygieneKitChkbx,cashAssistanceChkbx,ambulanServicesChkbx,houseCleaningChkbx,powerBankChkbx,foodAndWaterChkbx,infrastructureMaintenanceChkbx,medicineAndFirstAidKitsChkbx,eletricalApplianceChkbx,clothAndBlanketsChkbx,diaperAndPadsChkbx,candlesMatchesAndTorchlightcheckbx;
    String ngoType,documentId;
    TextView occupationTv;
    Button updateBtn, signOutBtn;
    ImageButton printBtn;
    //ImageButton screenshotBtn;
    String fullName,phoneNo,gender,age,occupation,income,address1,address2,postcode,babyNo,childNo,teenNo,adultNo,elderlyNo,disabledNo,hygieneKits,cashAssistance,ambulanceService,houseCleaning,powerBank,foodAndWater,infrastructureMaintenance,medicine,electrical,clothandBLanket,diaperandpads,candlesMatchesAndTorchlight;

    FirebaseFirestore db;
    CollectionReference cRef;
    DocumentReference docRef;
    DocumentReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fvform);

        fullNameTv = findViewById(R.id.fullNameTv);
        phoneNoTV = findViewById(R.id.phoneNotv);
        genderTv = findViewById(R.id.genderTv);
        ageTv = findViewById(R.id.ageTv);
        occupationTv = findViewById(R.id.occupationTv);
        incomeTv = findViewById(R.id.incomeSalaryTv);
        address1tV= findViewById(R.id.address1LineTv);
        address2Tv = findViewById(R.id.address2LineTv);
        postCodeTv = findViewById(R.id.postCodeTv);
        babyQty = findViewById(R.id.babyQty);
        childrenQty = findViewById(R.id.childrenQty);
        teenQty = findViewById(R.id.teenQty);
        adultQty = findViewById(R.id.adultQty);
        elderlyQty = findViewById(R.id.elerdlyQty);
        disabledQty = findViewById(R.id.qtyDisabled);
        hygieneKitChkbx = findViewById(R.id.hygieneKitsCheckbox);
        cashAssistanceChkbx = findViewById(R.id.cashAssistanceCheckbox);
        ambulanServicesChkbx = findViewById(R.id.ambulanceServicesCheckBox);
        houseCleaningChkbx = findViewById(R.id.houseCleaningCheckBox);
        powerBankChkbx = findViewById(R.id.powerBankCheckBox);
        foodAndWaterChkbx = findViewById(R.id.foodAndWaterCheckBox);
        infrastructureMaintenanceChkbx = findViewById(R.id.infrastructureMaintenanceCheckbx);
        medicineAndFirstAidKitsChkbx = findViewById(R.id.medicineAndFirstAidKitsCheckBox);
        eletricalApplianceChkbx = findViewById(R.id.electricalApplianceCheckbox);
        clothAndBlanketsChkbx = findViewById(R.id.clothesAndBlanketCheckbx);
        diaperAndPadsChkbx = findViewById(R.id.diaperPadsChkbx);
        candlesMatchesAndTorchlightcheckbx = findViewById(R.id.candlesMatchesAndTorchLightCheckbox);
        //screenshotBtn = findViewById(R.id.screenShotbtn);
        printBtn = findViewById(R.id.printBtn);
        signOutBtn = findViewById(R.id.signOutBtn);







        Intent i = getIntent();
        ngoType = i.getStringExtra("ngoType");
        documentId = i.getStringExtra("documentId");

        db = FirebaseFirestore.getInstance();

        ref = db.collection("floodVictim").document(documentId);
//        cRef = db.collection("floodVictim");
//        docRef = cRef.document(ngoType);
//
//        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()){
//                    DocumentSnapshot document = task.getResult();
//
//
//                }
//            }
//        })

//        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
//                    if (document.exists()) {
//                        // Document exists, you can retrieve the data here
//                        Map<String, Object> data = document.getData();
//                        // Do something with the data
//                        fullNameTv.setText(data.get("fullName").toString());
//                    } else {
//                        Toast.makeText(ViewFVFormActivity.this, "data not exist", Toast.LENGTH_SHORT).show();
//                        // Document does not exist
//                    }
//                } else {
//                    // Failed to get the document
//                }
//            }
//        });

//        ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    DocumentSnapshot document = task.getResult();
//                    if (document.exists()) {
//                        // Get the data from the document and set it to the TextView
//                        String name = document.getString("fullName");
//                        fullNameTv = findViewById(R.id.fullNameTv);
//                        fullNameTv.setText(name);
//                    } else {
//                        Toast.makeText(ViewFVFormActivity.this,"Data not Exist",Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//
//                }
//            }
//        });
        CollectionReference collection = db.collection("floodVictim");

        collection.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    QuerySnapshot querySnapshot = task.getResult();
                    List<DocumentSnapshot> documents = querySnapshot.getDocuments();
                    // do something with the documents
                    StringBuilder sb = new StringBuilder();
                    for (DocumentSnapshot document : documents) {
//                        sb.append(document.getString("fullName"));
                      fullName = document.getString("fullName");
                        phoneNo = document.getString("phoneNo");
                        gender = document.getString("gender");
                        age = document.getString("age");
                        occupation = document.getString("occupation");
                        income = document.getString("incomeSalary");
                        address1 = document.getString("address1");
                        address2 = document.getString("address2");
                        postcode = document.getString("postCode");
                        babyNo = document.getString("babyNo");
                        teenNo = document.getString("teenagerNo");
                        adultNo = document.getString("adultNo");
                        elderlyNo = document.getString("elderlyNo");
                        childNo = document.getString("childrenNo");


                        hygieneKits = document.getString("hygieneKits");
                        cashAssistance = document.getString("cashAssitance");
                        ambulanceService = document.getString("ambulanceService");
                        houseCleaning = document.getString("houseCleaning");
                        foodAndWater = document.getString("foodAndWater");
                        infrastructureMaintenance = document.getString("nfrastructureMaintenance");
                        medicine = document.getString("medicineAndFirstAidsKits");
                        electrical = document.getString("electricalapp");
                        clothandBLanket = document.getString("clothsAndBlanket");
                        diaperandpads = document.getString("diapersAndPads");
                        candlesMatchesAndTorchlight = document.getString("candlesMatchAndTorchlight");

                    }
                    fullNameTv.setText(fullName);
                    phoneNoTV.setText(phoneNo);
                    genderTv.setText(gender);
                    ageTv.setText(age);
                    occupationTv.setText(occupation);
                    incomeTv.setText(income);
                    address1tV.setText(address1);
                    address2Tv.setText(address2);
                    postCodeTv.setText(postcode);
                    babyQty.setText(babyNo);
                    childrenQty.setText(childNo);
                    teenQty.setText(teenNo);
                    adultQty.setText(adultNo);
                    elderlyQty.setText(elderlyNo);
                    disabledQty.setText(disabledNo);

                    cashAssistanceChkbx.setClickable(false);
                    ambulanServicesChkbx.setClickable(false);
                    houseCleaningChkbx.setClickable(false);
                    infrastructureMaintenanceChkbx.setClickable(false);
                    medicineAndFirstAidKitsChkbx.setClickable(false);
                    eletricalApplianceChkbx.setClickable(false);
                    clothAndBlanketsChkbx.setClickable(false);
                    diaperAndPadsChkbx.setClickable(false);
                    candlesMatchesAndTorchlightcheckbx.setClickable(false);

                    if (!TextUtils.isEmpty(cashAssistance)){
                        cashAssistanceChkbx.setChecked(true);
                        cashAssistanceChkbx.setClickable(false);
                    }

                    if (!TextUtils.isEmpty(ambulanceService)){
                        ambulanServicesChkbx.setChecked(true);
                        ambulanServicesChkbx.setClickable(false);
                    }


                    if (!TextUtils.isEmpty(houseCleaning) || houseCleaning != null){
                        houseCleaningChkbx.setChecked(true);
                        houseCleaningChkbx.setClickable(false);
                    }



                    if (!TextUtils.isEmpty(infrastructureMaintenance)){
                        infrastructureMaintenanceChkbx.setChecked(true);
                        infrastructureMaintenanceChkbx.setClickable(false);
                    }

                    if (!TextUtils.isEmpty(medicine)){
                        medicineAndFirstAidKitsChkbx.setChecked(true);
                        medicineAndFirstAidKitsChkbx.setClickable(false);
                    }

                    if (!TextUtils.isEmpty(electrical)){
                        eletricalApplianceChkbx.setChecked(true);
                        eletricalApplianceChkbx.setClickable(false);
                    }


                    if (!TextUtils.isEmpty(clothandBLanket)){
                        clothAndBlanketsChkbx.setChecked(true);
                        clothAndBlanketsChkbx.setClickable(false);
                    }

                    if (!TextUtils.isEmpty(clothandBLanket)){
                        clothAndBlanketsChkbx.setChecked(true);
                        clothAndBlanketsChkbx.setClickable(false);
                    }

                    if (!TextUtils.isEmpty(diaperandpads)){
                        diaperAndPadsChkbx.setChecked(true);
                        diaperAndPadsChkbx.setClickable(false);
                    }

                    if (!TextUtils.isEmpty(candlesMatchesAndTorchlight)){
                        candlesMatchesAndTorchlightcheckbx.setChecked(true);
                        candlesMatchesAndTorchlightcheckbx.setClickable(false);
                    }


                } else {
                    // handle error
                }
            }
        });


//       screenshotBtn.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               Toast.makeText(ViewFVFormActivity.this, "Unable to ScreenShot", Toast.LENGTH_SHORT).show();
//
//           }
//       });

       printBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(ViewFVFormActivity.this,"Connect to Printer",Toast.LENGTH_SHORT).show();
           }
       });

       signOutBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FirebaseAuth.getInstance().signOut();
               Intent i = new Intent(ViewFVFormActivity.this,SplashScreen.class);
               Toast.makeText(ViewFVFormActivity.this, "Successfully Sign Out", Toast.LENGTH_SHORT).show();
           }
       });

    }

//   public void fetchData(){
//        DocumentReference
//   }
}