package com.example.bhartiscript_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class Activity_bhartiScript extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
public static int language_number =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bharti_script);
        Spinner aSpinner = findViewById(R.id.spinner);
        aSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        language_number = i;
        Toast.makeText(this, adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, "Please select alternate language", Toast.LENGTH_SHORT).show();
    }
    public void language_study(View view){
        Intent intent = new Intent(this, study_languages.class);
        startActivity(intent);
    }

}