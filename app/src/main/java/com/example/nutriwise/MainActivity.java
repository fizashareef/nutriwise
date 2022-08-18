 package com.example.nutriwise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;


 public class MainActivity extends AppCompatActivity {
         final Handler h= new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        h.postDelayed(() -> {
            Intent i=new Intent (MainActivity.this,LoginActivity.class);
            startActivity(i);
            finish();
        }, 3000);


    }
}