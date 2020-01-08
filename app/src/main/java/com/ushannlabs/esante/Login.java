package com.ushannlabs.esante;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ushannlabs.esante.Model.Common;
import com.ushannlabs.esante.Model.User;

import java.util.EventListener;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Login extends AppCompatActivity {

    private Button btnlogin;
    private EditText mail;
    private EditText password;
    private FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

Common common;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //init components
        btnlogin=findViewById(R.id.btnLogin);
        mail=findViewById(R.id.editMail);
        password=findViewById(R.id.editPasseWord);


        firebaseAuth = FirebaseAuth.getInstance();
        common = new Common(Login.this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (common.isConnectedToInternet()) {

                    String email = mail.getText().toString().trim();
                    String pwd = password.getText().toString().trim();

                        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pwd)) {
                            Toast.makeText(Login.this, "Entrer votre adresse email et votre mot de passe", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (password.length() < 6) {
                            Toast.makeText(Login.this, "Mot de passe trop court, minimum 6 caracteres", Toast.LENGTH_SHORT).show();
                            return;
                        }


                    firebaseAuth.signInWithEmailAndPassword(email, pwd)
                            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {
                                        myProgress();
                                        Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(mainActivity);

                                    } else {
                                        new SweetAlertDialog(Login.this, SweetAlertDialog.ERROR_TYPE)
                                                .setTitleText("Oops...").setContentText("Identifiant et/ou mot de passe incorrect").show();

                                        //Toast.makeText(Login.this, "Identifiant et/ou mot de passe incorrect", Toast.LENGTH_SHORT).show();

                                    }


                                    // ...
                                }
                            });//fin firebase auth

                }else {
                  Toast.makeText(Login.this,"Veuillez verifier votre connexion internet",Toast.LENGTH_SHORT).show();
                  return;

                }


            }//inf onclick
        });


    }//fin on create

    @Override
    public void onBackPressed() {
        progressDialog.dismiss();
    }

    public void myProgress(){

        //initialize progress dialogue


        /*SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Patientez...");
        pDialog.setCancelable(false);*/





        progressDialog = new ProgressDialog(Login.this);
        //show
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        //set transparent
        progressDialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );


    }
}
