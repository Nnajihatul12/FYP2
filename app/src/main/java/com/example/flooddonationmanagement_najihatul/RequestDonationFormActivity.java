package com.example.flooddonationmanagement_najihatul;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class RequestDonationFormActivity extends AppCompatActivity {
    CheckBox hygieneKitChkBx,cashAssistanceChkbox,ambulanceServicesChkBx,houseCleaningChkBx,powerBankChkBox,foodAndWaterChkBx,infrastructureMaintenanceChkbx,medicineAndFirstAidKitsChkBox,eletricalApplianceChkbx,clothesAndBlanketChkbx,diaperAndPadsChkbx,candlesMatchesAndTorchLightChkbx;
    Button submitBtn;
    String hygienceKit,cashAssistance,ambulanceService,houseCleanService,powerBankService,foodAndWaterService,infrastructureMaintenanceService,medicineAndFirstAidKits,electricAppliance,clothAndBlankets,diaperAndPads,candlesMatchesAndTorchLights;
    String ngoType;
    private String mFullName,mPhoneNoStr,mAgeStr,mOccupationStr,mIncomeSalaryStr,mAddress1Str,mAddress2Str,postCode,mGenderStr;
    private String mNoOfBaby,mNofChildren,mNoTeenager,mNoAdult,mNoElderly,mDisabledPeople;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_donation_formactivity);


        hygieneKitChkBx = findViewById(R.id.hygieneKitsCheckBx);
        cashAssistanceChkbox = findViewById(R.id.cashAssistanceCheckbox);
        ambulanceServicesChkBx = findViewById(R.id.ambulanceServicesCheckBox);
        houseCleaningChkBx = findViewById(R.id.houseCleaningCheckBox);
        powerBankChkBox = findViewById(R.id.powerBankCheckBox);
        foodAndWaterChkBx = findViewById(R.id.foodAndWaterCheckBox);
        infrastructureMaintenanceChkbx = findViewById(R.id.infrastructureMaintenanceCheckbox);
        medicineAndFirstAidKitsChkBox = findViewById(R.id.MedicineAndFirstAidKitsCheckBox);
        eletricalApplianceChkbx = findViewById(R.id.eletricalApplianceCheckbox);
        clothesAndBlanketChkbx = findViewById(R.id.clothesAndBlanketCheckbox);
        diaperAndPadsChkbx = findViewById(R.id.diaperAndPadsCheckbox);
        candlesMatchesAndTorchLightChkbx = findViewById(R.id.candlesMatchesAndTorchLightCheckbox);

        submitBtn = findViewById(R.id.submitBtn);

        db = FirebaseFirestore.getInstance();

        Intent i = getIntent();
        ngoType = i.getStringExtra("ngo");
        mFullName = i.getStringExtra("fullname");
        mPhoneNoStr = i.getStringExtra("phoneNo");
        mGenderStr = i.getStringExtra("gender");
        mAgeStr = i.getStringExtra("age");
        mOccupationStr = i.getStringExtra("occupation");
        mIncomeSalaryStr = i.getStringExtra("incomeSalary");
        mAddress1Str = i.getStringExtra("address1");
        mAddress2Str = i.getStringExtra("address2");
        postCode = i.getStringExtra("postCode");
        mNoOfBaby = i.getStringExtra("baby");
        mNofChildren = i.getStringExtra("children");
        mNoTeenager = i.getStringExtra("teenager");
        mNoAdult = i.getStringExtra("adult");
        mNoElderly = i.getStringExtra("elderly");
        mDisabledPeople = i.getStringExtra("disabledPpl");









        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            addDataToFirestore();


            }
        });

    }

    private void addDataToFirestore() {

        if (hygieneKitChkBx.isChecked()){
            hygienceKit = "Hygience Kits";
        } else {
            hygienceKit = " ";
        }

        if (cashAssistanceChkbox.isChecked()){
            cashAssistance = "Cash Assistance";
        } else {
            cashAssistance = " ";
        }

        if (ambulanceServicesChkBx.isChecked()){
            ambulanceService = "Ambulance Services";
        } else {
            ambulanceService = " ";
        }


        if (houseCleaningChkBx.isChecked()){
            houseCleanService = "House Cleaning";
        } else {
            houseCleanService = " ";
        }


        if (powerBankChkBox.isChecked()){
            powerBankService = "Power Bank";
        } else {
            powerBankService = " ";
        }



        if (foodAndWaterChkBx.isChecked()){
            foodAndWaterService = "Food And Water";
        } else {
            foodAndWaterService = " ";
        }


        if (infrastructureMaintenanceChkbx.isChecked()){
            infrastructureMaintenanceService = "Infrastructure Maintenance";
        } else {
            infrastructureMaintenanceService = " ";
        }


        if (medicineAndFirstAidKitsChkBox.isChecked()){
            medicineAndFirstAidKits = "Medicines and First Aid Kits";
        } else {
            medicineAndFirstAidKits = " ";
        }



        if (diaperAndPadsChkbx.isChecked()){
            diaperAndPads = "Diaper and Pads";
        } else {
            diaperAndPads = " ";
        }

        if (eletricalApplianceChkbx.isChecked()){
            electricAppliance = "Electrical Appliances";
        } else {
            electricAppliance = " ";
        }

        if (clothesAndBlanketChkbx.isChecked()){
            clothAndBlankets = "Clothes and Blankets";
        } else {
            clothAndBlankets = " ";
        }

        if (candlesMatchesAndTorchLightChkbx.isChecked()){
            candlesMatchesAndTorchLights = "Candles, Matches and Torchlight";
        } else {
            candlesMatchesAndTorchLights = " ";
        }

        Intent i = getIntent();
        ngoType = i.getStringExtra("ngo");
        mFullName = i.getStringExtra("fullname");
        mPhoneNoStr = i.getStringExtra("phoneNo");
        mGenderStr = i.getStringExtra("gender");
        mAgeStr = i.getStringExtra("age");
        mOccupationStr = i.getStringExtra("occupation");
        mIncomeSalaryStr = i.getStringExtra("incomeSalary");
        mAddress1Str = i.getStringExtra("address1");
        mAddress2Str = i.getStringExtra("address2");
        postCode = i.getStringExtra("postCode");
        mNoOfBaby = i.getStringExtra("baby");
        mNofChildren = i.getStringExtra("children");
        mNoTeenager = i.getStringExtra("teenager");
        mNoAdult = i.getStringExtra("adult");
        mNoElderly = i.getStringExtra("elderly");
        mDisabledPeople = i.getStringExtra("disabledPpl");

        CollectionReference floodVictimDb = db.collection("floodVictim");

        DocumentReference floodVictimRef = floodVictimDb.document(ngoType);

        FloodVictimModel fvModel = new FloodVictimModel(ngoType,mFullName,mPhoneNoStr,mGenderStr,mAgeStr,mOccupationStr,mIncomeSalaryStr,mAddress1Str,mAddress2Str,postCode,mNoOfBaby, mNofChildren,mNoTeenager,mNoAdult,mNoElderly,mDisabledPeople,cashAssistance,ambulanceService,houseCleanService,powerBankService,foodAndWaterService,infrastructureMaintenanceService,medicineAndFirstAidKits,electricAppliance,clothAndBlankets,diaperAndPads,candlesMatchesAndTorchLights);

        // below method is use to add data to Firebase Firestore.
        floodVictimDb.add(fvModel).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                String documentId = documentReference.getId();
                // after the data addition is successful
                // we are displaying a success toast message.
                documentReference.set(fvModel);
                Toast.makeText(RequestDonationFormActivity.this, "Donation Request Added", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(RequestDonationFormActivity.this,ViewFVFormActivity.class);
                i.putExtra("documentId",documentId);
                i.putExtra("ngoType",ngoType);
                startActivity(i);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // this method is called when the data addition process is failed.
                // displaying a toast message when data addition is failed.
                Toast.makeText(RequestDonationFormActivity.this, "Fail to add \n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void checkIfCheckBoxTicked(){
        if (hygieneKitChkBx.isChecked()){
            hygienceKit = "Hygience Kits";
        } else {
            hygienceKit = " ";
        }

        if (cashAssistanceChkbox.isChecked()){
            cashAssistance = "Cash Assistance";
        } else {
            cashAssistance = " ";
        }

        if (ambulanceServicesChkBx.isChecked()){
            ambulanceService = "Ambulance Services";
        } else {
            ambulanceService = " ";
        }


        if (houseCleaningChkBx.isChecked()){
            houseCleanService = "House Cleaning";
        } else {
            houseCleanService = " ";
        }


        if (powerBankChkBox.isChecked()){
            powerBankService = "Power Bank";
        } else {
            powerBankService = " ";
        }



        if (foodAndWaterChkBx.isChecked()){
            foodAndWaterService = "Food And Water";
        } else {
            foodAndWaterService = " ";
        }


        if (infrastructureMaintenanceChkbx.isChecked()){
            infrastructureMaintenanceService = "Infrastructure Maintenance";
        } else {
            infrastructureMaintenanceService = " ";
        }


        if (medicineAndFirstAidKitsChkBox.isChecked()){
            medicineAndFirstAidKits = "Medicines and First Aid Kits";
        } else {
            medicineAndFirstAidKits = " ";
        }



        if (diaperAndPadsChkbx.isChecked()){
            diaperAndPads = "Diaper and Pads";
        } else {
            diaperAndPads = " ";
        }

        if (eletricalApplianceChkbx.isChecked()){
            electricAppliance = "Electrical Appliances";
        } else {
            electricAppliance = " ";
        }

        if (clothesAndBlanketChkbx.isChecked()){
            clothAndBlankets = "Clothes and Blankets";
        } else {
            clothAndBlankets = " ";
        }

        if (candlesMatchesAndTorchLightChkbx.isChecked()){
            candlesMatchesAndTorchLights = "Candles, Matches and Torchlight";
        } else {
            candlesMatchesAndTorchLights = " ";
        }

    }

}