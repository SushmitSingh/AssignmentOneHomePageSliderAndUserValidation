package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(() -> {
            // This method will be executed once the timer is over
            Intent i = new Intent(MainActivity.this, SignUp.class);
            startActivity(i);
            finish();
        }, 1500);
    }
}