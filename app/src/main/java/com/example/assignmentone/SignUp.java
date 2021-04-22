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

public class SignUp extends AppCompatActivity {
        private Button signUp;
        private EditText email,name,mobile,password;
        private TextView Login;
      private AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUp=findViewById(R.id.signupbtn);

        email=findViewById(R.id.emailsignup);
        name=findViewById(R.id.name);
        mobile=findViewById(R.id.mobilesign);
        password=findViewById(R.id.passsign);
        Login=findViewById(R.id.Loginfor);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this, R.id.name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this,R.id.emailsignup, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.mobilesign, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this,R.id.passsign,"^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$",R.string.passerror);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SignUp.this,LoginHere.class);
                startActivity(i);
                finish();
            }
        });

         signUp.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
                 if (v == signUp) {
                     submitForm();
                 }

             }
         });
    }
    private void submitForm() {
        //first validate the form then move ahead
        //if this becomes true that means validation is successfull
        if (awesomeValidation.validate()) {
            Toast.makeText(this, "Validation Successfull", Toast.LENGTH_LONG).show();

            //process the data further
            Intent i=new Intent(SignUp.this,HomePage.class);
            startActivity(i);
            finish();
        }
    }



}