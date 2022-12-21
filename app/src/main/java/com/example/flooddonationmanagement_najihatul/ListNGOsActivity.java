package com.example.flooddonationmanagement_najihatul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class ListNGOsActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout malaysiaRedCrescentLl,mahasiswaKeadilanMalaysiaLl,malaysiaReliefAgencyLl,theHopeBranchLl,ABIMll,SMSALl,HASLl,IMLl,YAMLl,IMARETSLl,myCareLl,GlobalPeaceLl,MercyMalaysiaLl,SikhInsideLl,kembaraKitchenLl,womenGirlsLl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ngos);

        malaysiaRedCrescentLl = findViewById(R.id.MalaysiaRedCrescentLl);
        mahasiswaKeadilanMalaysiaLl = findViewById(R.id.MahasiswaKeadilanMalaysiaLl);
        malaysiaReliefAgencyLl = findViewById(R.id.MalaysiaReliefAgencyLl);
        theHopeBranchLl = findViewById(R.id.theHopeBranchLl);
        ABIMll = findViewById(R.id.ABIMll);
        SMSALl = findViewById(R.id.SMSALl);
        HASLl = findViewById(R.id.HASLl);
        YAMLl = findViewById(R.id.YAMLl);
        IMLl = findViewById(R.id.IMLl);
        IMARETSLl = findViewById(R.id.IMARETSLl);
        myCareLl = findViewById(R.id.myCareLl);
        GlobalPeaceLl = findViewById(R.id.GlobalPeaceLl);
        MercyMalaysiaLl = findViewById(R.id.MercyMalaysiaLl);
        SikhInsideLl = findViewById(R.id.SikhInsideLl);
        kembaraKitchenLl = findViewById(R.id.kembaraKitchenLl);
        womenGirlsLl = findViewById(R.id.womenGirlsLl);

        malaysiaRedCrescentLl.setOnClickListener(this);
        mahasiswaKeadilanMalaysiaLl.setOnClickListener(this);
        malaysiaReliefAgencyLl.setOnClickListener(this);
        theHopeBranchLl.setOnClickListener(this);
        ABIMll.setOnClickListener(this);
        SMSALl.setOnClickListener(this);
        HASLl.setOnClickListener(this);
        YAMLl.setOnClickListener(this);
        IMLl.setOnClickListener(this);
        IMARETSLl.setOnClickListener(this);
        myCareLl.setOnClickListener(this);
        GlobalPeaceLl.setOnClickListener(this);
        MercyMalaysiaLl.setOnClickListener(this);
        SikhInsideLl.setOnClickListener(this);
        kembaraKitchenLl.setOnClickListener(this);
        womenGirlsLl.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.MalaysiaRedCrescentLl:
                Intent i = new Intent(ListNGOsActivity.this,ViewDetailNgo1Activity.class);
                i.putExtra("ngoName","Malaysia Red Crescent Society");
                startActivity(i);
                break;
            case R.id.MahasiswaKeadilanMalaysiaLl:
                Intent ii = new Intent(ListNGOsActivity.this,ViewDetailNgo2Activity.class);
                ii.putExtra("ngoName","Mahasiswa Keadilan Malaysia");
                startActivity(ii);
                break;
            case R.id.MalaysiaReliefAgencyLl:
                Intent iii = new Intent(ListNGOsActivity.this,ViewDetailNgo3Activity.class);
                iii.putExtra("ngoName","Malaysian Relief Agency");
                startActivity(iii);
                break;
            case R.id.theHopeBranchLl:
                Intent iv = new Intent(ListNGOsActivity.this,ViewDetailNgo4Activity.class);
                iv.putExtra("ngoName","The Hope Branch");
                startActivity(iv);
                break;
            case R.id.ABIMll:
                Intent kv = new Intent(ListNGOsActivity.this,ViewDetailNgo5Activity.class);
                kv.putExtra("ngoName","Angkatan Belia Islam Malaysia");
                startActivity(kv);
                break;
            case R.id.SMSALl:
                    Intent vi = new Intent(ListNGOsActivity.this,ViewDetailNGO6Activity.class);
                vi.putExtra("ngoName","Selangor Muslim Students Association (PEPIAS)");
                startActivity(vi);
                break;
            case R.id.HASLl:
                Intent vii = new Intent(ListNGOsActivity.this,ViewDetailNgo7Activity.class);
                vii.putExtra("ngoName","Human Aid Selangor");
                startActivity(vii);
                break;
            case R.id.IMLl:
                Intent ix = new Intent(ListNGOsActivity.this,ViewDetailNgo8Activity.class);
                ix.putExtra("ngoName","Impactive Malaysia");
                startActivity(ix);
                break;
            case R.id.YAMLl:
                Intent viii = new Intent(ListNGOsActivity.this,ViewDetailNgo9Activity.class);
                viii.putExtra("ngoName","Yayasan Amal Malaysia");
                startActivity(viii);
                break;
            case R.id.IMARETSLl:
                    Intent x = new Intent(ListNGOsActivity.this,ViewDetailNgo10Activity.class);
                x.putExtra("ngoName","IMARET");
                startActivity(x);
                break;
            case R.id.myCareLl:
                    Intent xi = new Intent(ListNGOsActivity.this,ViewDetailngo11Activity.class);
                xi.putExtra("ngoName","myCARE");
                startActivity(xi);
                break;
            case R.id.GlobalPeaceLl:
                Intent xii = new Intent(ListNGOsActivity.this,ViewDetailNgo12Activity.class);
                xii.putExtra("ngoName","Global Peace Mission Malaysia");
                startActivity(xii);
                break;
            case R.id.MercyMalaysiaLl:
                Intent xiii = new Intent(ListNGOsActivity.this,ViewDetailNgo13Activity.class);
                xiii.putExtra("ngoName","Mercy Malaysia");
                startActivity(xiii);
                break;

            case R.id.SikhInsideLl:
                Intent xiv = new Intent(ListNGOsActivity.this,ViewDetailNgo14Activity.class);
                xiv.putExtra("ngoName","Sikh Inside");
                startActivity(xiv);
                break;

            case R.id.kembaraKitchenLl:
                Intent xv = new Intent(ListNGOsActivity.this,ViewDetailNgo15Activity.class);
                xv.putExtra("NGONAME","Kembara Kitchen");
                startActivity(xv);
                break;
            case R.id.womenGirlsLl:
                Intent xvi = new Intent(ListNGOsActivity.this,ViewDetailNgo16Activity.class);
                xvi.putExtra("NGONAME","WOMEN:GIRLS");
                startActivity(xvi);
                break;

        }
    }
}