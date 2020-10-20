package com.example.bhartiscript_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Button login
    public void Activity_profile(View view){
        Intent intent = new Intent(this, Activity_profile.class);
        startActivity(intent);
    }

    //Activity 1 BharatiScript INTRO
    public void Activity_bhartiScript(View view){
        Intent intent = new Intent(this, Activity_bhartiScript.class);
        startActivity(intent);
    }

    //Activity 2 Bharatiscript quiz
    public void Activity_quiz(View view){
        Intent intent = new Intent(this,Level_selection.class);
        startActivity(intent);
    }

    //Activity 3 Bharatiscript Certificate
    public void Activity_certificate(View view){
        Intent intent = new Intent(this, Activity_mudra_bharati.class);
        startActivity(intent);
    }

    //Activity 4 Bharatiscript Translate
    public void Activity_translate(View view){
        Intent intent = new Intent(this, Activity_translate.class);
        startActivity(intent);
    }

    //Activity 5 Bharatiscript translate to Bharati
    public void Activity_translateB(View view){
        Intent intent = new Intent(this, Activity_artwork.class);
        startActivity(intent);
    }
    //Activity 6 Bharatiscript about us
    public void Activity_contact(View view){
        Intent intent = new Intent(this, Activity_contact.class);
        startActivity(intent);
    }



}