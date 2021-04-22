package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class LoginHere extends AppCompatActivity {
    private Button loginbtn;
    private  EditText email,pass;
    private TextView forget,forsignup;
    private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        loginbtn = findViewById(R.id.loginBtn);
        email = findViewById(R.id.emaillogin);
        pass = findViewById(R.id.password);
        forget = findViewById(R.id.forgePass);
        forsignup= findViewById(R.id.signuphere);
        awesomeValidation.addValidation(this,R.id.emaillogin, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this,R.id.password,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",R.string.passerror);
        forsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginHere.this,SignUp.class);
                startActivity(i);
                finish();
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (v == loginbtn) {
                    submitForm();
                }

            }
        });
    }
        private void submitForm() {
            //first validate the form then move ahead
            //if this becomes true that means validation is successfull
            if (awesomeValidation.validate()) {
                Toast.makeText(LoginHere.this, "Validation Successfull", Toast.LENGTH_LONG).show();

                Intent i=new Intent(LoginHere.this,HomePage.class);
                startActivity(i);
                finish();
            }
        }


}