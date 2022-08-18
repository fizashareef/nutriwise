package com.example.nutriwise;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AlreadyUser extends AppCompatActivity {

    CheckBox checkBoxShow;
    EditText editTextUserName,editTextPassword;
    Button buttonLog;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        editTextUserName= findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLog = findViewById(R.id.buttonLog);

        checkBoxShow= findViewById(R.id.checkBoxShow);
        checkBoxShow.setOnCheckedChangeListener((buttonLog,isChecked)->
        {
            if (isChecked)
            {
                checkBoxShow.setText("Hide password");
                editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                editTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else
            {
                checkBoxShow.setText("Show password");
                editTextPassword.setInputType(InputType.TYPE_CLASS_TEXT| InputType.TYPE_TEXT_VARIATION_PASSWORD);
                editTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });

        buttonLog.setOnClickListener(v ->
        {
            if (editTextUserName.getText().length() > 0 &&  editTextPassword.getText().length() > 0)
            {
                String toastMessage = "Username: " + editTextUserName.getText().toString() + ", Password: " + editTextPassword.getText().toString();
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
            } else
            {
                String toastMessage = "Username or Password are not populated";
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
            }
        });
        Intent i=new Intent (AlreadyUser.this,DashBoard.class);
        startActivity(i);
        }

    }