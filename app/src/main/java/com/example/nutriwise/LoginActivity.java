package com.example.nutriwise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.view.View;


public class LoginActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    Button buttonSign, buttonalready;
    EditText editTextName,editTextEmail,editTextPhone,editTextAge,editTextWeight,editTextHeight;
    String user_name,user_mail,user_Phone,user_age,user_weight,user_height, user_genderString;

    private final String fill_user_name="Please enter user name:";
    private final String fill_user_mail="Please enter user mail:";
    private final String fill_user_phone="Please enter user phone number:";
    private final String fill_user_phone_invalid="Please enter valid phone number:";
    private final String fill_user_age="Please enter user age:";
    private final String fill_user_weight="Please enter user weight:";
    private final String fill_user_height="Please enter user height:";
    private final String TAG=LoginActivity.class.getSimpleName();




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    public void init() {
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextAge = findViewById(R.id.editTextAge);
        user_genderString = " ";
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(((group, checkedId) ->
        {
            if (checkedId == R.id.male) {
                user_genderString = "male";
                Log.d(TAG, "male selected" + user_genderString);
            } else if (checkedId == R.id.female) {
                user_genderString = "female";
                Log.d(TAG, "female selected" + user_genderString);
            }
        }
        ));
        buttonalready=findViewById(R.id.buttonalready);
        buttonSign = findViewById(R.id.buttonSign);
        buttonSign.setOnClickListener((view) -> {

            user_name = editTextName.getText().toString().trim();
            user_mail = editTextEmail.getText().toString().trim();
            user_Phone = editTextPhone.getText().toString().trim();
            user_height = editTextHeight.getText().toString().trim();
            user_weight = editTextWeight.getText().toString().trim();
            user_age = editTextAge.getText().toString().trim();
            if (user_name.equalsIgnoreCase(" ")) {
                Toast.makeText(LoginActivity.this, fill_user_name, Toast.LENGTH_SHORT).show();
            } else if (user_mail.equalsIgnoreCase(" ")) {
                Toast.makeText(LoginActivity.this, fill_user_mail, Toast.LENGTH_SHORT).show();
            } else if (user_Phone.equalsIgnoreCase(" ")) {
                Toast.makeText(LoginActivity.this, fill_user_phone, Toast.LENGTH_SHORT).show();
            } else if (user_Phone.length() != 10) {
                Toast.makeText(LoginActivity.this, fill_user_phone_invalid, Toast.LENGTH_SHORT).show();
            } else if (user_weight.equalsIgnoreCase(" ")) {
                Toast.makeText(LoginActivity.this, fill_user_weight, Toast.LENGTH_SHORT).show();
            } else if (user_height.equalsIgnoreCase(" ")) {
                Toast.makeText(LoginActivity.this, fill_user_height, Toast.LENGTH_SHORT).show();
            } else if (user_age.equalsIgnoreCase(" ")) {
                Toast.makeText(LoginActivity.this, fill_user_age, Toast.LENGTH_SHORT).show();
            }
        });
        buttonSign.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent i = new Intent(LoginActivity.this, DashBoard.class);
                startActivity(i);
                finish();
            }

        });
        buttonalready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(LoginActivity.this,AlreadyUser.class);
                startActivity(in);
                finish();
            }
        });



    }

    }

