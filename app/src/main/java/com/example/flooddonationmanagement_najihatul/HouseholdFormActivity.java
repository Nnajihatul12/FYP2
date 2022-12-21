package com.example.flooddonationmanagement_najihatul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HouseholdFormActivity extends AppCompatActivity {

    String mFullNameStr,mPhoneNoStr,mAgeStr,mOccupationStr,mIncomeSalaryStr,mAddress1Str,mAddress2Str,postCode,mGenderStr;
    EditText mNoOfBabyEt,mNoOfChildrenEt,mNoOfTeenagerEt,mNoOfAdultEt,mNoOfElderlyEt,mNoOfDisabledPeopleEt;
    String mNoOfBabyStr,mNoOfChildrenStr,mNoOfTeenagerStr,mNoOfAdultStr,mNoOfElderlyStr,mNoOfDisabledPeopleStr;
    Button nextBtn;
    String ngoName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_household_formactivity);

        //Edittext
        mNoOfBabyEt = findViewById(R.id.noOfBabyEt);
        mNoOfChildrenEt = findViewById(R.id.noOfChildrenEt);
        mNoOfTeenagerEt = findViewById(R.id.noOfTeenagerEt);
        mNoOfAdultEt = findViewById(R.id.noOfAdultEt);
        mNoOfElderlyEt = findViewById(R.id.noOfElderlyEt);
        mNoOfDisabledPeopleEt = findViewById(R.id.noOfElderlyEt);

        //Button
        nextBtn = findViewById(R.id.nextHouseHoldBtn);


        //get data pass From UserForm.
        Intent intent = getIntent();
        mFullNameStr =intent.getStringExtra("fullname");
        mPhoneNoStr  =intent.getStringExtra("phoneNo");
        mGenderStr = intent.getStringExtra("gender");
        mAgeStr =intent.getStringExtra("age");
        mOccupationStr =intent.getStringExtra("occupation");
        mIncomeSalaryStr =intent.getStringExtra("incomeSalary");
        mAddress1Str =intent.getStringExtra("address1");
        mAddress2Str =intent.getStringExtra("address2");
        postCode = intent.getStringExtra("postCode");
        ngoName = intent.getStringExtra("ngo");



        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HouseholdFormActivity.this,RequestDonationFormActivity.class);
                intent.putExtra("ngo",ngoName);
                intent.putExtra("fullname",mFullNameStr);
                intent.putExtra("phoneNo",mPhoneNoStr);
                intent.putExtra("gender",mGenderStr);
                intent.putExtra("age",mAgeStr);
                intent.putExtra("occupation",mOccupationStr);
                intent.putExtra("incomeSalary",mIncomeSalaryStr);
                intent.putExtra("address1",mAddress1Str);
                intent.putExtra("address2",mAddress2Str);
                intent.putExtra("postCode",postCode);
                intent.putExtra("baby",mNoOfBabyEt.getText().toString());
                intent.putExtra("children",mNoOfChildrenEt.getText().toString());
                intent.putExtra("teenager",mNoOfTeenagerEt.getText().toString());
                intent.putExtra("adult",mNoOfAdultEt.getText().toString());
                intent.putExtra("elderly",mNoOfElderlyEt.getText().toString());
                intent.putExtra("disabledPpl",mNoOfDisabledPeopleEt.getText().toString());
                startActivity(intent);
            }
        });



    }


    private boolean checkIfNotFill(){
        if (TextUtils.isEmpty(mNoOfBabyEt.getText())){
            return false;
        } else if (TextUtils.isEmpty(mNoOfChildrenEt.getText())){
            return false;
        } else if (TextUtils.isEmpty(mNoOfTeenagerEt.getText())){
            return false;
        } else if (TextUtils.isEmpty(mNoOfAdultEt.getText())){
            return false;
        } else if (TextUtils.isEmpty(mNoOfElderlyEt.getText())){
            return false;
        } else if (TextUtils.isEmpty(mNoOfDisabledPeopleEt.getText())) {
            return false;
        }else {
            return true;
        }

    }

    private void addToIntent(){

    }

}