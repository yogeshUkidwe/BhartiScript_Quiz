package com.example.bhartiscript_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class sponsers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsers);
    }
    public void sponsers1(View view){
        Uri PrimersUri = Uri.parse("https://www.cholainsurance.com/");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }
    public void sponsers2(View view){
        Uri PrimersUri = Uri.parse("https://www.bharatiscript.com/#sponsors-popup");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }
    public void sponsers3(View view){
        Uri PrimersUri = Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSc-_0YGkhd84SsR6SfYp4s56IsfjUAvCijGg_gHLDIgN1YPBA/viewform");
        startActivity(new Intent(Intent.ACTION_VIEW, PrimersUri));
    }
}