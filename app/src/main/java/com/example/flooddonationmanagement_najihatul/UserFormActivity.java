package com.example.flooddonationmanagement_najihatul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class UserFormActivity extends AppCompatActivity {

    EditText mFullNameEt,mPhoneNoEt,mAgeEt,mOccupationEt,mIncomeSalaryEt,mAddress1Et,mAddress2Et;
    RadioButton mRadioBtnMale,mRadioBtnFemale;
    Button mNextBtn;
    String ngoName;
    TextView displayNgoNameTv;
    Spinner postCodeSpinner;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_formactivity);

        //EditText
        mFullNameEt = findViewById(R.id.fullNameEt);
        mPhoneNoEt = findViewById(R.id.phoneNoEt);
        mAgeEt = findViewById(R.id.ageEt);
        mOccupationEt = findViewById(R.id.occupationEt);
        mIncomeSalaryEt = findViewById(R.id.incomeSalaryEt);
        mAddress1Et = findViewById(R.id.addressEt);
        mAddress2Et = findViewById(R.id.addressEt2);
        displayNgoNameTv = findViewById(R.id.ngoName);
        postCodeSpinner = findViewById(R.id.postCodeSpinner);
        mRadioBtnMale = findViewById(R.id.male);
        mRadioBtnFemale = findViewById(R.id.female);
        //Get Ngo Name base on Intent from list.
        Intent intent = getIntent();
        ngoName =intent.getStringExtra("ngoName");

        displayNgoNameTv.setText(ngoName);

        if (mRadioBtnMale.isChecked()){
            gender = mRadioBtnMale.getText().toString();
        } else {
            gender = mRadioBtnFemale.getText().toString();
        }



        //Button
        mNextBtn = findViewById(R.id.nextBtn);

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkIfNotFill();
                Intent intent = new Intent(UserFormActivity.this,HouseholdFormActivity.class);
                intent.putExtra("fullname",mFullNameEt.getText().toString());
                intent.putExtra("phoneNo",mPhoneNoEt.getText().toString());
                intent.putExtra("gender",gender);
                intent.putExtra("age",mAgeEt.getText().toString());
                intent.putExtra("occupation",mOccupationEt.getText().toString());
                intent.putExtra("incomeSalary",mIncomeSalaryEt.getText().toString());
                intent.putExtra("address1",mAddress1Et.getText().toString());
                intent.putExtra("address2",mAddress2Et.getText().toString());
                intent.putExtra("postCode",postCodeSpinner.getSelectedItem().toString());
                intent.putExtra("ngo",ngoName);
                startActivity(intent);
            }
        });

    }

    private boolean checkIfNotFill(){
        if (TextUtils.isEmpty(mFullNameEt.getText())){
            return false;
        } else if (TextUtils.isEmpty(mPhoneNoEt.getText())){
            return false;
        } else if (TextUtils.isEmpty(mAgeEt.getText())){
            return false;
        } else if (TextUtils.isEmpty(mOccupationEt.getText())){
            return false;
        } else if (TextUtils.isEmpty(mIncomeSalaryEt.getText())){
            return false;
        } else if (TextUtils.isEmpty(mAddress1Et.getText())){
            return false;
        } else if (TextUtils.isEmpty(mAddress2Et.getText())){
            return false;
        } else {
            return true;
        }

    }
}