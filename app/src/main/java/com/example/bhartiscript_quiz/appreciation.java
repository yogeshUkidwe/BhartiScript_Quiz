package com.example.bhartiscript_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class appreciation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appreciation);
    }
    //try again activity to activity_quiz
    public void try_again(View v){
        Intent intent = new Intent(this,Activity_quiz.class);
        startActivity(intent);
    }
}