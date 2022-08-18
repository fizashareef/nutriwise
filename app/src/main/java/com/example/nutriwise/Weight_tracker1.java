package com.example.nutriwise;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Weight_tracker1 extends AppCompatActivity {
    private int progress=0;
    private ProgressBar progressBar;
    private TextView  textViewProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_tracker1);
        progressBar = findViewById(R.id.progress_bar);
        textViewProgress = findViewById(R.id.text_view_progress);

        progressBar.setProgress(0);
        textViewProgress.setText("0%");
    }
    public void onClickUp()
    {
        if (progress <= 90)
        {
            progress += 10;
            updateProgressBar();
        }
        String toastMessage1 = "Weight gain successfully updated!!";
        Toast.makeText(getApplicationContext(), toastMessage1, Toast.LENGTH_SHORT).show();
    }

    public void onClickLow()
    {
        if (progress >= 10)
        {
            progress -= 10;
            updateProgressBar();
        }
        String toastMessage2 = "Weight loss successfully updated!!";
        Toast.makeText(getApplicationContext(), toastMessage2, Toast.LENGTH_SHORT).show();
    }


    @SuppressLint("SetTextI18n")
    private void updateProgressBar()
    {
        progressBar.setProgress(progress);
        textViewProgress.setText(progress + "kg");
    }

}

