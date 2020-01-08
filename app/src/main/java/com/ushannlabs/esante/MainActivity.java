package com.ushannlabs.esante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    //declaration des variables
    private  Button btnAnalyse;
    private  Button btnComptRendu;
    private  Button btnAntecedent;
    private  Button btnPrescription;
    private  Button btnDirective;
    private  Button btnHistorique;
    private  Button btnParents;
    private  Button btnVisibility;


    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //assignation des objets aux variables
        btnAnalyse = findViewById(R.id.btn_anal);
        btnComptRendu = findViewById(R.id.btn_cmptRnd);
        btnAntecedent = findViewById(R.id.btn_antecedent);
        btnPrescription = findViewById(R.id.btn_prescription);
        btnDirective = findViewById(R.id.btn_directive);
        btnHistorique = findViewById(R.id.btn_historique);
        btnParents = findViewById(R.id.btn_parents);
        btnVisibility = findViewById(R.id.btn_visibility);



        //action de chaque bouton


        btnAnalyse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //load the main activity
                Intent mainActivity = new Intent(getApplicationContext(),Analyse.class);
                startActivity(mainActivity);
            }
        });




        btnComptRendu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //load the main activity
                Intent mainActivity = new Intent(getApplicationContext(),Compte_rendu.class);
                startActivity(mainActivity);
            }
        });

        btnAntecedent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //load the main activity
                Intent mainActivity = new Intent(getApplicationContext(),Antecedent.class);
                startActivity(mainActivity);
            }
        });



        btnPrescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //load the main activity
                Intent mainActivity = new Intent(getApplicationContext(),Prescription.class);
                startActivity(mainActivity);
            }
        });


        btnHistorique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //load the main activity
                Intent mainActivity = new Intent(getApplicationContext(),Historique.class);
                startActivity(mainActivity);
            }
        });



        btnParents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //load the main activity
                Intent mainActivity = new Intent(getApplicationContext(),Parents.class);
                startActivity(mainActivity);
            }
        });


        btnVisibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //load the main activity
                Intent mainActivity = new Intent(getApplicationContext(),Visibility.class);
                startActivity(mainActivity);
            }
        });


        btnDirective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //load the main activity
                Intent mainActivity = new Intent(getApplicationContext(),Directive.class);
                startActivity(mainActivity);
            }
        });



    }//end
}
